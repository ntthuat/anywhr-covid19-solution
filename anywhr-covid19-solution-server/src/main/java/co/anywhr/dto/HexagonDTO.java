package co.anywhr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author ntthuat
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HexagonDTO {

    private String name;

    private Integer coordinateX;

    private Integer coordinateY;

    private Map<Integer, String> neighbors;
}
