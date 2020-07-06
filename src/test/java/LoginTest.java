import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    private WebDriver driver;



    @Before
    public void before () {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }


    @Test
    public void login(){

        driver.findElement(By.cssSelector(".skip-account span.label")).click();
        driver.findElement(By.cssSelector("a[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Madison");
        driver.findElement(By.id("send2")).click();
        WebElement welcomeElement  = driver.findElement(By.cssSelector(".hello"));
        Assert.assertTrue(welcomeElement.isDisplayed());
        Assert.assertEquals("Hello, Jenny K Jhonson!" , welcomeElement.getText());

    }


    @Test
    public void invalidEmailLogin(){

        driver.findElement(By.cssSelector(".skip-account span.label")).click();
        driver.findElement(By.cssSelector("a[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("kricsk@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Madison");
        driver.findElement(By.id("send2")).click();
        WebElement invalidEmailPw = driver.findElement(By.cssSelector(".error-msg"));
        Assert.assertTrue(invalidEmailPw.isDisplayed());

    }

    @Test
    public void invalidPasswordLogin(){

        driver.findElement(By.cssSelector(".skip-account span.label")).click();
        driver.findElement(By.cssSelector("a[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("kricsk@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Madisong123");
        driver.findElement(By.id("send2")).click();
        WebElement invalidEmailPw = driver.findElement(By.cssSelector(".error-msg"));
        Assert.assertTrue(invalidEmailPw.isDisplayed());

    }

    @After
    public void exit () {
        driver.quit();
    }

}
