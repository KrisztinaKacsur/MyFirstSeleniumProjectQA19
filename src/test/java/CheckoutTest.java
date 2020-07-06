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

        driver.findElement(By.cssSelector(".skip-account span.label")).click();
        driver.findElement(By.cssSelector("a[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Madison");
        driver.findElement(By.id("send2")).click();
        Actions action = new Actions(driver);
        WebElement accessories = driver.findElement(By.cssSelector(".nav-3 a.has-children"));
        action.moveToElement(accessories).perform();
        driver.findElement(By.cssSelector(".nav-3-4 [href]")).click();
        driver.findElement(By.cssSelector(".item:nth-child(1) .btn-cart")).click();
        driver.findElement(By.cssSelector(".add-to-cart-buttons .btn-cart")).click();
        driver.findElement(By.cssSelector(".method-checkout-cart-methods-onepage-bottom .btn-proceed-checkout")).click();
        driver.findElement(By.cssSelector(".control:nth-child(4) [type='radio']")).click();
        driver.findElement(By.cssSelector(".control:nth-child(3) [for='billing:use_for_shipping_yes']")).click();
        driver.findElement(By.cssSelector("#billing-buttons-container [title='Continue']")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("[for='s_method_flatrate_flatrate']")).click();
        driver.findElement(By.cssSelector("#shipping-method-buttons-container .button")).click();
        driver.findElement(By.cssSelector("#payment-buttons-container .button")).click();
        driver.findElement(By.cssSelector(".btn-checkout")).click();
        WebElement orderReceived =
                driver.findElement(By.cssSelector(".sub-title"));
        Assert.assertEquals("THANK YOU FOR YOUR PURCHASE!" , orderReceived.getText());

    }

    @After
    public void exit () {
        driver.quit();
    }


}
