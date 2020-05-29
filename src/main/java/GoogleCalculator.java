import io.github.bonigarcia.wdm.WebDriverManager;
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

    public void startDriver() {
        driver.get("https://google.com");
    }

    @FindBy(name = "q")
    WebElement searchingField;

    @FindBy(id = "cwos")
    WebElement result;

    public Double calculationMethod(Double firstDigit, Double secondDigit, String sign) {
        searchingField.sendKeys(Double.toString(firstDigit));
        searchingField.sendKeys(sign);
        searchingField.sendKeys(Double.toString(secondDigit));
        searchingField.submit();
        return Double.parseDouble(result.getText());
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
            if (y == 0) {
                throw new ArithmeticException();
            }
        } catch (Exception e) {
            System.out.println("You cannot divide by zero");
            return null;
        }
        searchingField.clear();
        return calculationMethod(x, y, "/");
    }
}
