package Calculator;

public class Calculator {

    public static String calculate(String statement) {
        Parser parser = new Parser();
        try {
            return parser.parse(statement).getLastValue().toString();
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }
}
