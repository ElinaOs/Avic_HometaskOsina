import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;
    private static final String MAIN_PAGE_URL = "https://avic.ua";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
        driver.get(MAIN_PAGE_URL);
    }

    @Test
    public void searchTest() {
        mainPage.enterSearchText("Book Pro 13 mac");
        mainPage.clickSearchButton();

        assertEquals("URL is not expected", MAIN_PAGE_URL + "/search-results?query=Book+Pro+13+mac", driver.getCurrentUrl());
    }

    @Test
    public void invalidEmailTest() {
        mainPage.enterName("Ivan Ivanov");
        mainPage.enterEmail("no email");
        mainPage.emailButtonClick();

        assertTrue("Email Alert is not visible", mainPage.isEmailAlertVisible());
    }

    @Test
    public void linkBestTVChangeUrl() {
        mainPage.clickLinkBestTV();

        assertEquals("URL is not expected", MAIN_PAGE_URL + "/luchshie-smart-televizori", driver.getCurrentUrl());
    }

    @After
    public void close() {
        driver.close();
    }

}
