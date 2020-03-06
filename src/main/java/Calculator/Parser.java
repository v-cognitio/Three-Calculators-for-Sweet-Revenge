package Calculator;

public class Parser {

    private Double lastValue = null;

    public Parser parse(String statement) {
        String[] args = statement.split(" ");
        if (args.length != 3)
            throw new IllegalArgumentException("Wrong operand number");

        try {
            Double arg1 = Double.parseDouble(args[0].trim());
            Double arg2 = Double.parseDouble(args[2].trim());
            switch (args[1].trim()) {
                case "+" :
                    lastValue = Computer.addition(arg1, arg2);
                    break;
                case "-" :
                    lastValue = Computer.subtraction(arg1, arg2);
                    break;
                case "*" :
                    lastValue = Computer.multiplication(arg1, arg2);
                    break;
                case "/" :
                    lastValue = Computer.division(arg1, arg2);
                    break;
                case "^" :
                    lastValue = Computer.xor(arg1, arg2);
                    break;
                case "%" :
                    lastValue = Computer.mod(arg1, arg2);
                    break;
                default:
                    throw new IllegalArgumentException("Wrong operation");
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Operands aren't numbers");
        }

        return this;
    }

    public Double getLastValue() {
        return lastValue;
    }
}
