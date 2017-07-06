package fibonacci;


import exceptions.UnacceptableArgumentException;

import java.math.BigInteger;

/**
 * Fibonacci algorithm implementation
 *
 * @author  yuriygubar on 7/6/17.
 *
 */
public class FibonacciModified implements Fibonacci {

    /**
     * The message that is used with inappropriate <i>t1</i> or <i>t2</i> initial values.
     */
    private static final String T1_T2_RANGE_VIOLATION_MESSAGE = "Unacceptable initial values range, t1;t2 must satisfy to next constraint:  0 <= t1; t2 <= 2";
    /**
     * The message that is used with inappropriate <i>n</i>initial value.
     */
    private static final String N_RANGE_VIOLATION_MESSAGE = "Unacceptable initial values range, n must be in [3, 20] span";

    /**
     * *
     * {@inheritDoc}
     */
    @Override
    public BigInteger compute(int t1, int t2, int n) throws UnacceptableArgumentException {
        checkConstraints(t1, t2, n);
        BigInteger a = BigInteger.valueOf(t1);
        BigInteger b = BigInteger.valueOf(t2);
        BigInteger c;
        if (n == 1){
            return a;
        }else if (n == 2){
            return b;
        }else {
            for (; n -1 > 0; --n){
                c = b.pow(2).add(a);
                a = b;
                b = c;
            }
        }
        return a;
    }


    /**
     * Check initial values constraints.
     * <ul>
     * <li>If the first argument is less then 0 or second argument grater then 2, then throws UnacceptableArgumentException.
     * <li>If the third argument is less then 3 or grater then 20, then throws UnacceptableArgumentException.
     * @param t1 first fibonacci number
     * @param t2 second fibonacci number
     * @param n t(n) fibonacci number
     * @exception UnacceptableArgumentException On invalid initial argument
     */
    private void checkConstraints(int t1, int t2, int n) throws UnacceptableArgumentException {
        if (t1 < 0 || t2 > 2) {
            throw new UnacceptableArgumentException(T1_T2_RANGE_VIOLATION_MESSAGE);
        } else if (n < 3 || n > 20) {
            throw new UnacceptableArgumentException(N_RANGE_VIOLATION_MESSAGE);
        }
    }
}

