package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AssistanceContactPage;
import java.time.Duration;
import static org.junit.Assert.*;

public class AssistanceContactTest {

    private WebDriver driver;

    @Before
    public void setUp() {

    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    }

    @Test
    public void AssistentaSiContactTest() {

        driver.get("https://ccc.eu/ro/contact");

        String temaSelect = "Returnare produs";
        String prenumeNume = "Valeria Somacescu";
        String email = "valeria@example.com";
        long phone = 729232044L;
        int numarComanda =1;
        String mesaj = "Produs deteriorat";

        AssistanceContactPage assistanceContactPage = new AssistanceContactPage(
                temaSelect,
                prenumeNume,
                email,
                phone,
                numarComanda,
                mesaj
        );

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement dropdownTema = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='choices']")));
        Select selectTema = new Select(dropdownTema);
        selectTema.selectByVisibleText(assistanceContactPage.getTema());

        WebElement prenunumeField = driver.findElement(By.id("cc_form_707"));
        prenunumeField.sendKeys(assistanceContactPage.getPrenumeNume());

        WebElement emailField = driver.findElement(By.xpath("//input[@name='email']"));
        emailField.sendKeys(assistanceContactPage.getEmail());

        WebElement phoneField = driver.findElement(By.xpath("//input[@type='tel']"));
        phoneField.sendKeys(String.valueOf(assistanceContactPage.getPhone()));

        WebElement dropdownNumarComanda = driver.findElement(By.xpath("//div[@class='choices']"));
        Select selectnumarComanda = new Select(dropdownNumarComanda);
        selectnumarComanda.selectByVisibleText(String.valueOf(assistanceContactPage.getnumarComanda()));

        WebElement mesajField = driver.findElement(By.id("cc_form_715"));
        mesajField.sendKeys(assistanceContactPage.getMesaj());

        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//div[@class='c-alert is-success']"));
        assertTrue(successMessage.isDisplayed());

        System.out.println(assistanceContactPage);
    }

    @After
    public void tearDown() {

    driver.quit();
    }
}