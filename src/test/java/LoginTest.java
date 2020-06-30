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

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("Madison");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        WebElement welcomeElement  = driver.findElement(By.cssSelector("body > div > div.page > div.main-container." +
                                                                       "col2-left-layout > div > div.col-main > " +
                                                                       "div.my-account > div > div.welcome-msg > " +
                                                                       "p.hello > strong"));
        Assert.assertTrue(welcomeElement.isDisplayed());
        Assert.assertEquals("Hello, Jenny K Jhonson!" , welcomeElement.getText());

    }


    @Test
    public void invalidEmailLogin(){

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("kricsk3gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("Madison");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        WebElement invalidEmailPw = driver.findElement(By.cssSelector("body > div > div.page > div.main-container." +
                                                                      "col1-layout > div > div > div.account-login"));
        Assert.assertTrue(invalidEmailPw.isDisplayed());

    }

    @Test
    public void invalidPasswordLogin(){

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("mad");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        WebElement invalidEmailPw = driver.findElement(By.cssSelector("body > div > div.page > div.main-container." +
                                                                      "col1-layout > div > div > div.account-login"));
        Assert.assertTrue(invalidEmailPw.isDisplayed());

    }

    @After
    public void exit () {
        driver.quit();
    }

}
