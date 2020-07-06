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

        driver.findElement(By.cssSelector(".skip-account")).click();
        driver.findElement(By.cssSelector("[title='Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Jenny");
        driver.findElement(By.id("middlename")).sendKeys("A");
        driver.findElement(By.id("lastname")).sendKeys("Johnson");
        WebElement email = driver.findElement(By.id("email_address"));

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        email.sendKeys("krisztina" + randomInt + "@gmail.com");

        driver.findElement(By.id("password")).sendKeys("#TestMail");
        driver.findElement(By.id("confirmation")).sendKeys("#TestMail");
        driver.findElement(By.id("is_subscribed")).click();

    }

    @Test
    public void registerWithExistingUserEmail () {

        driver.findElement(By.cssSelector(".skip-account")).click();
        driver.findElement(By.cssSelector("[title='Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Jenny");
        driver.findElement(By.id("middlename")).sendKeys("A");
        driver.findElement(By.id("lastname")).sendKeys("Johnson");
        driver.findElement(By.id("email_address")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.id("password")).sendKeys("#TestMail");
        driver.findElement(By.id("confirmation")).sendKeys("#TestMail");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector(".buttons-set .button")).click();

        WebElement registeredEmailElement = driver.findElement(By.cssSelector(".error-msg"));
        Assert.assertEquals("There is already an account with this email address. If you are sure that it is your " +
                            "email address, click here to get your password and access your account." ,
                            registeredEmailElement.getText());
    }

    @Test
    public void registerWithoutEmail () {
        driver.findElement(By.cssSelector(".skip-account")).click();
        driver.findElement(By.cssSelector("[title='Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Jenny");
        driver.findElement(By.id("middlename")).sendKeys("A");
        driver.findElement(By.id("lastname")).sendKeys("Johnson");
        driver.findElement(By.id("password")).sendKeys("#TestMail");
        driver.findElement(By.id("confirmation")).sendKeys("#TestMail");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector(".buttons-set .button")).click();
        WebElement noEmail = driver.findElement(By.id("advice-required-entry-email_address"));
        Assert.assertEquals("This is a required field." , noEmail.getText());



    }


    @Test
    public void registerWithoutPassword () {
        driver.findElement(By.cssSelector(".skip-account")).click();
        driver.findElement(By.cssSelector("[title='Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Jenny");
        driver.findElement(By.id("middlename")).sendKeys("A");
        driver.findElement(By.id("lastname")).sendKeys("Johnson");
        driver.findElement(By.id("email_address")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.id("password")).sendKeys("#TestMail");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector(".buttons-set .button")).click();
        WebElement noConfirmationPassword = driver.findElement(By.id("advice-required-entry-confirmation"));
        Assert.assertEquals("This is a required field." , noConfirmationPassword.getText());

    }

    @Test
    public void passwordNoMatch () {
        driver.findElement(By.cssSelector(".skip-account")).click();
        driver.findElement(By.cssSelector("[title='Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Jenny");
        driver.findElement(By.id("middlename")).sendKeys("A");
        driver.findElement(By.id("lastname")).sendKeys("Johnson");
        driver.findElement(By.id("email_address")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.id("password")).sendKeys("#TestMail");
        driver.findElement(By.id("confirmation")).sendKeys("#Testabcde");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector(".buttons-set .button")).click();
        WebElement pwMatch = driver.findElement(By.id("advice-validate-cpassword-confirmation"));
        Assert.assertEquals("Please make sure your passwords match.", pwMatch.getText());


    }

    @After
    public void exit () {
        driver.quit();
    }



}
