package trigonometricRations;

import exceptions.UnacceptableArgumentException;

import java.util.ArrayList;
import java.util.List;

/**
 * An Implementation of algorithm, that calculate Sin and Cos value using Trigonometric Ratios
 *
 * @author yuriygubar on 7/6/17.
 */
public class TrigonometricSinCosComputation implements SinCosComputation {
    /**
     * The value, that represents series count;
     */
    private static final int SERIES_COUNT = 5;

    /**
     * The message that is used with inappropriate <i>n</i>initial value.
     */
    private static final String N_RANGE_VIOLATION_MESSAGE = "Unacceptable initial values range, n must be in [1, 50] span";


    /**
     * The message that is used with inappropriate <i>x</i>initial value.
     */
    private static final String X_VALUE_VIOLATION_MESSAGE = "Unacceptable initial values range, each x value must be in [0, 10] span";


    /**
     * The value, that represents maximum decimal places count;
     */
    private static final int MAX_DECIMAL_PLACES = 2;


    /**
     *
     * <p>
     * <ul>
     * <li>If the n argument is less then 1 or grater then 50, then throws UnacceptableArgumentException.
     * <li>If the x value for any test case is out of the span (0, 10), then throws UnacceptableArgumentException.
     *
     * @param n - number of test cases.
     * @param valuesArray - array with radians values for each test.
     * @return Return an object containing values of Sin(radians) and Cos(radians).
     * @throws UnacceptableArgumentException On invalid initial argument
     */
    @Override
    public List<ResultObject> compute(int n, double[] valuesArray) throws UnacceptableArgumentException {
        checkConstraints(n, valuesArray);
        List<ResultObject> resultObjectList = new ArrayList<>(n);
        for (double v : valuesArray) {
            double sin = 0, cos = 0;
            double a = v;
            double b = 1;
            int c = 1;
            int d = 0;
            double e = 1;

            for (int i = SERIES_COUNT; i > 0; --i) {
                sin += e * a / factorial(c);
                cos += e * b / factorial(d);

                a *= Math.pow(v, 2);
                b *= Math.pow(v, 2);
                c += 2;
                d += 2;
                e *= -1;
            }
            resultObjectList.add(new ResultObject(sin, cos, v));

        }
        return resultObjectList;
    }

    /**
     * Check constraints for initial data
     * @param n count of test cases
     * @param valuesArray radians values for each test case
     * @throws UnacceptableArgumentException On wrong initial value
     */
    private void checkConstraints(int n, double[] valuesArray) throws UnacceptableArgumentException {
        if (n < 1 || n > 50) {
            throw new UnacceptableArgumentException(N_RANGE_VIOLATION_MESSAGE);
        } else {
            for (double v : valuesArray) {
                if (v <= 0 || v >= 10 && checkNumberOfDecimalPlaces(v)) {
                    throw new UnacceptableArgumentException(X_VALUE_VIOLATION_MESSAGE);
                }
            }
        }
    }

    /**
     * Check count of decimal places
     * @param v radian value
     * @return boolean
     */
    private boolean checkNumberOfDecimalPlaces(double v){
        String text = Double.toString(Math.abs(v));
        int integerPlaces = text.indexOf('.');
        int decimalPlaces = text.length() - integerPlaces - 1;
        return decimalPlaces <= MAX_DECIMAL_PLACES;
    }

    /**
     * @param n integer number
     * @return n factorial
     */
    private double factorial(int n) {
        return (n <= 1) ? 1 : n * factorial(n - 1);
    }
}
