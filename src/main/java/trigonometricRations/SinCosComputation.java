package trigonometricRations;

import exceptions.UnacceptableArgumentException;

import java.util.List;

/**
 * Interface for Sin and Cos functions computation.
 *
 * @author  yuriygubar on 7/6/17.
 */
public interface SinCosComputation {
    /**
     *
     * @param n - number of test cases.
     * @param valuesArray - array with radians values for each test.
     * @return Return a list object containing values of Sin(radians) and Cos(radians).
     * @exception UnacceptableArgumentException On invalid initial argument
     */
    List<ResultObject> compute(int n, double[] valuesArray) throws UnacceptableArgumentException;
}
