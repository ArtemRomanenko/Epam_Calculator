package mentoringProgram.calculatorLogic;

import mentoringProgram.interfacePackage.ReaderInterface;

import java.util.Scanner;

public class ConsoleReader implements ReaderInterface {
    Scanner scanner = new Scanner(System.in);

    public Boolean hasNext() {
        System.out.println("would you like to calculate again y/n");
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
        System.out.println("Choose your calculator:" + "\n" + "Type 1 if you want local Calculator." +
                "\n" + "Type 2 if you want Google calculator." + "\n" + "Type 3 if you want Web calculator."
                + "\n" + "Type 4 if you want Calculator Pi." + "\n" + "Type 5 if you want iFrame Calculator"
                        +"\n"+ "Type 6 if you want Derivative calculator");
        return scanner.nextInt();
    }
}
