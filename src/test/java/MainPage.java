import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private final WebDriver driver;

    @FindBy(id = "input_search")
    private WebElement searchField;

    @FindBy(xpath = "//button[@class='button-reset search-btn']")
    private WebElement searchButton;

    @FindBy(xpath = "//form/div/input[@class='validate'][@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//form/div/button[@type='submit']")
    private WebElement emailButton;

    @FindBy(xpath = "//form/div[@data-error='Некорректный email']")
    private WebElement invalidEmailAlert;

    @FindBy(xpath = "//div[@class='article__title'][contains(text(),'Лучшие смарт телевизоры')]")
    private WebElement bestTVLink;


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void enterSearchText(String text){
        searchField.sendKeys(text);
    }

    public void clickSearchButton() {
        searchButton.click();
    }


    public void enterName(String text) {
        driver.findElement(By.xpath("//input[@class='validate'][@name='name']")).sendKeys(text);

    }
    public void enterEmail(String text){
        emailField.sendKeys(text);
    }

    public void emailButtonClick(){
        emailButton.click();

    }

    public boolean isEmailAlertVisible(){
        return invalidEmailAlert.isDisplayed();
    }

    public void clickLinkBestTV (){
        bestTVLink.click();
    }
}







