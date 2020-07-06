import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static javax.swing.text.html.CSS.getAttribute;

public class WishListTest {
    private WebDriver driver;

    @Before
    public void before () {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }



    //lab 16 ex 5

    @Test
    public void addToWishListSale () {


        driver.findElement(By.cssSelector(".nav-5 a.has-children")).click();
        driver.findElement(By.cssSelector("a[href*='racer'][title='View Details']")).click();
        driver.findElement(By.cssSelector(".link-wishlist")).click();
        WebElement addToWishListWithoutLogin =
                driver.findElement(By.cssSelector(".fieldset .form-instructions"));
        Assert.assertEquals("If you have an account with us, please log in." , addToWishListWithoutLogin.getText());

    }


    // login, mouse hover, add to wish list
    @Test
    public void addToWishListLogin () {

        driver.findElement(By.cssSelector(".skip-account span.label")).click();
        driver.findElement(By.cssSelector("a[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Madison");
        driver.findElement(By.id("send2")).click();

        Actions action = new Actions(driver);
        WebElement elementWomen = driver.findElement(By.cssSelector("a[href*='women'].has-children"));
        action.moveToElement(elementWomen).perform();
        driver.findElement(By.cssSelector("[href*='dresses']")).click();
        driver.findElement(By.cssSelector("a[href*='422'].link-wishlist")).click();

        WebElement addedToWishListElement =
                driver.findElement(By.cssSelector(".success-msg li"));
        Assert.assertEquals("Essex Pencil Skirt has been added to your wishlist. Click here to continue shopping." ,
                             addedToWishListElement.getText());

    }

    //login add to wish list, remove from wish list

    @Test
    public void removeFromWishList () {

        driver.findElement(By.cssSelector(".skip-account span.label")).click();
        driver.findElement(By.cssSelector("a[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Madison");
        driver.findElement(By.id("send2")).click();

        Actions action = new Actions(driver);
        WebElement elementAccessories = driver.findElement(By.cssSelector("a[href*='accessories'].has-children"));
        action.moveToElement(elementAccessories).perform();
        driver.findElement(By.cssSelector("[href*='shoes']")).click();
        driver.findElement(By.cssSelector("[href*='430'].link-wishlist")).click();
        driver.findElement(By.cssSelector(".btn-remove2")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement emptyWishListElement = driver.findElement(By.cssSelector(".wishlist-empty"));
        Assert.assertEquals("You have no items in your wishlist." , emptyWishListElement.getText());

    }


    @Test
    public void updateQuantityInWishList () {

        driver.findElement(By.cssSelector(".skip-account span.label")).click();
        driver.findElement(By.cssSelector("a[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Madison");
        driver.findElement(By.id("send2")).click();

        Actions action = new Actions(driver);
        WebElement elementMen = driver.findElement(By.cssSelector(".nav-2 .has-children"));
        action.moveToElement(elementMen).perform();
        driver.findElement(By.cssSelector(".nav-2-4 [href*='pants']")).click();
        driver.findElement(By.cssSelector("[href*='414'].link-wishlist")).click();
        driver.findElement(By.cssSelector(".input-text.qty")).clear();
        driver.findElement((By.cssSelector(".input-text.qty"))).sendKeys("4");
        driver.findElement(By.cssSelector(".buttons-set2 .btn-update")).click();
        String updateQuantity =
                driver.findElement(By.cssSelector(".input-text.qty")).getAttribute("value");
        Assert.assertEquals("4" , updateQuantity);
    }

    @Test
    public void addFromWishListToCart () {

        driver.findElement(By.cssSelector(".skip-account span.label")).click();
        driver.findElement(By.cssSelector("a[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Madison");
        driver.findElement(By.id("send2")).click();

        Actions action = new Actions(driver);
        WebElement elementHomeDeco = driver.findElement(By.cssSelector(".nav-4 .has-children"));
        action.moveToElement(elementHomeDeco).perform();
        driver.findElement(By.cssSelector(".nav-4-2 [href]")).click();
        driver.findElement(By.cssSelector("[href*='378'].link-wishlist")).click();
        driver.findElement(By.cssSelector(".btn-add")).click();
        WebElement addedToCartElement =
                driver.findElement(By.cssSelector(".success-msg"));
        Assert.assertEquals("1 product(s) have been added to shopping cart: \"Body Wash with Lemon Flower Extract " +
                            "and Aloe Vera\"." , addedToCartElement.getText());


    }
    @After
    public void exit () {
        driver.quit();
    }




}
