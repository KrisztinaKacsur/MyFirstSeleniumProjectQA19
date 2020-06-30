import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

public class CheckoutTest {
    private WebDriver driver;

    @Before
    public void before () {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }


    @Test
    public void checkout () {

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("Madison");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        Actions action = new Actions(driver);
        WebElement accessories = driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[3]/a"));
        action.moveToElement(accessories).perform();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-3.parent > ul > li.level1.nav-3-4.last > a")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-" +
                                          "wrapper > div.col-main > div.category-products > ul > li:nth-child(3) > div" +
                                          " > div.actions > button > span > span")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div." +
                                          "cart.display-single-price > div.cart-totals-wrapper > div > ul > li > " +
                                          "button > span > span")).click();
        driver.findElement(By.cssSelector("#co-billing-form > div > ul > li:nth-child(4) > label")).click();
        driver.findElement(By.cssSelector("#co-billing-form > div > ul > li:nth-child(3) > label")).click();
        driver.findElement(By.cssSelector("#billing-buttons-container > button > span > span")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#checkout-shipping-method-load > dl > dd:nth-child(4) > ul > li > label")).click();
        driver.findElement(By.cssSelector("#shipping-method-buttons-container > button > span > span")).click();
        driver.findElement(By.cssSelector("#payment-buttons-container > button")).click();
        driver.findElement(By.cssSelector("#review-buttons-container > button")).click();
        WebElement orderReceived =
                driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > " +
                                                  "div > div > div.page-title > h1"));
        Assert.assertEquals("YOUR ORDER HAS BEEN RECEIVED." , orderReceived.getText());

    }

    @After
    public void exit () {
        driver.quit();
    }



}
