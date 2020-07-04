package mentoringProgram.calculatorLogic;

import mentoringProgram.interfacePackage.CalculatorInterface;

public class Calculator {
    private final CalculatorInterface calculatorInterface;
    private final String CALCULATION_RESULT = "Result of calculation is: ";

    public Calculator(CalculatorInterface calculatorInterface) {
        this.calculatorInterface = calculatorInterface;
    }

    public void calculate(Formula formula) {
        switch (formula.getSign()) {
            case '+':
                formula.setResult(calculatorInterface.combine(formula.x, formula.y));
                System.out.println(CALCULATION_RESULT + formula.result);
                break;
            case '-':
                formula.setResult(calculatorInterface.deduct(formula.x, formula.y));
                System.out.println(CALCULATION_RESULT + formula.result);
                break;
            case '*':
                formula.setResult(calculatorInterface.multiply(formula.x, formula.y));
                System.out.println(CALCULATION_RESULT + formula.result);
                break;
            case '/':
                formula.setResult(calculatorInterface.divide(formula.x, formula.y));
                System.out.println(CALCULATION_RESULT + formula.result);
                break;
        }
    }
}
