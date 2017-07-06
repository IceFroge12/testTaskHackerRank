package fibonacci;

import exceptions.UnacceptableArgumentException;

import java.math.BigInteger;

/**
 * Provide interface for compute fibonacci number with initial values in form of String separated by space.
 *
 * @author yuriygubar on 7/6/17.
 */
public class FibonacciModifiedByString implements FibonacciByString{

    /**
     * The {@code Fibonacci} object, implemented fibonacci algorithm.
     */
    private Fibonacci fibonacci;

    /**
     *
     * @param fibonacci algorithm implementation
     */
    public FibonacciModifiedByString(Fibonacci fibonacci) {
        this.fibonacci = fibonacci;
    }

    /**
     * The @{code String} value, is used as separator for initial params in line.
     */
    private static final String SEPARATOR = " ";

    /**
     * The {@code int} value, that corresponds to initial params count.
     */
    private static final int ARGUMENT_COUNT = 3;

    /**
     * The {@code int} index of t1 param in line.
     */
    private static final int T1_INDEX = 0;

    /**
     * The {@code int} index of t2 param in line.
     */
    private static final int T2_INDEX = 1;

    /**
     * The {@code int} index of n1 param in line.
     */
    private static final int N_INDEX = 2;

    /**
     * The {@code String} message that is used with an inappropriate format of the initialization line.
     */
    private static final String ARGUMENT_FORMAT_EXCEPTION = "Inappropriate line. Line must be composed by three space-separated integers describing the respective values of t1, t2, and n.";

    /**
     * *
     * {@inheritDoc}
     */
    @Override
    public BigInteger compute(String paramList) throws UnacceptableArgumentException {
        int[] param = mapStringToParam(paramList);
        return fibonacci.compute(param[T1_INDEX], param[T2_INDEX], param[N_INDEX]);
    }

    /**
     * Map string line to t1, t2, n params.
     * @param paramList initial line, composed by t1, t2, n values
     * @return {@code int[]} array with t1, t2, n values.
     * @throws UnacceptableArgumentException On wrong initial line format.
     */
    private int[] mapStringToParam(String paramList) throws UnacceptableArgumentException {
        String[] list = paramList.split(SEPARATOR);
        if (ARGUMENT_COUNT != list.length){
            throw new UnacceptableArgumentException(ARGUMENT_FORMAT_EXCEPTION);
        }else {
            int[] param = new  int[ARGUMENT_COUNT];
            for (int i = 0; i < ARGUMENT_COUNT; i++) {
                try{
                    param[i] = Integer.parseInt(list[i]);
                }catch (NumberFormatException e){
                    throw new UnacceptableArgumentException(ARGUMENT_FORMAT_EXCEPTION, e);
                }

            }
            return param;
        }
    }
}
