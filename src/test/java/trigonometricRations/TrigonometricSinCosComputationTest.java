package trigonometricRations;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yuriygubar on 7/6/17.
 */
public class TrigonometricSinCosComputationTest {

    private double[] initialParam = null;
    private int testCaseCount;

    private final String initialParamString =
            "5\n" +
                    "2.83\n" +
                    "3.24\n" +
                    "0.99\n" +
                    "2.74\n" +
                    "5.04";


    @Before
    public void init() {
        initialParam = new double[]{2.83, 3.24, 0.99, 2.74, 5.04};
        testCaseCount = 5;
    }


    @Test
    public void compute() throws Exception {
        SinCosComputation sinCosComputation = new TrigonometricSinCosComputation();
        printResult(sinCosComputation.compute(testCaseCount, initialParam));
    }

    @Test
    public void computeString() throws Exception {
        SinCosComputation sinCosComputation = new TrigonometricSinCosComputation();
        SinCosComputationByString sinCosComputationParamString = new TrigonometricSinCosComputationByString(sinCosComputation);
        printResult(sinCosComputationParamString.compute(initialParamString));
    }


    private void printResult(List<ResultObject> resultObjectList) {
        resultObjectList.forEach(resultObject -> {
            System.out.println(resultObject.getSinValues());
            System.out.println(resultObject.getCosValues());
        });
    }



}