package Diploma.vstu;

import org.junit.Test;
import org.openqa.selenium.By;

import static enums.AddressPage.*;

public class AdressTest extends BaseVSTUPageTest {

    @Test
    public void Address() throws InterruptedException {
        /*
        1. Перейти на страницу
        2. Ввести корректные данные
        3. Нажать Далее
*/
        Thread.sleep(1000);
        browsersService.navigate("https://priem.vstu.by/cabinet/address");
        browsersService.getByIdAndSendKeys(POSTCODE, "211001");
        browsersService.getByIdAndSendKeys(COUNTRY_IN, "BM");
        browsersService.getByIdAndSendKeys(REGION_IN, "BM");
        browsersService.getByIdAndSendKeys(DISTRICT_IN, "BM");
        browsersService.getByIdAndSendKeys(CITY_IN, "BM");
        browsersService.getByIdAndSendKeys(STREET_IN, "BM");
        browsersService.getByIdAndSendKeys(HOUSE_IN, "BM");
        browsersService.getByIdAndSendKeys(BUILDING_IN, "BM");
        browsersService.getByIdAndSendKeys(APARTMENT_IN, "BM");
        driver.findElement(By.linkText("Такой же как адрес проживания")).click();
        browsersService.getByIdAndSendKeys(PHONE, "BM");
        driver.findElement(By.xpath("//input[@value='Далее']")).click();
    }
}
