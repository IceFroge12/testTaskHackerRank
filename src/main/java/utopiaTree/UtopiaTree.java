package utopiaTree;

import exceptions.UnacceptableArgumentException;

/**
 * The Utopian Tree that goes through 2 cycles of growth every year. Each spring, it doubles in height.
 * Each summer, its height increases by 1 meter.
 * Created by yuriygubar on 7/6/17.
 */
public class UtopiaTree {

    /**
     * Inner class for mapping String with parameters.
     */
    class MappedParameters {
        int n;
        int[] сycless;

        public MappedParameters(int n, int[] сycless) {
            this.n = n;
            this.сycless = сycless;
        }
    }

    /**
     * Separator between lines.
     */
    private static final String LINE_SEPARATOR = "\n";
    /**
     * Position of value, that represents count of test cases, in string
     */
    private static final int TEST_COUNT_VALUE_INDEX = 0;
    /**
     * Message for invalid string format exception
     */
    private static final String INVALID_INITIAL_STRING = "Invalid initial string. String must contain integer value, that" +
            " corresponds to count of test cases and count of cycles for each test case";


    /**
     * Initial height of tree
     */
    private int initialHeight;

    /**
     * Grow step per cycle
     */
    private int growPerCycle;

    /**
     * Default constructor initialize <i>initial height as 1</i> and <i>grow step per cycle as 1</i>
     */
    public UtopiaTree() {
        this.initialHeight = 1;
        this.growPerCycle = 1;
    }

    /**
     * Constructor initialize  <i>grow step per cycle as 1</i>
     * @param initialHeight initial height of tree
     */
    public UtopiaTree(int initialHeight) {
        this.initialHeight = initialHeight;
    }

    /**
     *
     * @param initialHeight initial height of tree
     * @param growPerCycle step per cycle
     */
    public UtopiaTree(int initialHeight, int growPerCycle) {
        this.initialHeight = initialHeight;
        this.growPerCycle = growPerCycle;
    }

    /**
     * Calculation grow rate for N test cases.
     * @param initialString String, composed by value, that represents count of test cases, and count of cycles for each test case
     * @return array of row rate for each test case
     * @throws UnacceptableArgumentException On invalid input string
     */
    public int[] makeNTestCase(String initialString) throws UnacceptableArgumentException {
        int[] growRate = null;
        MappedParameters mappedParameters = mapParameters(initialString);
        growRate = new int[mappedParameters.n];
        for (int i = 0; i < mappedParameters.n; i++){
            growRate[i] = makeTestCase(mappedParameters.сycless[i]);
        }
        return growRate;
    }

    /**
     * Map string to MappedParameters object
     * @param initialParameters Initial string with parameters
     * @return instance of MappedParameters, showing number of test cases and cycles for each test case
     * @throws UnacceptableArgumentException On invalid input string
     */
    private MappedParameters mapParameters(String initialParameters) throws UnacceptableArgumentException {
        if (initialParameters.isEmpty()){
            throw new UnacceptableArgumentException(INVALID_INITIAL_STRING);
        }

        String[] lines = initialParameters.split(LINE_SEPARATOR);
        try {
            int testCount = Integer.parseInt(lines[TEST_COUNT_VALUE_INDEX]);
            if (testCount != lines.length - 1) {
                throw new UnacceptableArgumentException(INVALID_INITIAL_STRING);
            }
            int cycles[] = new int[testCount];
            for (int i = 1; i < lines.length; i++) {
                cycles[i - 1] = Integer.parseInt(lines[i]);
            }
            return new MappedParameters(testCount, cycles);
        } catch (NumberFormatException e) {
            throw new UnacceptableArgumentException(INVALID_INITIAL_STRING, e);
        }
    }

    /**
     * Conduction test case.
     * @param cycleCount Count of cycles for test case
     * @return integer value of grow rate
     */
    private int makeTestCase(int cycleCount) {
        int grow = initialHeight;
        if (cycleCount == 0) {
            return grow;
        }

        for (int i = 1; i <= cycleCount; i++) {
            if (i % 2 != 0) {
                grow = 2 * grow;
            } else {
                grow += 1;
            }
        }
        return grow;
    }

    public int getInitialHeight() {
        return initialHeight;
    }

    public void setInitialHeight(int initialHeight) {
        this.initialHeight = initialHeight;
    }

    public int getGrowPerCycle() {
        return growPerCycle;
    }

    public void setGrowPerCycle(int growPerCycle) {
        this.growPerCycle = growPerCycle;
    }
}
