public class CalculatorMain {
    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();
        CalculatorInterface calculatorInterface = new LocalCalculator();//ask user about which calculator he want to use
        do {
            Formula formula = reader.readNext();
            if (formula.getSign() == "+".charAt(0)) {
                formula.setResult(calculatorInterface.combine(formula.x, formula.y));
            }
            if (formula.getSign() == "-".charAt(0)) {
                formula.setResult(calculatorInterface.deduct(formula.x, formula.y));
            }
            if (formula.getSign() == "*".charAt(0)) {
                formula.setResult(calculatorInterface.multiply(formula.x, formula.y));
            }
            if (formula.getSign() == "/".charAt(0)) {
                formula.setResult(calculatorInterface.divide(formula.x, formula.y));
            }
            System.out.println("Result of calculation is: " + formula.result);


        } while (reader.hasNext());
    }
}
