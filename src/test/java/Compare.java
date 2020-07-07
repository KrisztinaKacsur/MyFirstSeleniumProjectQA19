import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class Compare {

    private WebDriver driver;



    @Before
    public void before () {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }


    @Test
    public void addToCompareList() {

        driver.findElement(By.cssSelector(".skip-account span.label")).click();
        driver.findElement(By.cssSelector("a[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Madison");
        driver.findElement(By.id("send2")).click();

        Actions action = new Actions(driver);
        WebElement menElement = driver.findElement(By.cssSelector(".nav-2 .has-children"));
        action.moveToElement(menElement).perform();
        driver.findElement(By.cssSelector(".nav-2-3 [href*='polos']")).click();
        driver.findElement(By.cssSelector(".item:nth-child(1) .link-compare")).click();

        WebElement addedToCompare = driver.findElement(By.cssSelector(".success-msg"));
        Assert.assertEquals("The product Chelsea Tee has been added to comparison list.", addedToCompare.getText());

    }

    @Test
    public void viewComparedProducts () {
        driver.findElement(By.cssSelector(".skip-account span.label")).click();
        driver.findElement(By.cssSelector("a[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Madison");
        driver.findElement(By.id("send2")).click();

        Actions action = new Actions(driver);
        WebElement menElement = driver.findElement(By.cssSelector(".nav-2 .has-children"));
        action.moveToElement(menElement).perform();
        driver.findElement(By.cssSelector(".nav-2-5 [href*='blazers']")).click();
        driver.findElement(By.cssSelector(".item:nth-child(1) .link-compare")).click();
        driver.findElement(By.cssSelector(".item:nth-child(2) .link-compare")).click();
        driver.findElement(By.cssSelector("[title='Compare']")).click();


        Set<String> AllWindowHandles = driver.getWindowHandles();
        String windowMain = (String) AllWindowHandles.toArray()[0];
        String windowCompare = (String) AllWindowHandles.toArray()[1];
        driver.switchTo().window(windowCompare);

        WebElement compareTitleElement = driver.findElement(By.cssSelector(".page-title h1"));
        Assert.assertEquals("COMPARE PRODUCTS" , compareTitleElement.getText());


    }
}
