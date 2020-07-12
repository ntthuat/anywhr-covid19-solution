package co.anywhr.service.impl;

import co.anywhr.dto.HexagonDTO;
import co.anywhr.dto.NewHexagonParams;
import co.anywhr.entity.Hexagon;
import co.anywhr.exception.ResourceNotFoundException;
import co.anywhr.mapper.HexagonMapper;
import co.anywhr.repository.HexagonRepository;
import co.anywhr.rules.HexagonRule;
import co.anywhr.service.HexagonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @author ntthuat
 */
@Service
@AllArgsConstructor
public class HexagonServiceImpl implements HexagonService {

    final HexagonRepository repository;

    final HexagonMapper mapper;

    final HexagonRule rule;

    @Override
    public HexagonDTO findByName(String name) {
        final Hexagon entity = findHexagonEntityByName(name);
        final HexagonDTO dto = mapper.map(entity);
        final Map<Integer, String> neighbors = findNeighbors(entity);
        dto.setNeighbors(neighbors);
        return dto;
    }

    @Override
    public HexagonDTO createHexagon(NewHexagonParams params) {
        final Hexagon entity = findHexagonEntityByName(params.getNeighborName());
        final int[] coordinates = rule.findCoordinates(entity.getCoordinateX(), entity.getCoordinateY(), params.getBorderNo());
        final Optional<Hexagon> checkedHexagon = repository.findByCoordinateXAndCoordinateY(coordinates[0], coordinates[1]);

        if (checkedHexagon.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("Hexagon's neighbor of %s at position border %d already existed", params.getNeighborName(), params.getBorderNo()));
        }

        final Hexagon newHexagon = Hexagon.builder()
                .coordinateX(coordinates[0])
                .coordinateY(coordinates[1])
                .name(params.getName())
                .build();

        final HexagonDTO dto = mapper.map(repository.save(newHexagon, true));
        final Map<Integer, String> neighbors = findNeighbors(newHexagon);
        dto.setNeighbors(neighbors);

        return dto;
    }

    @Override
    public void deleteFreeHexagon(String name) {
        final Hexagon entity = findHexagonEntityByName(name);
        final HexagonDTO dto = mapper.map(entity);
        final Map<Integer, String> neighbors = findNeighbors(entity);
        dto.setNeighbors(neighbors);
        AtomicBoolean canBeRemoval = new AtomicBoolean(true);

        dto.getNeighbors().forEach((key, value) -> {
            final Hexagon neighborEntity = findHexagonEntityByName(value);
            final Map<Integer, String> checkingNeighbors = findNeighbors(neighborEntity);
            if (checkingNeighbors.size() == 1) canBeRemoval.set(false);
        });

        if (canBeRemoval.get()) {
            repository.delete(entity);
        } else {
            throw new ResponseStatusException(BAD_REQUEST, String.format("Cannot delete Hexagon %s because it's the ONLY connecting hexagon between two hotspots", name));
        }
    }

    private Map<Integer, String> findNeighbors(Hexagon entity) {
        final Map<Integer, String> neighbors = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            int[] coordinates = rule.findCoordinates(entity.getCoordinateX(), entity.getCoordinateY(), i);
            Optional<Hexagon> neighbor = repository.findByCoordinateXAndCoordinateY(coordinates[0], coordinates[1]);
            if (neighbor.isPresent()) {
                neighbors.put(i, neighbor.get().getName());
            }
        }
        return neighbors;
    }

    private Hexagon findHexagonEntityByName(String name) {
        final Optional<Hexagon> entityOpt = repository.findByName(name);
        if (entityOpt.isPresent()) {
            return entityOpt.get();
        } else {
            throw new ResourceNotFoundException(Hexagon.class, name);
        }
    }
}
