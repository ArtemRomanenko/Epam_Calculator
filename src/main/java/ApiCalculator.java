import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApiCalculator implements CalculatorInterface {

    private WebDriver driver;

    public ApiCalculator() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        startDriver();
        PageFactory.initElements(driver, this);
    }

    public void startDriver() {
        driver.get("https://calculatorpi.com/");
    }

    @FindBy(xpath = "//td[@class='keyb']/button[contains(text(),'+')]")
    WebElement plusButton;

    @FindBy(xpath = "//td[@class='keyb']/button[contains(text(),'−')]")
    WebElement minusButton;

    @FindBy(xpath = "//td[@class='keyb']/button[contains(text(),'×')]")
    WebElement multiplyButton;

    @FindBy(xpath = "//td[@class='keyb']/button[contains(text(),'∕')]")
    WebElement divideButton;

    @FindBy(xpath = "//*[@type = 'SUBMIT']")
    WebElement calcButton;

    @FindBy(xpath = "//*[@id='results']/tbody/tr[2]/td[3]/a")
    WebElement resultField;

    @FindBy(xpath = "//*[@class = 'btn_num' and contains(text(), '•')]")
    WebElement dotButton;

    @FindBy(xpath = "//*[@id = 'reset']")
    WebElement resetButton;

    @Override
    public Double combine(Double x, Double y) {
        webCalculation(x);
        hoverAndClick(plusButton);
        webCalculation(y);
        hoverAndClick(calcButton);
        double result = Double.parseDouble(resultField.getText());
        hoverAndClick(resetButton);
        return result;
    }

    @Override
    public Double deduct(Double x, Double y) {
        webCalculation(x);
        hoverAndClick(minusButton);
        webCalculation(y);
        hoverAndClick(calcButton);
        double result = Double.parseDouble(resultField.getText());
        hoverAndClick(resetButton);
        return result;
    }

    @Override
    public Double multiply(Double x, Double y) {
        webCalculation(x);
        hoverAndClick(multiplyButton);
        webCalculation(y);
        hoverAndClick(calcButton);
        double result = Double.parseDouble(resultField.getText());
        hoverAndClick(resetButton);
        return result;
    }

    @Override
    public Double divide(Double x, Double y) {
        webCalculation(x);
        hoverAndClick(divideButton);
        try {
            if (y == 0.0) {
                throw new ArithmeticException();
            }
        } catch (Exception e) {
            System.out.println("You cannot divide by zero");
            return null;
        }
        webCalculation(y);
        hoverAndClick(calcButton);
        double result = Double.parseDouble(resultField.getText());
        hoverAndClick(resetButton);
        return result;
    }

    public WebElement createButtonWebElement(String userDigit) {
        String xpath = String.format("//td[@class='keyb']/button[contains(text(),'%s')]", userDigit);
        return driver.findElement(By.xpath(xpath));
    }

    public String[] parseUserInput(double userDigit) {
        String userInput = Double.toString(userDigit);
        return userInput.split("(?!^)");
    }

    public void hoverAndClick(WebElement hoverElement) {
        new Actions(driver).moveToElement(hoverElement).click().build().perform();
    }

    public void userDigitClick(String button) {
        new Actions(driver).click(createButtonWebElement(button)).build().perform();
    }

    public void webCalculation(double digitFromUser) {
        String[] num1 = parseUserInput(digitFromUser);
        for (String num : num1) {
            if (num.equals(".")) {
                hoverAndClick(dotButton);
            } else if (num.equals("-")) {
                hoverAndClick(minusButton);
            } else {
                userDigitClick(num);
            }
        }
    }
}
