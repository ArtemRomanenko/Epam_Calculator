package mentoringProgram.calculatorLogic;

import mentoringProgram.interfacePackage.CalculatorInterface;

public class Calculator {
    private CalculatorInterface calculatorInterface;

    public Calculator(CalculatorInterface calculatorInterface) {
        this.calculatorInterface = calculatorInterface;
    }

    public void calculate(Formula formula) {
        switch (formula.getSign()) {
            case '+':
                formula.setResult(calculatorInterface.combine(formula.x, formula.y));
                System.out.println("Result of calculation is: " + formula.result);
                break;
            case '-':
                formula.setResult(calculatorInterface.deduct(formula.x, formula.y));
                System.out.println("Result of calculation is: " + formula.result);
                break;
            case '*':
                formula.setResult(calculatorInterface.multiply(formula.x, formula.y));
                System.out.println("Result of calculation is: " + formula.result);
                break;
            case '/':
                formula.setResult(calculatorInterface.divide(formula.x, formula.y));
                System.out.println("Result of calculation is: " + formula.result);
                break;
        }
    }
}
