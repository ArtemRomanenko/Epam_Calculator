package mentoringProgram.calculators;

import io.github.bonigarcia.wdm.WebDriverManager;
import mentoringProgram.calculatorLogic.ErrorHandler;
import mentoringProgram.interfacePackage.CalculatorInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebCalculator extends ErrorHandler implements CalculatorInterface {
    private final WebDriver driver;

    public WebCalculator() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        startDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input")
    private WebElement inputField;

    @FindBy(id = "BtnPlus")
    private WebElement plusButton;

    @FindBy(id = "BtnMinus")
    private WebElement minusButton;

    @FindBy(id = "BtnMult")
    private WebElement multiplyButton;

    @FindBy(id = "BtnDiv")
    private WebElement divideButton;

    @FindBy(id = "BtnCalc")
    private WebElement calculationButton;

    @FindBy(xpath = "//button[@name = 'cookies']")
    private WebElement cookiesBanner;

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
        divisionByZeroCheck(y);
        return calculation(x, y, '/');
    }

    private void startDriver() {
        driver.get("http://web2.0calc.com");
    }

    private void webCalculation(double digitFromUser) {
        String[] num1 = parseUserInput(digitFromUser);
        for (String num : num1) {
            if (num.equals(".")) {
                driver.findElement(By.id("BtnDot")).click();
            } else if (num.equals("-")) {
                minusButton.click();
            } else {
                createButtonWebElement(Integer.parseInt(num)).click();
            }
        }
    }

    private WebElement createButtonWebElement(int buttonId) {
        String id = String.format("Btn%s", buttonId);
        return driver.findElement(By.id(id));
    }

    private String[] parseUserInput(double userDigit) {
        String userInput = Double.toString(userDigit);
        return userInput.split("(?!^)");
    }

    private Double calculation(double firstDigit, double secondDigit, char sign) {
        closeCookiesBanner();
        webCalculation(firstDigit);
        signClick(sign);
        webCalculation(secondDigit);
        calculationButton.click();
        waitForResult();
        double result = Double.parseDouble(inputField.getAttribute("value"));
        closeBrowser();
        return result;
    }

    private void closeCookiesBanner() {
        driver.findElement(By.id("BtnDot")).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(cookiesBanner)).click();
        driver.navigate().refresh();
    }

    private void signClick(char userSign) {
        switch (userSign) {
            case '+':
                plusButton.click();
                break;
            case '-':
                minusButton.click();
                break;
            case '*':
                multiplyButton.click();
                break;
            case '/':
                divideButton.click();
                break;
        }
    }

    private void waitForResult() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
