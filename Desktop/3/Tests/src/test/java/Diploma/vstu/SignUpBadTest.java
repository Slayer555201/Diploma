package Diploma.vstu;

import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Iterator;
import java.util.Set;

import static enums.PersonalPage.EMAIL;
import static enums.PersonalPage.INPUT_PASSWORD;
import static org.junit.Assert.assertEquals;

public class SignUpBadTest extends BaseVSTUPageTest {

    @Test
    public void SignUpBad() throws InterruptedException {
         /*
        1. Перейти на страницу авторизации
        2. Ввести не корректные данные
        3. Нажать Авторизоваться
*/
        driver.get("https://priem.vstu.by/cabinet/");
        driver.findElement(By.linkText("Авторизация")).click();
        String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler);

//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        Thread.sleep(1000);
//        Random random = new Random();
//        int n = random.nextInt(100) + 1;
//        String email = "ivanlushakov" + n + "@mail.ru";

        browsersService.getByIdAndSendKeys(EMAIL, "1slayer555@inbox.ru");
        browsersService.getByIdAndSendKeys(INPUT_PASSWORD, "qwerty1234");
        Thread.sleep(1);
        driver.findElement(By.id("submit")).click();

        assertEquals("Авторизация", driver.findElement(By.linkText("Авторизация")).getText());
//        String ExpectedAlert = " Ошибка авторизации! ";
//        Assert.assertEquals(ExpectedAlert, ActualAlert);

    }
}
