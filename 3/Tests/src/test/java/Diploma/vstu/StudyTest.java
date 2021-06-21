package Diploma.vstu;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class StudyTest extends BaseVSTUPageTest {

    @Test
    public void Study() throws InterruptedException {
/*
        1. Перейти на страницу
        2. Ввести корректные данные
        3. Нажать Далее
*/
        Thread.sleep(1400);
        browsersService.navigate("https://priem.vstu.by/cabinet/study");
        driver.findElement(By.id("endYear")).sendKeys("2000");
        Select level = new Select(driver.findElement(By.id("educationLevel")));
        level.selectByIndex(1);
        //Select school = new Select( driver.findElement( By.className( "ngx-select__toggle btn form-control" ) ) );
        //school.selectByIndex( 2 );
        Select language = new Select(driver.findElement(By.id("language")));
        language.selectByIndex(3);
        WebElement option1 = driver.findElement(By.id("goldMedalist"));

        option1.click();
        if (option1.isSelected()) {
            System.out.println("Checkbox is Toggled On");

        } else {
            System.out.println("Checkbox is Toggled Off");
        }

        // driver.findElement( By.xpath( "//input[@value='Далее']" ) ).click();

    }
}
