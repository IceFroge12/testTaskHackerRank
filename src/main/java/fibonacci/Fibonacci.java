package fibonacci;

import exceptions.UnacceptableArgumentException;

import java.math.BigInteger;

/**
 * Provide interface for Fibonacci algorithm
 *
 * @author  yuriygubar on 7/6/17.
 *
 *
 *
 */
public interface Fibonacci {

    /**
     * Return the {@code n} fibonacci number
     *
     * <ul>
     * <li>If the first argument is less then 0 or second argument grater then 2, then throws UnacceptableArgumentException.
     * <li>If the third argument is less then 3 or grater then 20, then throws UnacceptableArgumentException.
     *
     *
     * @param t1 first fibonacci number
     * @param t2 second fibonacci number
     * @param n t(n) fibonacci number
     * @return value of t(n) fibonacci number
     * @exception UnacceptableArgumentException On invalid initial argument
     */
    BigInteger compute(int t1, int t2, int n) throws UnacceptableArgumentException;

}
