package mentoringProgram.calculatorLogic;

import mentoringProgram.interfacePackage.ReaderInterface;

import java.util.Scanner;

public class ConsoleReader implements ReaderInterface {
    Scanner scanner = new Scanner(System.in);

    public Boolean hasNext() {
        System.out.println("would you like to calculate again with this calculation logic y/n");
        scanner.nextLine();
        String userAnswer = scanner.nextLine();
        if (userAnswer.equals("y")) {
            return true;
        } else {
            return false;
        }
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
        System.out.println("Choose your calculator:" + "\n" + "1 Local Calculator." +
                "\n" + "2 Google calculator." + "\n" + "3 Web calculator."
                + "\n" + "4 Calculator Pi." + "\n" + "5 iFrame Calculator"
                        +"\n"+ "6 Derivative calculator"+ "\n" + "7 CalculatorJS");
        return scanner.nextInt();
    }
}
