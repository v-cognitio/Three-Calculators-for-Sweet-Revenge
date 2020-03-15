package Calculator;

import SecondCalculator.Calculator.Calculator;
import SecondCalculator.Calculator.Fraction;

public class Parser {

    private String lastValue = null;

    public Parser parse(String statement) {
        String[] args = statement.split(" ");
        boolean fractionMode = false;

        if (args[0].equals("fractions")) {
            fractionMode = true;
        }

        if ((args.length != 4 && fractionMode) || (args.length != 3 && !fractionMode))
            throw new IllegalArgumentException("Wrong operand number");

        try {
            Fraction frc1 = null;
            Fraction frc2 = null;
            Double arg1 = null;
            Double arg2 = null;
            if (fractionMode) {
                frc1 = new Fraction(args[1].trim());
                frc2 = new Fraction(args[3].trim());
            }
            if (!fractionMode) {
                arg1 = Double.parseDouble(args[0].trim());
                arg2 = Double.parseDouble(args[2].trim());
            }

            String operation;
            if (fractionMode) {
                operation = args[2].trim();
            } else {
                operation = args[1].trim();
            }
            switch (operation) {
                case "+":
                    if (fractionMode) {
                        lastValue = Calculator.addFractions(frc1, frc2).toString();
                        break;
                    }
                    lastValue = Computer.addition(arg1, arg2).toString();
                    break;
                case "-":
                    if (fractionMode) {
                        lastValue = Calculator.subFractions(frc1, frc2).toString();
                        break;
                    }
                    lastValue = Computer.subtraction(arg1, arg2).toString();
                    break;
                case "*":
                    if (fractionMode) {
                        lastValue = Calculator.multFractions(frc1, frc2).toString();
                        break;
                    }
                    lastValue = Computer.multiplication(arg1, arg2).toString();
                    break;
                case "/":
                    if (fractionMode) {
                        lastValue = Calculator.divFractions(frc1, frc2).toString();
                        break;
                    }
                    lastValue = Computer.division(arg1, arg2).toString();
                    break;
                case "xor":
                    if (!fractionMode) {
                        lastValue = Computer.xor(arg1, arg2).toString();
                        break;
                    }
                case "mod":
                    if (!fractionMode) {
                        lastValue = Computer.mod(arg1, arg2).toString();
                        break;
                    }
                case "sqr":
                    if (!fractionMode) {
                        lastValue = Computer.root(arg1, arg2).toString();
                        break;
                    }
                case "^":
                    if (!fractionMode) {
                        lastValue = Computer.power(arg1, arg2).toString();
                        break;
                    }
                default:
                    throw new IllegalArgumentException("Wrong operation");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Operands aren't numbers");
        }

        return this;
    }

    public String getLastValue() {
        return lastValue;
    }
}
