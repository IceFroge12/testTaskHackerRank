package utopiaTree;

import exceptions.UnacceptableArgumentException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yuriygubar on 7/6/17.
 */
public class UtopiaTreeTest {

    private String initParam;
    private int[] growRate;
    private String invalidInputString;
    private String invalidInputValuesTestCasesCount;
     private UtopiaTree utopiaTree;

    @Before
    public void init(){
        initParam = "3\n"+
                "0\n"+
                "1\n"+
                "4";
        growRate = new int[]{1, 2, 7};
        invalidInputString = "kq\n" +
                "3\n"+
                "2\n"+
                "2";
        invalidInputValuesTestCasesCount = "3\n" +
                "3\n"+
                "2\n";
        utopiaTree = new UtopiaTree();
    }



    @Test
    public void makeTestCaseSuccess() throws Exception {
        assertArrayEquals(growRate, utopiaTree.makeNTestCase(initParam));
    }

    @Test(expected = UnacceptableArgumentException.class)
    public void makeTestCaseInvalidInputString() throws UnacceptableArgumentException {
        utopiaTree.makeNTestCase(invalidInputString);
    }

    @Test(expected = UnacceptableArgumentException.class)
    public void makeTestCaseInvalidCountOfValuesForTestCases() throws UnacceptableArgumentException {
        utopiaTree.makeNTestCase(invalidInputValuesTestCasesCount);
    }


}