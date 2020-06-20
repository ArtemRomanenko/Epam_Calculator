package mentoringProgram.calculatorLogic;

import mentoringProgram.calculators.*;
import mentoringProgram.interfacePackage.CalculatorInterface;

import java.util.Scanner;

public class CalculatorRun {
    private static ConsoleReader reader = new ConsoleReader();
    private static MailReader mailReader = new MailReader();
    private static int calculatorChoice;

    public void run() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose Calculator Logic:" + "\n" + "1. Console Calculator"
                + "\n" + "2. Mail Calculator");
        int calculatorLogic = scan.nextInt();
        switch (calculatorLogic) {
            case 1:
                calculatorChoice = 1;
                consoleCalculator();
                break;
            case 2:
                mailCalculator();
                break;
            default:
                System.out.println("Error. You need to choose between option 1 and 2");
        }
    }

    private static CalculatorInterface chosenCalculator() {
        int result;
        if (calculatorChoice == 1) {
            result = reader.selectCalculator();
        } else {
            result = mailReader.selectCalculator();
        }
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
            case 7:
                return new CalculatorJS();
            default:
                System.out.println("Error. Local Calculator will start");
                return new LocalCalculator();
        }
    }

    private void consoleCalculator() {
        do {
            Calculator calculator = new Calculator(chosenCalculator());
            Formula formula = reader.readNext();
            calculator.calculate(formula);
        } while (reader.hasNext());
    }

    private void mailCalculator() {
        do {
            Calculator calculator = new Calculator(chosenCalculator());
            Formula formula = mailReader.readNext();
            calculator.calculate(formula);
        } while (mailReader.hasNext());
    }
}
