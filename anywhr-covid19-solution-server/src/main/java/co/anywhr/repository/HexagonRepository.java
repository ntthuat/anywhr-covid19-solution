package co.anywhr.repository;

import co.anywhr.entity.Hexagon;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author ntthuat
 */
@Repository
public interface HexagonRepository extends RepositoryExtensions<Hexagon, Long>, JpaSpecificationExecutor<Hexagon> {

    List<Hexagon> findAll();

    Optional<Hexagon> findByName(String name);

    Optional<Hexagon> findByCoordinateXAndCoordinateY(Integer x, Integer y);

}
