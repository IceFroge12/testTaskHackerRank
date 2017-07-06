package trigonometricRations;

import exceptions.UnacceptableArgumentException;

import java.util.List;


/**
 * Provide interface for computation sin and cos value with initialization initial parameters by String lines
 * @author  by yuriygubar on 7/6/17.
 */
public class TrigonometricSinCosComputationByString implements SinCosComputationByString{


    /**
     * Inner class, that represent converted data from string to initial params
     */
    class MappedParameters {
        int n;
        double[] radianValues;

        public MappedParameters(int n) {
            this.n = n;
            this.radianValues = new double[n];
        }
    }

    /**
     * Implementation of algorithm
     */
    private SinCosComputation sinCosComputation;


    /**
     * Separator between lines
     */
    private static final String SEPARATOR = "\n";

    /**
     * Index of value, that represents count of test cases
     */
    private static final int COUNT_OF_TEST_CASE_INDEX_VALUE = 0;

    /**
     * Message for exception, caused by invalid string format.
     */
    private static final String ARGUMENT_FORMAT_EXCEPTION = "Inappropriate line. String must be composed by lines. First line must represent count of test cases. " +
            "Remaining lines represents radians value for each test case";

    /**
     * Message for exception, caused by discrepancy between value, that corresponding to count of test cases, and count of radiance value fot each test case.
     */
    private static final String COUNT_RADIANS_VALUE_EXCEPTION = "Count of radiance values must corresponds to count of test cases";

    public TrigonometricSinCosComputationByString(SinCosComputation sinCosComputation) {
        this.sinCosComputation = sinCosComputation;
    }

    /**
     *
     * @param paramList - String, composed by line, that represents initial parameters. First line - count of test cases.
     *                 Subsequent lines - value of radians for each test case
     *
     * @return Return a list object containing values of Sin(radians) and Cos(radians).
     * @throws UnacceptableArgumentException On invalid initial argument
     */
    @Override
    public List<ResultObject> compute(String paramList) throws UnacceptableArgumentException {
        MappedParameters mappedParameters = mapStringToParams(paramList);
        return sinCosComputation.compute(mappedParameters.n, mappedParameters.radianValues);
    }

    /**
     * Map string with initial parameters to MappedParameters object
     * @param paramList initial string with parameters.
     * @return MappedParameters object with filled parameters
     * @throws UnacceptableArgumentException On invalid arguments.
     */
    private MappedParameters mapStringToParams(String paramList) throws UnacceptableArgumentException {
        String[] list = paramList.split(SEPARATOR);
        MappedParameters mappedParameters = null;
        try {
            int testCaseCount = Integer.parseInt(list[COUNT_OF_TEST_CASE_INDEX_VALUE]);
            if (testCaseCount != list.length - 1) {
                throw new UnacceptableArgumentException(COUNT_RADIANS_VALUE_EXCEPTION);
            }
            mappedParameters = new MappedParameters(testCaseCount);
            for (int i = 1; i < list.length; i++) {
                mappedParameters.radianValues[i - 1] = Double.parseDouble(list[i]);
            }
        }catch ( NumberFormatException e) {
            throw new UnacceptableArgumentException(ARGUMENT_FORMAT_EXCEPTION, e);
        }
        return mappedParameters;
    }
}
