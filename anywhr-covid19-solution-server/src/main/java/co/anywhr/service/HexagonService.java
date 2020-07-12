package co.anywhr.service;

import co.anywhr.dto.HexagonDTO;
import co.anywhr.dto.NewHexagonParams;

/**
 * @author ntthuat
 */
public interface HexagonService {

    HexagonDTO findByName(String name);

    HexagonDTO createHexagon(NewHexagonParams params);

    void deleteFreeHexagon(String name);
}
