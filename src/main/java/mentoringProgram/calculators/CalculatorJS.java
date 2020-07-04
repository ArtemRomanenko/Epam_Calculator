package mentoringProgram.calculators;

import io.github.bonigarcia.wdm.WebDriverManager;
import mentoringProgram.interfacePackage.CalculatorInterface;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculatorJS implements CalculatorInterface {
    private WebDriver driver;

    public CalculatorJS() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        startDriver();
    }

    @Override
    public Double combine(Double x, Double y) {
        return calculationMethod(x, y, "+");
    }

    @Override
    public Double deduct(Double x, Double y) {
        return calculationMethod(x, y, "-");
    }

    @Override
    public Double multiply(Double x, Double y) {
        return calculationMethod(x, y, "*");
    }

    @Override
    public Double divide(Double x, Double y) {
        checkDivideByZero(y);
        return calculationMethod(x, y, "/");
    }

    private void startDriver() {
        driver.get("https://www.google.com/");
    }

    private void closeBrowser(){
        driver.quit();
    }

    private Double calculationMethod(double firstDigit, double secondDigit, String sign) {
        String secondInput = String.valueOf(secondDigit);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String result = js.executeScript("return document.value = (" + firstDigit + sign
                + checkNegativeDigit(secondInput) + ")")
                .toString();
        closeBrowser();
        return Double.parseDouble(result);
    }

    private String checkNegativeDigit(String userInput) {
        String userDigit = userInput;
        if (userInput.contains("-")) {
            userDigit = "(" + userInput + ")";
        }
        return userDigit;
    }

    private void checkDivideByZero(double ifZero) {
        if (ifZero == 0) {
            closeBrowser();
            throw new ArithmeticException("You cannot divide by zero");
        }
    }
}
