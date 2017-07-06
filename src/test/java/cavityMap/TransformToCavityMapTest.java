package cavityMap;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by yuriygubar on 7/6/17.
 */
public class TransformToCavityMapTest {
    private String initMap;
    private TransformToCavityMap transformToCavityMap = new TransformToCavityMapImpl();

    @Before
    public void init() {
        initMap = "4\n"+
                "1112\n"+
                "1912\n"+
                "1892\n"+
                "1234";

    }


    @Test
    public void transformToCavity() throws Exception {
        String[][] transformedMap = transformToCavityMap.transformToCavity(initMap);
        printMap(transformedMap);
    }




    private void printMap(String[][]map){
        for (String[] aMap : map) {
            for (String anAMap : aMap) {
                System.out.print(anAMap);
            }
            System.out.println();
        }

    }

}