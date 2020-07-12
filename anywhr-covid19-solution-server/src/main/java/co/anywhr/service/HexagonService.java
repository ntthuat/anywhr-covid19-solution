package co.anywhr.service;

import co.anywhr.dto.HexagonDTO;
import co.anywhr.dto.HexagonUI;
import co.anywhr.dto.NewHexagonParams;

import java.util.List;

/**
 * @author ntthuat
 */
public interface HexagonService {

    List<HexagonUI> findAll();

    HexagonDTO findByName(String name);

    HexagonDTO createHexagon(NewHexagonParams params);

    void deleteFreeHexagon(String name);
}
