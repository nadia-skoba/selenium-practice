import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

    private WebDriver driver;

    //  Налаштування драйвера перед кожним тестом
    @BeforeMethod
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    // Закриття браузера після кожного тесту
    @AfterMethod
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void verifyPageTitleContainsSwagLabs() {
        String expectedResult = "Swag Labs";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(
                actualTitle.contains(expectedResult),
                "Тест провалився! Очікували '" + expectedResult + "', а отримали '" + actualTitle + "'"
        );

        System.out.println(" Перевірка успішно завершена.");
    }
}
