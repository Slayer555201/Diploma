package Diploma.vstu;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class CerTest extends BaseVSTUPageTest {

    @Test
    public void Cer() throws InterruptedException {
         /*
        1. Перейти на страницу
        2. Ввести корректные данные
*/
        Thread.sleep(1400);
        browsersService.navigate("https://priem.vstu.by/cabinet/cer");
        Select level = new Select(driver.findElement(By.id("educationTime")));
        level.selectByIndex(1);
        Select form = new Select(driver.findElement(By.id("educationForm")));
        form.selectByIndex(1);
        Select faculty = new Select(driver.findElement(By.id("facultyId")));
        faculty.selectByIndex(1);
        Select speciality = new Select(driver.findElement(By.id("specialities")));
        speciality.selectByIndex(2);


    }
}
