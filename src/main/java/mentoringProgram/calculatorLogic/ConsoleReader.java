package mentoringProgram.calculatorLogic;

import mentoringProgram.interfacePackage.ReaderInterface;

import java.util.Scanner;

public class ConsoleReader implements ReaderInterface {
    Scanner scanner = new Scanner(System.in);

    public Boolean hasNext() {
        System.out.println("Let's start calculation?\n" + "y/n");
        String userAnswer = scanner.next();
        return userAnswer.equals("y");
    }

    public Formula readNext() {
        Formula formula = new Formula();
        System.out.println("Calculation is started...");
        formula.setX(scanner.nextDouble());
        formula.setSign(scanner.next().charAt(0));
        formula.setY(scanner.nextDouble());
        return formula;
    }

    public Integer selectCalculator() {
        System.out.println("Choose your calculator:\n" +
                "1 Local Calculator.\n" +
                "2 Google calculator.\n" +
                "3 Web calculator.\n" +
                "4 Calculator Pi.\n" +
                "5 iFrame Calculator.\n" +
                "6 Derivative calculator.\n" +
                "7 CalculatorJS.\n");
        return scanner.nextInt();
    }
}
