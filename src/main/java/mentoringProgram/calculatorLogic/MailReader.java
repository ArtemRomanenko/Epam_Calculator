package mentoringProgram.calculatorLogic;

import io.github.bonigarcia.wdm.WebDriverManager;
import mentoringProgram.interfacePackage.ReaderInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;

public class MailReader implements ReaderInterface {
    private WebDriver driver;

    @FindBy(xpath = "//body/div[@dir = 'ltr']/div[1]")
    private WebElement selectedCalculator;

    @FindBy(xpath = "//body/div[@dir = 'ltr']/div[2]")
    private WebElement firstUserDigit;

    @FindBy(xpath = "//body/div[@dir = 'ltr']/div[3]")
    private WebElement userSign;

    @FindBy(xpath = "//body/div[@dir = 'ltr']/div[4]")
    private WebElement secondUserDigit;

    @FindBy(xpath = "//input[@type = 'text']")
    private WebElement enterInbox;

    @FindBy(xpath = "//iframe[@id = 'msg_body']")
    private WebElement iFrame;

    @FindBy(xpath = "//tbody//td[3]")
    private List<WebElement> mails;

    @FindBy(xpath = "//td/input")
    private List<WebElement> mailCheckboxes;

    @FindBy(xpath = "//button[@title = 'Delete Emails']")
    private WebElement deleteButton;

    @FindBy (xpath = "//button[@id = 'go-to-public']")
    private WebElement goButton;

    @Override
    public Boolean hasNext() {
        Iterator iterator = mails.iterator();
        return iterator.hasNext();
    }

    @Override
    public Formula readNext() {
        Formula formula = new Formula();
        formula.setX(Double.parseDouble(firstUserDigit.getText()));
        formula.setY(Double.parseDouble(secondUserDigit.getText()));
        formula.setSign(userSign.getText().charAt(0));
        driver.navigate().back();
        deleteMail();
        return formula;
    }

    @Override
    public Integer selectCalculator() {
        goToMailBox();
        return Integer.parseInt(selectedCalculator.getText());
    }

    private void driverInit() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    private void goToMailBox() {
        driverInit();
        driver.get("https://www.mailinator.com/");
        enterInbox.sendKeys("Mentorpampam@mailinator.com");
        goButton.click();
        isMailBoxEmpty();
    }

    private void deleteMail() {
        mailCheckboxes.get(0).click();
        deleteButton.click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    private void isMailBoxEmpty(){
        if (mails.size() > 0) {
            mails.get(0).click();
            driver.switchTo().frame(iFrame);
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOf(selectedCalculator));
        } else {
            System.out.println("Mail box is empty. There is nothing to calculate");
            driver.quit();
            System.exit(0);
        }
    }
}
