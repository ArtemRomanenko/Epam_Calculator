package mentoringProgram.calculators;

import io.github.bonigarcia.wdm.WebDriverManager;
import mentoringProgram.interfacePackage.CalculatorInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPi implements CalculatorInterface {
    private WebDriver driver;

    public CalculatorPi() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        startDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[@class='keyb']/button[contains(text(),'+')]")
    private WebElement plusButton;

    @FindBy(xpath = "//td[@class='keyb']/button[contains(text(),'−')]")
    private WebElement minusButton;

    @FindBy(xpath = "//td[@class='keyb']/button[contains(text(),'×')]")
    private WebElement multiplyButton;

    @FindBy(xpath = "//td[@class='keyb']/button[contains(text(),'∕')]")
    private WebElement divideButton;

    @FindBy(xpath = "//*[@type = 'SUBMIT']")
    private WebElement calcButton;

    @FindBy(xpath = "//*[@id='results']/tbody/tr[2]/td[3]/a")
    private WebElement resultField;

    @FindBy(xpath = "//*[@class = 'btn_num' and contains(text(), '•')]")
    private WebElement dotButton;

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
        return calculation(x, y, '/');
    }

    private void startDriver() {
        driver.get("https://calculatorpi.com/");
    }

    private String[] parseUserInput(double userDigit) {
        String userInput = Double.toString(userDigit);
        return userInput.split("(?!^)");
    }

    private WebElement createButtonWebElement(String userDigit) {
        String xpath = String.format("//td[@class='keyb']/button[contains(text(),'%s')]", userDigit);
        return driver.findElement(By.xpath(xpath));
    }

    private void hoverAndClick(WebElement hoverElement) {
        new Actions(driver).moveToElement(hoverElement).click().build().perform();
    }

    private void userDigitClick(String button) {
        new Actions(driver).moveToElement(createButtonWebElement(button)).click().build().perform();
    }

    private void webCalculation(double digitFromUser) {
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

    private Double calculation(double a, double b, char sign) {
        webCalculation(a);
        signClick(sign);
        if (b == 0.0) {
            throw new ArithmeticException("You cannot divide by zero");
        }
        webCalculation(b);
        hoverAndClick(calcButton);
        double result = Double.parseDouble(resultField.getText());
        closeBrowser();
        return result;
    }

    private Character signClick(char userSign){
        switch (userSign) {
            case '+':
                hoverAndClick(plusButton);
                break;
            case '-':
                hoverAndClick(minusButton);
                break;
            case '*':
                hoverAndClick(multiplyButton);
                break;
            case '/':
                hoverAndClick(divideButton);
                break;
        }
        return userSign;
    }
}
