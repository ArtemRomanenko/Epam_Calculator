package mentoringProgram.calculators;

import io.github.bonigarcia.wdm.WebDriverManager;
import mentoringProgram.interfacePackage.CalculatorInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IframeCalculator implements CalculatorInterface {
    private WebDriver driver;

    public IframeCalculator() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        startDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[@id='bt_pl']")
    private WebElement plusButton;

    @FindBy(xpath = "//td[@id='bt_mi']")
    private WebElement minusButton;

    @FindBy(xpath = "//td[@id='bt_um']")
    private WebElement multiplyButton;

    @FindBy(xpath = "//td[@id='bt_dl']")
    private WebElement divideButton;

    @FindBy(xpath = "//td[@id='bt_rv']")
    private WebElement calcButton;

    @FindBy(xpath = "//input[@id='disp_out']")
    private WebElement resultField;

    @FindBy(xpath = "//td[@id='bt_zp']")
    private WebElement dotButton;

    @FindBy(xpath = "//iframe[@id='frcalcul']")
    private WebElement iFrame;

    @FindBy(xpath = "//td[@id='bt_sb']")
    private WebElement clearButton;

    @FindBy(xpath = "//td[@id='bt_pm']")
    private WebElement plsMnsButton;

    private void startDriver() {
        driver.get("https://calculator-1.com/widgets/");
    }

    private void closeBrowser() {
        driver.quit();
    }

    @Override
    public Double combine(Double x, Double y) {
        return calculation(x, y, '+');
    }

    @Override
    public Double deduct(Double x, Double y) {
        return calculation(x, y, '-');
    }

    @Override
    public Double multiply(Double x, Double y) {
        return calculation(x, y, '*');
    }

    @Override
    public Double divide(Double x, Double y) {
        checkDivideByZero(y);
        return calculation(x, y, '/');
    }

    private WebElement createButtonWebElement(String userDigit) {
        String xpath = String.format("//td[@id='bt_%s']", userDigit);
        return driver.findElement(By.xpath(xpath));
    }

    private String[] parseUserInput(double userDigit) {
        String userInput = Double.toString(userDigit);
        return userInput.split("(?!^)");
    }

    private void userSignClick(WebElement userSign) {
        userSign.click();
    }

    private void userDigitClick(String button) {
        createButtonWebElement(button).click();
    }

    private void webCalculation(double digitFromUser) {
        String[] num1 = parseUserInput(digitFromUser);
        for (String num : num1) {
            if (num.equals(".")) {
                userSignClick(dotButton);
            } else if (num.equals("-")) {
                userSignClick(plsMnsButton);
            } else {
                userDigitClick(num);
            }
        }
    }

    private Double calculation(double a, double b, char sign) {
        driver.switchTo().frame(iFrame);
        webCalculation(a);
        signClick(sign);
        webCalculation(b);
        userSignClick(calcButton);
        double result = Double.parseDouble(resultField.getAttribute("value"));
        closeBrowser();
        return result;
    }

    private void signClick(char userSign) {
        switch (userSign) {
            case '+':
                userSignClick(plusButton);
                break;
            case '-':
                userSignClick(minusButton);
                break;
            case '*':
                userSignClick(multiplyButton);
                break;
            case '/':
                userSignClick(divideButton);
                break;
        }
    }

    private void checkDivideByZero(double ifZero) {
        if (ifZero == 0) {
            closeBrowser();
            throw new ArithmeticException("You cannot divide by zero");
        }
    }
}
