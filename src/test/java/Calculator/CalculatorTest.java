package Calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void TestAddition() {
        String exp = Double.toString(1.1 + -3);
        assertEquals(exp, Calculator.calculate("1.1 + -3"));
    }

    @Test
    public void TestSubtraction() {
        String exp = Double.toString(1.1 - -3);
        assertEquals(exp, Calculator.calculate("1.1 - -3"));
    }

    @Test
    public void TestMultiplication() {
        String exp = Double.toString(1.1 * -3);
        assertEquals(exp, Calculator.calculate("1.1 * -3"));
    }

    @Test
    public void TestDivision() {
        String exp = Double.toString(1.1 / -3);
        assertEquals(exp, Calculator.calculate("1.1 / -3"));
    }

    @Test
    public void TestXor() {
        String exp = Double.toString(1 ^ -3);
        assertEquals(exp, Calculator.calculate("1.1 xor -3"));
    }

    @Test
    public void TestMod() {
        String exp = Double.toString(1.1 % -3);
        assertEquals(exp, Calculator.calculate("1.1 mod -3"));
    }

    @Test
    public void TestWrongNumberOfArguments() {
        try {
            Calculator.calculate("1.1 /");
        }
        catch (Exception e) {
            assertEquals("Wrong operand number", e.getMessage());
        }
    }

    @Test
    public void TestNotANumber() {
        try {
            Calculator.calculate("1.1 / 4e");
        }
        catch (Exception e) {
            assertEquals("Operands aren't numbers", e.getMessage());
        }
    }

    @Test
    public void TestWrongOperation() {
        try {
            Calculator.calculate("1.1 r 4");
        }
        catch (Exception e) {
            assertEquals("Wrong operation", e.getMessage());
        }
    }
}