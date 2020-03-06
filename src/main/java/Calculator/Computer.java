package Calculator;

public class Computer {

    public static Double addition(Double arg1, Double arg2) {
        return arg1 + arg2;
    }

    public static Double subtraction(Double arg1, Double arg2) {
        return arg1 - arg2;
    }

    public static Double multiplication(Double arg1, Double arg2) {
        return arg1 * arg2;
    }

    public static Double division(Double arg1, Double arg2) {
        return arg1 / arg2;
    }

    public static Double xoring(Double arg1, Double arg2) {
        return (double) (arg1.intValue() ^ arg2.intValue());
    }

    public static Double moding(Double arg1, Double arg2) {
        return arg1 % arg2;
    }
}
