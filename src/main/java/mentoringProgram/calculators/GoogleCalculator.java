package mentoringProgram.calculators;

import io.github.bonigarcia.wdm.WebDriverManager;
import mentoringProgram.interfacePackage.CalculatorInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCalculator implements CalculatorInterface {
    private WebDriver driver;

    public GoogleCalculator() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        startDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "q")
    private WebElement searchingField;

    @FindBy(id = "cwos")
    private WebElement resultField;

    private void closeBrowser() {
        driver.quit();
    }

    @Override
    public Double combine(Double x, Double y) {
        searchingField.clear();
        return calculationMethod(x, y, "+");
    }

    @Override
    public Double deduct(Double x, Double y) {
        searchingField.clear();
        return calculationMethod(x, y, "-");
    }

    @Override
    public Double multiply(Double x, Double y) {
        searchingField.clear();
        return calculationMethod(x, y, "*");
    }

    @Override
    public Double divide(Double x, Double y) {
        try {
            if (y == 0.0) {
                throw new ArithmeticException();
            }
        } catch (Exception e) {
            System.out.println("You cannot divide by zero");
            return null;
        }
        searchingField.clear();
        return calculationMethod(x, y, "/");
    }

    private void startDriver() {
        driver.get("https://google.com");
    }

    private Double calculationMethod(Double firstDigit, Double secondDigit, String sign) {
        searchingField.sendKeys(Double.toString(firstDigit));
        searchingField.sendKeys(sign);
        searchingField.sendKeys(Double.toString(secondDigit));
        searchingField.submit();
        double result = Double.parseDouble(resultField.getText());
        closeBrowser();
        return result;
    }
}
