package co.anywhr.mapper;

import co.anywhr.dto.HexagonDTO;
import co.anywhr.dto.HexagonUI;
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

    default HexagonUI mapForUI(Hexagon entity) {
        final HexagonUI ui = new HexagonUI();
        ui.setQ(entity.getCoordinateX());
        ui.setR(entity.getCoordinateY() - (entity.getCoordinateX()/2));
        return ui;
    }
}
