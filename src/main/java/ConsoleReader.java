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
}
