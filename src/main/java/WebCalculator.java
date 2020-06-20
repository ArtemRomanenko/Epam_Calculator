import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WebCalculator implements CalculatorInterface {
    private WebDriver driver;

    public WebCalculator() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        startDriver();
        PageFactory.initElements(driver, this);
    }

    public void startDriver() {
        driver.get("http://web2.0calc.com");
        driver.findElement(By.xpath("//button[@name = 'cookies']")).click();
    }

    @FindBy(id = "input")
    WebElement inputField;

    @FindBy(id = "BtnPlus")
    WebElement plusButton;

    @FindBy(id = "BtnMinus")
    WebElement minusButton;

    @FindBy(id = "BtnMult")
    WebElement multiplyButton;

    @FindBy(id = "BtnDiv")
    WebElement divideButton;

    @FindBy(id = "BtnCalc")
    WebElement calcButton;

    @Override
    public Double combine(Double x, Double y) {
        inputField.clear();
        webCalculation(x);
        plusButton.click();
        webCalculation(y);
        calcButton.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Double.parseDouble(inputField.getAttribute("value"));
    }

    @Override
    public Double deduct(Double x, Double y) {
        inputField.clear();
        webCalculation(x);
        minusButton.click();
        webCalculation(y);
        calcButton.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Double.parseDouble(inputField.getAttribute("value"));
    }

    @Override
    public Double multiply(Double x, Double y) {
        inputField.clear();
        webCalculation(x);
        multiplyButton.click();
        webCalculation(y);
        calcButton.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Double.parseDouble(inputField.getAttribute("value"));
    }

    @Override
    public Double divide(Double x, Double y) {
        inputField.clear();
        webCalculation(x);
        divideButton.click();
        webCalculation(y);
        calcButton.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Double.parseDouble(inputField.getAttribute("value"));
    }

    public void webCalculation(double digitFromUser) {
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

    public WebElement createButtonWebElement(int buttonId) {
        String id = String.format("Btn%s", buttonId);
        return driver.findElement(By.id(id));
    }

    public String[] parseUserInput(double userDigit) {
        String userInput = Double.toString(userDigit);
        return userInput.split("(?!^)");
    }
}
