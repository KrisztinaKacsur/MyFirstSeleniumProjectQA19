import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class RegisterTest {
    private WebDriver driver;


    //NEW USER
    //krisz.testmail@gmail.com
    //#TestMail


    //lab 16 ex 8

    @Before
    public void before () {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }

    @Test
    public void registerNewUser () {

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.cssSelector("#firstname")).sendKeys("Jenny");
        driver.findElement(By.cssSelector("#middlename")).sendKeys("A");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Johnson");
        WebElement email = driver.findElement(By.id("email_address"));

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        email.sendKeys("krisztina" + randomInt + "@gmail.com");

        driver.findElement(By.cssSelector("#password")).sendKeys("#TestMail");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("#TestMail");
        driver.findElement(By.cssSelector("#is_subscribed")).click();

    }

    @Test
    public void registerWithExistingUserEmail () {

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.cssSelector("#firstname")).sendKeys("Jenny");
        driver.findElement(By.cssSelector("#middlename")).sendKeys("A");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Johnson");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("#TestMail");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("#TestMail");
        driver.findElement(By.cssSelector("#is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button")).click();

        WebElement registeredEmailElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-" +
                                                                              "container.col1-layout > div > div > " +
                                                                              "div.account-create > ul > li > ul > li"));
        Assert.assertEquals("There is already an account with this email address. If you are sure that it is your " +
                            "email address, click here to get your password and access your account." ,
                            registeredEmailElement.getText());
    }

    @Test
    public void registerWithoutEmail () {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.cssSelector("#firstname")).sendKeys("Jenny");
        driver.findElement(By.cssSelector("#middlename")).sendKeys("A");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Johnson");
        driver.findElement(By.cssSelector("#password")).sendKeys("#TestMail");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("#TestMail");
        driver.findElement(By.cssSelector("#is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button")).click();
        WebElement noEmail = driver.findElement(By.cssSelector("#advice-required-entry-email_address"));
        Assert.assertEquals("This is a required field." , noEmail.getText());



    }


    @Test
    public void registerWithoutPassword () {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.cssSelector("#firstname")).sendKeys("Jenny");
        driver.findElement(By.cssSelector("#middlename")).sendKeys("A");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Johnson");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("#TestMail");
        driver.findElement(By.cssSelector("#is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button")).click();
        WebElement noConfirmationPassword = driver.findElement(By.cssSelector("#advice-required-entry-confirmation"));
        Assert.assertEquals("This is a required field." , noConfirmationPassword.getText());

    }

    @Test
    public void passwordNoMatch () {
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.cssSelector("#firstname")).sendKeys("Jenny");
        driver.findElement(By.cssSelector("#middlename")).sendKeys("A");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Johnson");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("#TestMail");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("#Testabcde");
        driver.findElement(By.cssSelector("#is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button")).click();
        WebElement pwMatch = driver.findElement(By.cssSelector("#advice-validate-cpassword-confirmation"));
        Assert.assertEquals("Please make sure your passwords match.", pwMatch.getText());


    }

    @After
    public void exit () {
        driver.quit();
    }



}
