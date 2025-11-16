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
            if (actualTitle.contains(expectedText)) {
                System.out.println("Pass.");
            } else {
                System.out.println("Feil.");
            }
            driver.quit();
        }
    }

