package co.anywhr.rules;

/**
 * @author ntthuat
 */
public interface HexagonRule {

    int[] findCoordinates(int coordinateX, int coordinateY, int border);

    int findOppositeBorderByBorder(int border);
}
