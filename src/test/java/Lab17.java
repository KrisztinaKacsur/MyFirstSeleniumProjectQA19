import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Lab17 {
    private WebDriver driver;


    @Before
    public void before () {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }

    //LAB 17/TEMA 2 / EX 1

    @Test
    public void searchButton () {
        driver.findElement(By.id("search")).sendKeys("retro");
        driver.findElement(By.cssSelector("button[title='Search']")).click();

        WebElement foundElement = driver.findElement(By.cssSelector("h2 a"));
        Assert.assertEquals("RETRO CHIC EYEGLASSES" , foundElement.getText());
    }


    @Test
    public void deleteFirstProductFromCart () {
        driver.findElement(By.cssSelector(".skip-account span.label")).click();
        driver.findElement(By.cssSelector("a[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Madison");
        driver.findElement(By.id("send2")).click();

        Actions action = new Actions(driver);
        WebElement accessoriesElement = driver.findElement(By.cssSelector(".nav-3 a.has-children"));
        action.moveToElement(accessoriesElement).perform();

        driver.findElement(By.cssSelector(".nav-3-2 a"));
        driver.findElement(By.cssSelector(".nav-3-4 a")).click();
        driver.findElement(By.cssSelector("h2 [title='Isla Crossbody Handbag']")).click();
        driver.findElement(By.cssSelector(".add-to-cart-buttons .btn-cart")).click();
        driver.navigate().back();
        driver.navigate().back();
        driver.findElement(By.cssSelector(".product-name [title='Flatiron Tablet Sleeve']")).click();
        driver.findElement(By.cssSelector(".add-to-cart-buttons .btn-cart")).click();
        driver.findElement(By.cssSelector(".odd .last .btn-remove2")).click();

        WebElement totalElement = driver.findElement(By.cssSelector("#shopping-cart-totals-table tfoot .price "));
        Assert.assertEquals("150,00 RON" , totalElement.getText());

    }


    @Test
    public void proceedToCheckout () {
        driver.findElement(By.cssSelector(".skip-account span.label")).click();
        driver.findElement(By.cssSelector("a[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Madison");
        driver.findElement(By.id("send2")).click();

        Actions action = new Actions(driver);
        WebElement menElement = driver.findElement(By.cssSelector(".nav-2 .has-children"));
        action.moveToElement(menElement).perform();

        driver.findElement(By.cssSelector("a[href*= 'shirts']")).click();
        driver.findElement(By.cssSelector(".product-name a[href*='471']")).click();
        driver.findElement(By.cssSelector("[src*='white']")).click();
        driver.findElement(By.cssSelector("#swatch78 .swatch-label")).click();
        driver.findElement(By.cssSelector("[onclick*='submit(this)']")).click();
        driver.findElement(By.cssSelector(".method-checkout-cart-methods-onepage-bottom .btn-proceed-checkout")).click();

        WebElement checkoutPageElement = driver.findElement(By.cssSelector(".page-title"));
        Assert.assertEquals("CHECKOUT", checkoutPageElement.getText());

    }


    @Test
    public void sortBy () {
        driver.findElement(By.cssSelector(".skip-account span.label")).click();
        driver.findElement(By.cssSelector("a[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Madison");
        driver.findElement(By.id("send2")).click();

        Actions action = new Actions(driver);
        WebElement menElement = driver.findElement(By.cssSelector(".nav-2 .has-children"));
        action.moveToElement(menElement).perform();

        driver.findElement(By.cssSelector("a[href*= 'shirts']")).click();
        driver.findElement(By.cssSelector(".category-products > .toolbar > .sorter > div > select")).click();
        driver.findElement(By.cssSelector(".category-products > .toolbar > .sorter > div > select [value*='name']")).click();
    }

    @After
    public void exit () {
        driver.quit();
    }




}
