package mentoringProgram.calculatorLogic;

public abstract class ErrorHandler {

    public void divisionByZeroCheck(double ifZero) {
        if (ifZero == 0) {
            throw new ArithmeticException("You cannot divide by zero");
        }
    }
}
