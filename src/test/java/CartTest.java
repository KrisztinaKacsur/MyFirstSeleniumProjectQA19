import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartTest {


    public void addProductToCart () {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div >" +
                                          "div.std > div.widget.widget-new-products > div.widget-products > ul > " +
                                          "li:nth-child(1) > a > img")).click();
        driver.findElement(By.cssSelector("#swatch28 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch80 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom " +
                                          "> div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        driver.quit();

    }


    public void removeFromCart () {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");


        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div >" +
                "div.std > div.widget.widget-new-products > div.widget-products > ul > " +
                "li:nth-child(1) > a > img")).click();
        driver.findElement(By.cssSelector("#swatch28 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch80 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom " +
                "> div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#cart-sidebar > li > div > a.remove")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.quit();
    }




    





}
