import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        String expectedText = "Swag Labs";
        String actualTitle = driver.getTitle();

        System.out.println("Фактичний заголовок: " + actualTitle);

        if (actualTitle.contains(expectedText)) {
            System.out.println(" Перевірка успішно виконена.");
        } else {
            System.out.println("FAil");
        }

        driver.quit();
    }
}