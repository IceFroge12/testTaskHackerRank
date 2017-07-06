package trigonometricRations;

/**
 * Object that represents value for Sin(x) and Cos(x).
 *
 * @author  by yuriygubar on 7/6/17.
 */
public class ResultObject {
    /**
     * Value of Six function for x value
     */
    private double sinValues;
    /**
     * Value of Cos function for x value
     */
    private double cosValues;
    /**
     *
     * Radians value
     */
    private double x;

    public ResultObject() {
    }

    public ResultObject(double sinValues, double cosValues, double x) {
        this.sinValues = sinValues;
        this.cosValues = cosValues;
        this.x = x;
    }

    public double getSinValues() {
        return sinValues;
    }

    public void setSinValues(double sinValues) {
        this.sinValues = sinValues;
    }

    public double getCosValues() {
        return cosValues;
    }

    public void setCosValues(double cosValues) {
        this.cosValues = cosValues;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
}
