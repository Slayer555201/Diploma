package Diploma;

import enums.AdditionalPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.Select;
import service.BrowsersService;

import java.util.Iterator;
import java.util.Set;

import static enums.AddressPage.*;
import static enums.PersonalPage.*;
import static org.junit.Assert.assertEquals;


public class VSTUPageTest {

    private BrowsersService browsersService;
    private WebDriver driver;

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
