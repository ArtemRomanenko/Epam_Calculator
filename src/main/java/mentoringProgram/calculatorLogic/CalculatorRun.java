package mentoringProgram.calculatorLogic;

import mentoringProgram.calculators.*;
import mentoringProgram.interfacePackage.CalculatorInterface;

public class CalculatorRun {
    static ConsoleReader reader = new ConsoleReader();

    public void run() {
        do {
            Calculator calculator = new Calculator(chosenCalculator());
            Formula formula = reader.readNext();
            calculator.calculate(formula);
        } while (reader.hasNext());
    }

    private static CalculatorInterface chosenCalculator() {
        int result = reader.selectCalculator();
        switch (result) {
            case 1:
                return new LocalCalculator();
            case 2:
                return new GoogleCalculator();
            case 3:
                return new WebCalculator();
            case 4:
                return new CalculatorPi();
            case 5:
                return new IframeCalculator();
            case 6:
                return new DerivativeCalculator();
            default:
                System.out.println("Error. Local Calculator will start");
                return new LocalCalculator();
        }
    }
}
