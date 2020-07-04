package mentoringProgram.calculators;

import io.github.bonigarcia.wdm.WebDriverManager;
import mentoringProgram.interfacePackage.CalculatorInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DerivativeCalculator implements CalculatorInterface {
    private WebDriver driver;

    public DerivativeCalculator() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        startDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='expression']")
    private WebElement inputField;

    @FindBy(xpath = "//input[@id='go']")
    private WebElement calcButton;

    @FindBy(xpath = "//div[@class = 'calc-math user-input-latex']")
    private WebElement resultField;

    private void closeBrowser() {
        driver.quit();
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
        driver.get("https://www.derivative-calculator.net/");
    }

    private Double calculationMethod(Double firstDigit, Double secondDigit, String sign) {
        inputField.clear();
        inputField.sendKeys(Double.toString(firstDigit));
        inputField.sendKeys(sign);
        inputField.sendKeys(Double.toString(secondDigit));
        calcButton.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(resultField));
        String calculationResult = resultField.getText().replaceAll("−\n", "-");
        double result = Double.parseDouble(calculationResult);
        closeBrowser();
        return result;
    }

    private void checkDivideByZero(double ifZero) {
        if (ifZero == 0) {
            closeBrowser();
            throw new ArithmeticException("You cannot divide by zero");
        }
    }
}
