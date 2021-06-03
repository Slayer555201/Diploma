package Diploma.vstu;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static enums.PersonalPage.*;

public class PersonalTest extends BaseVSTUPageTest {

    @Test
    public void Personal() throws InterruptedException {
/*
        1. Перейти на страницу
        2. Ввести корректные данные
        3. Нажать Далее
*/
        Thread.sleep(1000);
        driver.navigate().to("https://priem.vstu.by/cabinet/personal");
        Thread.sleep(1000);
        // driver.switchTo().alert().accept();
        Select dropdown = new Select(driver.findElement(By.id("doctype")));
        dropdown.selectByIndex(3);
        browsersService.getByIdAndSendKeys(DOCSERIA, "BM");
        browsersService.getByNameAndSendKeys(DOCUMENT_NUMBER, "1231231");
        browsersService.getByIdAndSendKeys(DOCDATE, "2020-01-01");
        browsersService.getByIdAndSendKeys(ISSUED, "Vitebsk GOM");
        browsersService.getByIdAndSendKeys(SURNAME, "Лушаков");
        browsersService.getByIdAndSendKeys(NAME, "Иван");
        browsersService.getByIdAndSendKeys(LASTNAME, "Витальевич");
        browsersService.getByIdAndSendKeys(SURNAME_EN, "Lushakov");
        browsersService.getByIdAndSendKeys(NAME_EN, "Ivan");
        browsersService.getByIdAndSendKeys(BIRTHDATE, "2000-03-03");
        browsersService.getByIdAndSendKeys(BIRTHPLACE, "Orsha");
        Select dropdown1 = new Select(driver.findElement(By.id("nationality")));
        dropdown1.selectByIndex(1);
        browsersService.getByIdAndSendKeys(IDENTIFICATION, "1212000200");
        driver.findElement(By.xpath("//div[9]/div/label")).click();
        driver.findElement(By.xpath("//input[@value='Далее']")).click();
    }
}
