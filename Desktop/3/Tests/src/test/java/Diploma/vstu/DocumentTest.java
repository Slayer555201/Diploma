package Diploma.vstu;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.Set;

public class DocumentTest extends BaseVSTUPageTest {

    @Test
    public void Document() throws InterruptedException {
         /*
        1. Перейти на страницу
        2. Нажать Добавить документ
        3. Перейти на всплывающее окно
        2. Ввести корректные данные
        3. Нажать Добавить
*/
        Thread.sleep(1400);
        browsersService.navigate("https://priem.vstu.by/cabinet/cer");
        driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
        String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            subWindowHandler = iterator.next();
        }

        driver.switchTo().window(subWindowHandler);
        Select type = new Select(driver.findElement(By.name("educationDocumentTypeId")));
        type.selectByIndex(2);
        Select subject = new Select(driver.findElement(By.name("subjectId")));
        subject.selectByIndex(2);
        browsersService.getByNameAndSendKeys("seria", "1");
        browsersService.getByNameAndSendKeys("number", "1");
        driver.findElement(By.xpath("//input[@value='0']")).sendKeys("1");
        driver.findElement(By.xpath("//input[@value='Добавить']")).click();
    }
}
