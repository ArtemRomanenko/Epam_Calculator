public class CalculatorMain {
    static ConsoleReader reader = new ConsoleReader();

    public static void main(String[] args) {
        do {
            CalculatorInterface calculatorInterface = choosenCalculator();
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

    public static CalculatorInterface choosenCalculator() {
        int result = reader.selectCalculator();
        switch (result) {
            case 1:
                return new LocalCalculator();
            case 2:
                return new GoogleCalculator();
            default:
                System.out.println("Error. Local Calculator will start");
                return new LocalCalculator();
        }
    }
}
