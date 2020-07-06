import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


public class CartTest {
        private WebDriver driver;


        @Before
        public void before () {
            System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://testfasttrackit.info/selenium-test/");

        }

        @Test
        public void addProductToCart () {

                driver.findElement(By.cssSelector("[href*='703']")).click();
                driver.findElement(By.cssSelector("[alt='White']")).click();
                driver.findElement(By.id("swatch79")).click();
                driver.findElement(By.cssSelector(".add-to-cart-buttons .btn-cart")).click();

                WebElement wasAddedElement =
                        driver.findElement(By.cssSelector(".success-msg"));
                Assert.assertEquals("Chelsea Tee was added to your shopping cart." , wasAddedElement.getText());
            }


        @Test
        public void removeFromCart () {

                driver.findElement(By.cssSelector("[href*='703']")).click();
                driver.findElement(By.cssSelector("[alt='Black']")).click();
                driver.findElement(By.id("swatch77")).click();
                driver.findElement(By.cssSelector(".add-to-cart-buttons .btn-cart")).click();

                driver.findElement(By.cssSelector(".header-minicart")).click();
                driver.findElement(By.cssSelector(".odd [title='Remove This Item']")).click();
                Alert alert = driver.switchTo().alert();
                alert.accept();
                driver.navigate().refresh();

                WebElement successfullyRemovedElement = driver.findElement(By.cssSelector(".page-title"));
                Assert.assertEquals("SHOPPING CART IS EMPTY",successfullyRemovedElement.getText());

            }


        //add 2 products to cart --> empty cart
        @Test
        public void emptyCart () {

                driver.findElement(By.cssSelector(".nav-6 [href]")).click();
                driver.findElement(By.cssSelector("h2.product-name [href*=sweater]")).click();
                driver.findElement(By.cssSelector("[alt='Indigo']")).click();
                driver.findElement(By.id("option78")).click();
                driver.findElement(By.cssSelector(".add-to-cart-buttons .btn-cart")).click();
                driver.navigate().back();
                driver.navigate().back();

                driver.findElement(By.cssSelector(".product-name [href*=boyfriend]")).click();
                driver.findElement(By.cssSelector("[alt='Blue']")).click();
                driver.findElement(By.id("swatch65")).click();
                driver.findElement(By.cssSelector(".add-to-cart-buttons .btn-cart")).click();
                driver.findElement(By.cssSelector(".header-minicart")).click();
                driver.findElement(By.cssSelector(".cart-link")).click();
                driver.findElement(By.id("empty_cart_button")).click();

                WebElement emptyCartElement =
                        driver.findElement(By.cssSelector(".page-title"));
                Assert.assertEquals("SHOPPING CART IS EMPTY" , emptyCartElement.getText());
            }


        @Test
        public void changeQuantityInCart () {
            driver.findElement(By.cssSelector(".nav-5")).click();
            driver.findElement(By.cssSelector(".product-name [href*='maxi']")).click();
            driver.findElement(By.cssSelector("[alt='Purple']")).click();
            driver.findElement(By.id("swatch78")).click();
            driver.findElement(By.cssSelector(".add-to-cart-buttons .btn-cart")).click();


            driver.findElement(By.cssSelector(".product-cart-actions [href*=checkout]")).click();
            driver.findElement(By.id("qty")).click();
            driver.findElement(By.id("qty")).clear();
            driver.findElement(By.id("qty")).sendKeys("2");
            driver.findElement(By.cssSelector(".add-to-cart-buttons .btn-cart")).click();
            WebElement quantityElement =
                    driver.findElement(By.cssSelector(".success-msg"));
            Assert.assertEquals("Racer Back Maxi Dress was updated in your shopping cart.", quantityElement.getText());

            }


       @Test
        public void estimateShippingTax () {
            Actions action = new Actions(driver);
            WebElement accessoriesElement = driver.findElement(By.cssSelector(".nav-3 .has-children"));
            action.moveToElement(accessoriesElement).perform();
            driver.findElement(By.cssSelector(".nav-3-1 a")).click();
            driver.findElement(By.cssSelector(".product-name [href*=eyeglasses]")).click();
            driver.findElement(By.cssSelector(".add-to-cart-buttons .btn-cart")).click();
            Select dropdownCountry = new Select(driver.findElement(By.id("country")));
            dropdownCountry.selectByValue("FR");

            Select state = new Select(driver.findElement(By.id("region_id")));
            state.selectByValue("251");

            driver.findElement(By.id("city")).sendKeys("Lyon");
            driver.findElement(By.id("postcode")).sendKeys("69000");
            driver.findElement(By.cssSelector("[title='Estimate']")).click();
            driver.findElement(By.cssSelector("[for='s_method_flatrate_flatrate']")).click();

            WebElement totalElement =
                    driver.findElement(By.cssSelector(".a-right strong .price"));
            Assert.assertEquals("295,00 RON" , totalElement.getText());


        }


        @Test
        public void addInvalidDiscountCodeToCart () {

            Actions action = new Actions (driver);
            WebElement homeDecoElement = driver.findElement(By.cssSelector(".nav-4 .has-children"));
            action.moveToElement(homeDecoElement).perform();
            driver.findElement(By.cssSelector(".nav-4-3 a")).click();
            driver.findElement(By.cssSelector(".item:nth-child(3) .btn-cart")).click();
            driver.findElement(By.id("coupon_code")).sendKeys("discount");
            driver.findElement(By.cssSelector(".button-wrapper")).click();

            WebElement invalidCode =
                    driver.findElement(By.cssSelector(".error-msg"));
            Assert.assertEquals("Coupon code \"discount\" is not valid." , invalidCode.getText());


        }

        @Test
        public void proceedToCheckoutWithoutLogin () {

            Actions action = new Actions(driver);
            WebElement accessoriesElement = driver.findElement(By.cssSelector(".nav-3 .has-children"));
            action.moveToElement(accessoriesElement).perform();
            driver.findElement(By.cssSelector(".nav-3-2 a")).click();
            driver.findElement(By.cssSelector(".item:nth-child(1) .btn-cart")).click();
            driver.findElement(By.cssSelector(".top .btn-checkout")).click();
            WebElement checkout = driver.findElement(By.cssSelector(".col-1 h3"));
            Assert.assertEquals("CHECKOUT AS A GUEST OR REGISTER" , checkout.getText());
        }



        @After
        public void exit () {
            driver.quit();
            }

        }

