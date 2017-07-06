package fibonacci;

import exceptions.UnacceptableArgumentException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by yuriygubar on 7/6/17.
 */
public class FibonacciModifiedTest {

    private Fibonacci fibonacci;
    private FibonacciByString fibonacciByString;
    private static final BigInteger expectedResult1 = BigInteger.valueOf(5);
    private static final String paramForExpectedResult1 = "0 1 5";

    @Before
    public void init(){
        fibonacci = new FibonacciModified();
        fibonacciByString = new FibonacciModifiedByString(fibonacci);


    }

    @Test
    public void DoComputeWithExpectedResultByString() throws UnacceptableArgumentException {
        assertEquals(fibonacciByString.compute(paramForExpectedResult1), expectedResult1);
    }

    @Test
    public void DoComputeWithExpectedResult() throws UnacceptableArgumentException {
        assertEquals(fibonacci.compute(0, 1, 5), expectedResult1);
    }


    @Test(expected = UnacceptableArgumentException.class)
    public void DoComputeWithOutOfRangeValues() throws UnacceptableArgumentException {
        fibonacci.compute(12,3,1);
    }

}