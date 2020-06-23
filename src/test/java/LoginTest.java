import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {


    public void login(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("Madison");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        driver.quit();
    }

    public void invalidEmailLogin(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("kricsk3gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("Madison");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        driver.quit();
    }

    public void invalidPasswordLogin(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("mad");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();
        driver.quit();
    }

}
