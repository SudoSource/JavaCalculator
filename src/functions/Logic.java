package functions;

public class Logic {

    private int _currentTotal;

    public Logic() {
        _currentTotal = 0;
    }

    public String getTotalString() {
        return "" + _currentTotal;
    }

    public void setTotal(String n) {
        _currentTotal = convertToNumber(n);
    }

    public void add(String n) {
        _currentTotal += convertToNumber(n);
    }

    public void subtract(String n) {
        _currentTotal -= convertToNumber(n);
    }

    public void multiply(String n) {
        _currentTotal *= convertToNumber(n);
    }

    public void divide(String n) {
        _currentTotal /= convertToNumber(n);
    }

    private int convertToNumber(String n) {
        return Integer.parseInt(n);
    }
}