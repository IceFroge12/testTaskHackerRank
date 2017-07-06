package fibonacci;

import exceptions.UnacceptableArgumentException;

import java.math.BigInteger;

/**
 * Provide interface for compute fibonacci number with initial values in form of String
 * @author yuriygubar on 7/6/17.
 */

public interface FibonacciByString {

    /**
     * Return the n fibonacci number
     *
     * <ul>
     * <li>If the first argument is less then 0 or second argument grater then 2, then throws UnacceptableArgumentException.
     * <li>If the third argument is less then 3 or grater then 20, then throws UnacceptableArgumentException.
     * @param paramList String composed by t1, t2, n params.
     * @return value of t(n) fibonacci number.
     * @throws UnacceptableArgumentException On invalid initial argument.
     */
    BigInteger compute(String paramList) throws UnacceptableArgumentException;
}
