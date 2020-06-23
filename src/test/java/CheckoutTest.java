import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutTest {

    public void checkout () {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("Madison");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();

        Actions action = new Actions(driver);
        WebElement accessories = driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[3]/a"));
        action.moveToElement(accessories).perform();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-3.parent > ul > li.level1.nav-3-4.last > a")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(3) > div > div.actions > button > span > span")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > div.cart-totals-wrapper > div > ul > li > button > span > span")).click();
        driver.findElement(By.cssSelector("#co-billing-form > div > ul > li:nth-child(4) > label")).click();
        driver.findElement(By.cssSelector("#co-billing-form > div > ul > li:nth-child(3) > label")).click();
        driver.findElement(By.cssSelector("#billing-buttons-container > button > span > span")).click();
        driver.findElement(By.cssSelector("#s_method_freeshipping_freeshipping")).click();
        //driver.findElement(By.cssSelector("#shipping-method-buttons-container > button")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[1]/ol/li[3]/div[2]/form/div[3]/button")).click();






    }

}
