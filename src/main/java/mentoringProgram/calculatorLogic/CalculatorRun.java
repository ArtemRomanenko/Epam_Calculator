package mentoringProgram.calculatorLogic;

import mentoringProgram.calculators.*;
import mentoringProgram.interfacePackage.CalculatorInterface;
import mentoringProgram.interfacePackage.ReaderInterface;

import java.util.Scanner;

public class CalculatorRun {
    private static final ConsoleReader READER = new ConsoleReader();
    private static final MailReader MAIL_READER = new MailReader();

    public void run() {
        calculation(calculationLogic());
    }

    private void calculation(ReaderInterface readerInterface) {
        while (readerInterface.hasNext()) {
            Calculator calculator = new Calculator(chosenCalculator(readerInterface));
            Formula formula = readerInterface.readNext();
            calculator.calculate(formula);
        }
    }

    private ReaderInterface calculationLogic() {
        ReaderInterface readerInterface;
        switch (calculatorType()) {
            case 1:
                readerInterface = READER;
                break;
            case 2:
                readerInterface = MAIL_READER;
                break;
            default:
                throw new IllegalArgumentException("Error. You need to choose between option 1 and 2");
        }
        return readerInterface;
    }

    private static CalculatorInterface chosenCalculator(ReaderInterface readerInterface) {
        int result;
        result = readerInterface.selectCalculator();
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
            case 8:
                return new CalculatorApi();
            case 9:
                return new CalculatorApiRest();
            default:
                System.out.println("Error. Local Calculator will start");
                return new LocalCalculator();
        }
    }

    private int calculatorType() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose Calculator Logic:\n" +
                "1. Console Calculator\n" +
                "2. Mail Calculator");
        return scan.nextInt();
    }
}
