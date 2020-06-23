import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

    //NEW USER
    //krisz.testmail@gmail.com
    //#TestMail


    //lab 16 ex 8

    public void registerNewUser () {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.cssSelector("#firstname")).sendKeys("Jenny");
        driver.findElement(By.cssSelector("#middlename")).sendKeys("A");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("Johnson");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("krisz.testmail@gmail.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("#TestMail");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("#TestMail");
        driver.findElement(By.cssSelector("#is_subscribed")).click();

    }


}
