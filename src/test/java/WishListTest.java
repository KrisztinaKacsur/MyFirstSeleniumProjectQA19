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


        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > " +
                "div.col-wrapper > div.col-main > div.category-products > ul > " +
                "li:nth-child(1) > div > div.actions > a")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > " +
                "div.product-shop > div.product-options-bottom > ul.add-to-links " +
                "> li:nth-child(1) > a")).click();
        WebElement addToWishListWithoutLogin =
                driver.findElement(By.cssSelector("#login-form > div > div.col-2.registered-users > " +
                                                  "div.content.fieldset > p.form-instructions"));
        Assert.assertEquals("If you have an account with us, please log in." , addToWishListWithoutLogin.getText());

    }


    // login, mouse hover, add to wish list
    @Test
    public void addToWishListLogin () {

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("Madison");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();

        Actions action = new Actions(driver);
        WebElement elementWomen = driver.findElement(By.xpath("/html/body/div/div[2]/header/div/div[3]/nav/ol/li[1]/a"));
        action.moveToElement(elementWomen).perform();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-1.first.parent > ul > li.level1.nav-1-4.last " +
                "> a")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout " +
                "> div > div.col-wrapper > div.col-main > div.category-products > ul > " +
                "li:nth-child(1) > div > div.actions > ul > li:nth-child(1) > a")).click();

        WebElement addedToWishListElement =
                driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > " +
                                                  "div > div.col-main > div.my-account > div.my-wishlist > ul > " +
                                                  "li > ul > li"));
        Assert.assertEquals("Essex Pencil Skirt has been added to your wishlist. Click here to continue shopping." ,
                             addedToWishListElement.getText());

    }

    //login add to wish list, remove from wish list

    @Test
    public void removeFromWishList () {

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("Madison");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();

        Actions action = new Actions(driver);
        WebElement elementAccessories = driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[3]/a"));
        action.moveToElement(elementAccessories).perform();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-3.parent > ul > li.level1.nav-3-3 > a")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > " +
                                          "div.col-wrapper > div.col-main > div.category-products > ul > " +
                                          "li:nth-child(1) > div > div.actions > ul > li:nth-child(1) > a")).click();
        driver.findElement(By.cssSelector("#item_707 > td.wishlist-cell5.customer-wishlist-item-remove.last > a")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement emptyWishListElement = driver.findElement(By.cssSelector("#wishlist-view-form > div > p"));
        Assert.assertEquals("You have no items in your wishlist." , emptyWishListElement.getText());

    }


    @Test
    public void updateQuantityInWishList () {

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("Madison");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();

        Actions action = new Actions(driver);
        WebElement elementMen = driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[2]/a"));
        action.moveToElement(elementMen).perform();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-2.parent > ul > li.level1.nav-2-4 > a")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div " +
                                          "> div.col-wrapper > div.col-main > div.category-products > ul > " +
                                          "li:nth-child(1) > div > div.actions > ul > li:nth-child(1) > a")).click();
        driver.findElement(By.xpath("//*[@id=\"item_705\"]/td[3]/div/div/input")).clear();
        driver.findElement((By.xpath("//*[@id=\"item_705\"]/td[3]/div/div/input"))).sendKeys("4");
        driver.findElement(By.cssSelector("#wishlist-view-form > div > div > button.button.btn-update.button-secondary" +
                                          " > span > span")).click();
        String updateQuantity =
                driver.findElement(By.xpath("//*[@id=\"item_705\"]/td[3]/div/div/input")).getAttribute("value");

        Assert.assertEquals("4" , updateQuantity);

    }

    @Test
    public void addFromWishListToCart () {

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("kricsk3@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("Madison");
        driver.findElement(By.cssSelector("#send2 > span > span")).click();

        Actions action = new Actions(driver);
        WebElement elementHomeDeco = driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[4]/a"));
        action.moveToElement(elementHomeDeco).perform();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-4.parent > ul > li.level1.nav-4-2 > a")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div" +
                " > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div >" +
                " div.actions > ul > li:nth-child(1) > a")).click();
        driver.findElement(By.cssSelector("#wishlist-view-form > div > div > button.button.btn-add > span > span")).click();
        WebElement addedToCartElement =
                driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > " +
                                                  "div > div.cart.display-single-price > ul > li > ul > li"));
        Assert.assertEquals("1 product(s) have been added to shopping cart: \"Body Wash with Lemon Flower Extract " +
                            "and Aloe Vera\"." , addedToCartElement.getText());


    }
    @After
    public void exit () {
        driver.quit();
    }





}
