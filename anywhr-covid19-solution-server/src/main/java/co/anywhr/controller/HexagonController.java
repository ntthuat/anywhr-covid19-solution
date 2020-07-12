package co.anywhr.controller;

import co.anywhr.dto.HexagonDTO;
import co.anywhr.dto.HexagonUI;
import co.anywhr.dto.NewHexagonParams;
import co.anywhr.service.HexagonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ntthuat
 */
@Slf4j
@RestController
@RequestMapping("/hexagon")
@AllArgsConstructor
public class HexagonController {

    final HexagonService service;

    @GetMapping()
    public List<HexagonUI> allHexagons() {
        return service.findAll();
    }

    @GetMapping("/{name}")
    public HexagonDTO hexagonByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HexagonDTO hexagonByNeighbor(@ModelAttribute NewHexagonParams params) {
        return service.createHexagon(params);
    }

    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void freeHexagon(@PathVariable String name) {
        service.deleteFreeHexagon(name);
    }
}
