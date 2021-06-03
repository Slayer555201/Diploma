package Diploma.vstu;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import service.BrowsersService;

import java.util.Set;

import static enums.PersonalPage.EMAIL;
import static enums.PersonalPage.INPUT_PASSWORD;

public class BaseVSTUPageTest {

    protected BrowsersService browsersService;
    protected WebDriver driver;

    @Before
    public void beforeTests() throws InterruptedException {
        /*
        1. Запустить драйвер
        2. Перейти на сайт
        3. Ввести логин
        4. Ввести пароль
        5. Нажать Login
*/

        this.browsersService = new BrowsersService(BrowserType.CHROME);
        this.driver = browsersService.getDriver();
        driver.manage().window().maximize();
        driver.get("https://priem.vstu.by/cabinet/");
        driver.findElement(By.linkText("Авторизация")).click();
        String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles();
        for (final String handle : handles) {
            subWindowHandler = handle;
        }
        driver.switchTo().window(subWindowHandler);

//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        Thread.sleep(1000);
//        Random random = new Random();
//        int n = random.nextInt(100) + 1;
//        String email = "ivanlushakov" + n + "@mail.ru";

        browsersService.getByIdAndSendKeys(EMAIL, "slayer555@inbox.ru");
        browsersService.getByIdAndSendKeys(INPUT_PASSWORD, "qwerty1234");
        Thread.sleep(1000);
        driver.findElement(By.id("submit")).click();
        Thread.sleep(100);
    }

    @After
    public void closeBrowser() {
        browsersService.close();
    }
}
