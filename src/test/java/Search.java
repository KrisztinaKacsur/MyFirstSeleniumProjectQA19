import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search {

    private WebDriver driver;


    @Before
    public void before () {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }

    @Test
    public void searchButton () {
        driver.findElement(By.id("search")).sendKeys("retro");
        driver.findElement(By.cssSelector("button[title='Search']")).click();

        WebElement foundElement = driver.findElement(By.cssSelector("h2 a"));
        Assert.assertEquals("RETRO CHIC EYEGLASSES" , foundElement.getText());
    }

    @Test
    public void noSearchResults () {
        driver.findElement(By.id("search")).sendKeys("%$^^&**%$#E##@");
        driver.findElement(By.cssSelector("button[title='Search']")).click();

        WebElement noResultsElement = driver.findElement(By.cssSelector(".note-msg"));
        Assert.assertEquals("Your search returns no results." , noResultsElement.getText());
    }


    @After
    public void exit () {
        driver.quit();
    }

}
