package co.anywhr.rules.impl;

import co.anywhr.rules.HexagonRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @author ntthuat
 */
@Slf4j
@Component
public class HexagonRuleImpl implements HexagonRule {

    @Override
    public int[] findCoordinates(int coordinateX, int coordinateY, int border) {

        int x;
        int y;

        if (coordinateX % 2 == 0) { // even case
            switch (border) {
                case 0:
                    x = coordinateX;
                    y = coordinateY - 1;
                    break;
                case 1:
                    x = coordinateX + 1;
                    y = coordinateY - 1;
                    break;
                case 2:
                    x = coordinateX + 1;
                    y = coordinateY;
                    break;
                case 3:
                    x = coordinateX;
                    y = coordinateY + 1;
                    break;
                case 4:
                    x = coordinateX - 1;
                    y = coordinateY;
                    break;
                case 5:
                    x = coordinateX - 1;
                    y = coordinateY - 1;
                    break;
                default:
                    throw new ResponseStatusException(BAD_REQUEST, "Not supported for position border " + border);
            }
        } else {
            switch (border) {
                case 0:
                    x = coordinateX;
                    y = coordinateY - 1;
                    break;
                case 1:
                    x = coordinateX + 1;
                    y = coordinateY;
                    break;
                case 2:
                    x = coordinateX + 1;
                    y = coordinateY + 1;
                    break;
                case 3:
                    x = coordinateX;
                    y = coordinateY + 1;
                    break;
                case 4:
                    x = coordinateX - 1;
                    y = coordinateY + 1;
                    break;
                case 5:
                    x = coordinateX - 1;
                    y = coordinateY;
                    break;
                default:
                    throw new ResponseStatusException(BAD_REQUEST, "Not supported for position border " + border);
            }
        }

        return new int[]{x, y};
    }

    @Override
    public int findOppositeBorderByBorder(int border) {
        switch (border) {
            case 0:
                return 3;
            case 1:
                return 4;
            case 2:
                return 5;
            case 3:
                return 0;
            case 4:
                return 1;
            case 5:
                return 2;
            default:
                throw new ResponseStatusException(BAD_REQUEST, "Not supported for position border " + border);
        }
    }


}
