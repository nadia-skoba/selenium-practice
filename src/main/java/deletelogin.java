import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class deletelogin {

    private WebDriver driver;

    public static void main(String[] args) {
        deletelogin test = new deletelogin();
        test.executeTest();
    }

    //Основний метод виконання тесту
    private void executeTest() {
        initDriver();
        verifyAllChecks();
        closeDownDriver();
    }

    //Ініціалізація браузера
    private void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    //Закриття браузера
    private void closeDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

   //Виконання всіх перевірок
    private void verifyAllChecks() {
        System.out.println("=====================");
        verifyPageTitle("Swag Labs");
        verifyElementsPresence();
        System.out.println("===========================");
    }

   //Перевірка заголовка сторінки
    private void verifyPageTitle(String expectedText) {
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedText)) {
            System.out.println(" Заголовок '" + actualTitle + "' містить '" + expectedText + "'. (PASS)");
        } else {
            System.out.println(" Заголовок не знайдено. ФАКТ: " + actualTitle + " (FAIL)");
        }
    }

   //Перевірка наявності локаторів
    private void verifyElementsPresence() {
        System.out.println("Перевірка наявності елементів:");

        checkElementPresence(By.id("user-name"), "поле логіну (ID)");
        checkElementPresence(By.className("input_error"), "поле пароля(clssName)");
        checkElementPresence(By.cssSelector("[data-test='login-button']"), "Кнопка Вхід (CSS Selector)");
        checkElementPresence(By.xpath("//*[@id='login_credentials']"), "Текст з логінами(Xpath)");
    }

    //Метод для перевірки наявності елемента
    private void checkElementPresence(By locator, String elementName) {
        try {
            driver.findElement(locator);
            System.out.println("Елемент " + elementName + "знайдено успішно.");

        } catch (NoSuchElementException e) {
            System.out.println(" Елемент " + elementName + "' НЕ знайдено. Локатор: " + locator.toString());
        }
    }
}