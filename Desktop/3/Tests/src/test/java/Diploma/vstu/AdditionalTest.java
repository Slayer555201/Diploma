package Diploma.vstu;

import enums.AdditionalPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AdditionalTest extends BaseVSTUPageTest {

    @Test
    public void Additional() throws InterruptedException {
         /*
        1. Перейти на страницу
        2. Ввести корректные данные
        3. Нажать Далее
*/
        Thread.sleep(1400);
        browsersService.navigate("https://priem.vstu.by/cabinet/additional");
        browsersService.getByIdAndSendKeys(AdditionalPage.FATHER_FIO, "2000");
        browsersService.getByIdAndSendKeys(AdditionalPage.FATHER_PHONE, "2000");
        browsersService.getByIdAndSendKeys(AdditionalPage.FATHER_WORK, "2000");
        browsersService.getByIdAndSendKeys(AdditionalPage.MOTHER_FIO, "2000");
        browsersService.getByIdAndSendKeys(AdditionalPage.MOTHER_PHONE, "2000");
        browsersService.getByIdAndSendKeys(AdditionalPage.MOTHER_WORK, "2000");
        browsersService.getByIdAndSendKeys(AdditionalPage.MINOR_COUNT, "1");
        browsersService.getByIdAndSendKeys(AdditionalPage.WORK_PLACE, "2000");
        browsersService.getByIdAndSendKeys(AdditionalPage.EXPERIENCE, "1");

        WebElement option2 = driver.findElement(By.id("reAdmission"));

        option2.click();

        if (option2.isSelected()) {
            System.out.println("Checkbox is Toggled On");

        } else {
            System.out.println("Checkbox is Toggled Off");
        }

        // driver.findElement( By.xpath( "//input[@value='Далее']" ) ).click();
    }
}
