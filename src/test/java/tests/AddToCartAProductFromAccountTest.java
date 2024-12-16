package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import pages.ProductPage;
import java.time.Duration;

public class AddToCartAProductFromAccountTest {
    private WebDriver driver;

    @Before
    public void setUp() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    }

    @Test
    public void addProductToCartTest(){

    try {
    driver.get("https://www.ccc.eu.ro/login");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    try {
    WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='onetrust-accept-btn-handler']")));
    acceptCookiesButton.click();
    System.out.println("Cookies acceptate.");
    } catch (Exception e) {
    System.out.println("Nu s-a găsit pop-up-ul pentru cookies.");
    }

    try {
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    alert.accept();
    System.out.println("Nu multumesc.");
    } catch (Exception e) {
    System.out.println("Nu s-a găsit nici o  alerta.");
    }

    WebElement emailField = driver.findElement(By.id("enp_customer_form_login_username"));
    WebElement passwordField = driver.findElement(By.id("enp_customer_form_login_password"));
    emailField.sendKeys("somacescuisabela@gmail.com");
    passwordField.sendKeys("Miro10@Isa");

    WebElement loginButton = driver.findElement(By.xpath("//input[@class='c-btn is-primary is-wide is-submitBtn']"));
    loginButton.click();

    wait.until(ExpectedConditions.urlContains("account"));

    WebElement accountName = driver.findElement(By.xpath("//div[@class='c-menu_userAccount is-loggedIn']"));
    if (accountName.isDisplayed()) {
    System.out.println("Autentificare reușită!");
    } else {
    System.out.println("Autentificare eșuată.");
    driver.quit();
    return;
    }

    WebElement searchBox = driver.findElement(By.id("search-input"));
    searchBox.sendKeys("pantofi");
    searchBox.submit();

    WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='c-menu_link is-link3   is-col1 is-limit-4 ']")));
    productLink.click();

    ProductPage product = new ProductPage("Încălțăminte sport Reebok CREM", "399,99 lei", "https://ccc.eu/ro/incaltaminte-sport-reebok-crem");

    if (!product.isProductValid()) {
    System.out.println("Detaliile produsului sunt invalide.");
    driver.quit();
    return;
    }

    WebElement reebokShoes = driver.findElement(By.xpath("//a[.//span[text()='Încălțăminte sport Reebok DMX COMFORT + 100201512 CREM']]"));
    reebokShoes.click();

    WebElement size39 = driver.findElement(By.xpath("//button[contains(text(),'39')]"));
    size39.click();

    WebElement addToCartButton = driver.findElement(By.xpath("//a[contains(@class, 'c-btn') and contains(@class, 'is-primary') " +
            "and contains(@class, 'is-big') and contains(@class, 'is-selectSize') and contains(@class, 'is-addToCartBtn')]"));
    addToCartButton.click();

    WebElement validationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cart-icon']")));
    String expectedMessage = "Produsul a fost adăugat în coșul dumneavoastră de cumpărături";
    if (validationMessage.getText().equals(expectedMessage)) {
    System.out.println("Test PASSED: Mesajul de validare este corect.");
    } else {
    System.out.println("Test FAILED: Mesajul de validare este incorect.");
    }

    WebElement viewCartOption = driver.findElement(By.cssSelector("//a[@class='c-btn is-primary']"));
    if (viewCartOption.isDisplayed()) {
    System.out.println("Test PASSED: Opțiunea 'Vezi cosul meu' este vizibilă.");
    } else {
    System.out.println("Test FAILED: Opțiunea 'Vezi cosul meu' nu este vizibilă.");
    }

    } catch (Exception e) {
    System.out.println("Test FAILED: " + e.getMessage());
    } finally {

    driver.quit();
    }
    }
    }

