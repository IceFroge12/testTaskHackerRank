package trigonometricRations;

import exceptions.UnacceptableArgumentException;

import java.util.List;

/**
 * Created by yuriygubar on 7/6/17.
 */
public interface SinCosComputationByString {
    /**
     *
     *
     * <ul>
     * <li>If the n argument is less then 1 or grater then 50, then throws UnacceptableArgumentException.
     * <li>If the x value for any test case is out of the span (0, 10), then throws UnacceptableArgumentException.
     *
     * @param paramList - String, composed by line, that represents initial parameters. First line - count of test cases.
     *                 Subsequent lines - value of radians for each test case
     * @return Return an object containing values of Sin(radians) and Cos(radians).
     * @throws UnacceptableArgumentException On invalid initial argument
     */
    List<ResultObject> compute(String paramList) throws UnacceptableArgumentException;

}
