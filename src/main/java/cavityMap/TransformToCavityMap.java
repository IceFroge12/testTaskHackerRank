package cavityMap;

import exceptions.UnacceptableArgumentException;


/**
 * Created by yuriygubar on 7/6/17.
 */
public interface TransformToCavityMap {

    /**
     * Transform square, replacing cavity cell on "X" character.
     * Cell of the map is cavity if and only if this cell is not on the border of the map and each cell adjacent to it has strictly smaller depth. Two cells are adjacent if they have a common side (edge).
     * @param initMap initial square array
     * @return new String square array with replaced cells
     * @throws UnacceptableArgumentException if array is null or array is not square;
     */
    String[][] transformToCavity(String initMap) throws UnacceptableArgumentException;
}
