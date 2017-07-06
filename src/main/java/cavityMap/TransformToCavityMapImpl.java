package cavityMap;

import exceptions.UnacceptableArgumentException;

/**
 * Class for finding all the cavities on the map and depict them with the uppercase character X.
 *
 * @author by yuriygubar on 7/6/17.
 */

public class TransformToCavityMapImpl implements TransformToCavityMap {

    class MappedParameters {
        int n;
        String[][] line;

        public MappedParameters(int n) {
            this.n = n;
            this.line = new String[n][n];
        }
    }


    /**
     * Message for exception caused by invalid array size;
     */

    /**
     * Message for Null pointer
     */
    private static final String NULL_ARRAY = "Initial setting can't be null";

    /**
     * Separator between lines
     */
    private static final String LINE_SEPARATOR = "\n";

    /**
     * Index of map size value in initial string
     */
    private static final int MAP_SIZE_INDEX = 0;

    /**
     * Message for exception caused by invalid array size;
     */
    private static final String ARRAY_SIZE_EXCEPTION = "Incorrect array size. Array must be square";


    /**
     * Transform square, replacing cavity cell on "X" character.
     * Cell of the map is cavity if and only if this cell is not on the border of the map and each cell adjacent to it has strictly smaller depth. Two cells are adjacent if they have a common side (edge).
     *
     * @param initialString initial string composed by map size and map data
     * @return new String square array with replaced cells
     * @throws UnacceptableArgumentException if array is null or array is not square;
     */
    @Override
    public String[][] transformToCavity(String initialString) throws UnacceptableArgumentException {

        if (initialString == null){
            throw new UnacceptableArgumentException(NULL_ARRAY);
        }

        MappedParameters mappedParameters = mapStringToParams(initialString);
        String[][] transformedMap = new String[mappedParameters.line.length][mappedParameters.line.length];
        for (int i = 0; i < mappedParameters.line.length; i++) {
            for (int j = 0; j < mappedParameters.line[i].length; j++) {
                if (isBoundary(i, j, mappedParameters.line)) {
                    transformedMap[i][j] = String.valueOf(mappedParameters.line[i][j]);
                } else {
                    if (isCavity(i, j, mappedParameters.line)) {
                        transformedMap[i][j] = "X";
                    } else {
                        transformedMap[i][j] = String.valueOf(mappedParameters.line[i][j]);
                    }
                }
            }
        }
        return transformedMap;
    }

    private MappedParameters mapStringToParams(String paramList) throws UnacceptableArgumentException {

        String[] list = paramList.split(LINE_SEPARATOR);
        MappedParameters mappedParameters = null;

        int mapSize = Integer.parseInt(list[MAP_SIZE_INDEX]);
        if (mapSize != list.length - 1) {
            throw new UnacceptableArgumentException(ARRAY_SIZE_EXCEPTION);
        }
        mappedParameters = new MappedParameters(mapSize);
        for (int i = 1; i < list.length; i++) {
            if (list[i].length() != mapSize) {
                throw new UnacceptableArgumentException(ARRAY_SIZE_EXCEPTION);
            }
            mappedParameters.line[i -1] = list[i].split("");
        }

        return mappedParameters;

    }

    /**
     * Check belonging of (i,j) element to array boundary
     *
     * @param i       x-axis
     * @param j       y-axis
     * @param initMap initial array
     * @return boolean value, corresponding to belonging of element(i,j) to array boundary.
     */
    private boolean isBoundary(int i, int j, String[][] initMap) {
        return i == 0 || i == initMap.length - 1 || j == 0 || j == initMap[i].length - 1;
    }

    /**
     * Check element(i,j) on cavity.
     *
     * @param i       x-axis
     * @param j       y-axis
     * @param initMap initial array
     * @return boolean value, shoving either element(i,j) is сavity or not.
     */
    private boolean isCavity(int i, int j, String[][] initMap) {
        return checkLeft(i, j, initMap) &&
                checkTop(i, j, initMap) &&
                checkRight(i, j, initMap) &&
                checkBottom(i, j, initMap);
    }

    /**
     * Compare element(i,j - 1) with element(i,j).
     *
     * @param i       x-axis
     * @param j       y-axis
     * @param initMap initial array
     * @return boolean value, shoving either element(i,j) greater then element(i, j-1).
     */
    private boolean checkLeft(int i, int j, String[][] initMap) {
        return Integer.valueOf(initMap[i][j - 1]) < Integer.valueOf(initMap[i][j]);
    }

    /**
     * Compare element(i -1,j) with element(i,j).
     *
     * @param i       x-axis
     * @param j       y-axis
     * @param initMap initial array
     * @return boolean value, shoving either element(i,j) greater then element(i - , j).
     */
    private boolean checkTop(int i, int j, String[][] initMap) {
        return Integer.valueOf(initMap[i - 1][j]) < Integer.valueOf(initMap[i][j]);

    }

    /**
     * Compare element(i,j + 1) with element(i,j).
     *
     * @param i       x-axis
     * @param j       y-axis
     * @param initMap initial array
     * @return boolean value, shoving either element(i,j) greater then element(i, j+1).
     */
    private boolean checkRight(int i, int j, String[][] initMap) {
        return Integer.valueOf(initMap[i][j + 1]) < Integer.valueOf(initMap[i][j]);
    }

    /**
     * Compare element(i - 1,j) with element(i,j).
     *
     * @param i       x-axis
     * @param j       y-axis
     * @param initMap initial array
     * @return boolean value, shoving either element(i,j) greater then element(i - 1, j).
     */
    private boolean checkBottom(int i, int j, String[][] initMap) {
        return Integer.valueOf(initMap[i + 1][j]) < Integer.valueOf(initMap[i][j]);
    }
}
