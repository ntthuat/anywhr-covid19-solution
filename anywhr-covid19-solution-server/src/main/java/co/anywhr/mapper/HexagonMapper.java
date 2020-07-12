package co.anywhr.mapper;

import co.anywhr.dto.HexagonDTO;
import co.anywhr.entity.Hexagon;
import org.mapstruct.*;

/**
 * @author ntthuat
 */
@Mapper
public interface HexagonMapper {

    HexagonDTO map(Hexagon entity);

    @InheritInverseConfiguration
    Hexagon map(HexagonDTO dto);
}
