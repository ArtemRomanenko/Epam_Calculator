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
        return calculationMethod(x, y, "/");
    }

    private void startDriver() {
        driver.get("https://www.google.com/");
    }

    private Double calculationMethod(double a, double b, String sign) {
        String firstDigit = String.valueOf(a);
        String secondDigit = String.valueOf(b);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if (secondDigit.contains("0.0")) {
            System.out.println("You cannot divide by zero");
            return null;
        } else if (secondDigit.contains("-")) {
            secondDigit = "(" + secondDigit + ")";
        }
        String result = js.executeScript("return document.value = (" + firstDigit + sign + secondDigit + ")")
                .toString();
        driver.quit();
        return Double.parseDouble(result);
    }
}
