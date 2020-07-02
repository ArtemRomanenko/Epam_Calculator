package mentoringProgram.calculators;

import mentoringProgram.interfacePackage.CalculatorInterface;

public class LocalCalculator implements CalculatorInterface {

    public Double combine(Double x, Double y) {
        return x + y;
    }

    public Double deduct(Double x, Double y) {
        return x - y;
    }

    public Double multiply(Double x, Double y) {
        return x * y;
    }

    public Double divide(Double x, Double y) {
        try {
            if (y == 0.0) {
                throw new ArithmeticException();
            }
        } catch (Exception e) {
            System.out.println("You cannot divide by zero");
        }
        return x / y;
    }
}
