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

                driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > " +
                                                  "div > div > div.std > div.widget.widget-new-products > " +
                                                  "div.widget-products > ul > li:nth-child(2) > div > h3 > a")).click();
                driver.findElement(By.cssSelector("#swatch22 > span.swatch-label > img")).click();
                driver.findElement(By.cssSelector("#swatch79 > span.swatch-label")).click();
                driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > " +
                                                  "div.product-options-bottom > div.add-to-cart > " +
                                                  "div.add-to-cart-buttons > button > span > span")).click();

                WebElement wasAddedElement =
                        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > " +
                                                          "div > div > div.cart.display-single-price > ul > li > ul > " +
                                                          "li > span"));
                Assert.assertEquals("Linen Blazer was added to your shopping cart." , wasAddedElement.getText());
            }


        @Test
        public void removeFromCart () {

                driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > " +
                    "div > div > div.std > div.widget.widget-new-products > " +
                    "div.widget-products > ul > li:nth-child(2) > div > h3 > a")).click();
                driver.findElement(By.cssSelector("#swatch22 > span.swatch-label > img")).click();
                driver.findElement(By.cssSelector("#swatch79 > span.swatch-label")).click();
                driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > " +
                        "div.product-options-bottom > div.add-to-cart > " +
                        "div.add-to-cart-buttons > button > span > span")).click();

                driver.findElement(By.cssSelector("#header > div > div.skip-links > div > div > a > span.label")).click();
                driver.findElement(By.cssSelector("#cart-sidebar > li > div > a.remove")).click();
                Alert alert = driver.switchTo().alert();
                alert.accept();
                driver.findElement(By.cssSelector("#header > div > div.skip-links > div > div > a > span.label")).click();
                driver.findElement(By.cssSelector("#header > div > div.skip-links > div > div > a > span.label")).click();

                WebElement successfullyRemovedElement = driver.findElement(By.id("header-cart"));
                Assert.assertTrue(successfullyRemovedElement.isDisplayed());

            }


        //add 2 products to cart --> empty cart
        @Test
        public void emptyCart () {

                driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-6.last > a")).click();
                driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div " +
                                                  "> div.col-wrapper > div.col-main > div.category-products > ul > " +
                                                  "li:nth-child(1) > div > h2 > a")).click();
                driver.findElement(By.cssSelector("#swatch26 > span.swatch-label > img")).click();
                driver.findElement(By.cssSelector("#swatch78 > span.swatch-label")).click();
                driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > " +
                                                  "div.product-options-bottom > div.add-to-cart > " +
                                                  "div.add-to-cart-buttons > button > span > span")).click();
                driver.navigate().back();
                driver.navigate().back();

                driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > " +
                                                  "div.col-wrapper > div.col-main > div.category-products > ul > " +
                                                  "li:nth-child(2) > div > h2 > a")).click();
                driver.findElement(By.cssSelector("#swatch27 > span.swatch-label > img")).click();
                driver.findElement(By.cssSelector("#swatch65 > span.swatch-label")).click();
                driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > " +
                                                  "div.product-options-bottom > div.add-to-cart > div.add-to-cart-" +
                                                  "buttons > button > span > span")).click();

                driver.findElement(By.cssSelector("#header > div > div.skip-links > div > div > a > " +
                                                  "span.label")).click();
                driver.findElement(By.cssSelector("#header-cart > div.minicart-wrapper > div.minicart-actions " +
                                                  "> a")).click();
                driver.findElement(By.cssSelector("#empty_cart_button > span > span")).click();

                WebElement emptyCartElement =
                        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > " +
                                                          "div > div > div.page-title > h1"));
                Assert.assertEquals("SHOPPING CART IS EMPTY" , emptyCartElement.getText());
            }


        @Test
        public void changeQuantityInCart () {
            driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
            driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > " +
                                              "div > div.col-wrapper > div.col-main > div.category-products > " +
                                              "ul > li:nth-child(3) > div > h2 > a")).click();
            driver.findElement(By.cssSelector("#product_addtocart_form > div.add-to-cart-wrapper > div > div > " +
                                              "div.add-to-cart-buttons > button > span > span")).click();
            driver.findElement(By.cssSelector("#header > div > div.skip-links > div > div > a > span.label")).click();
            driver.findElement(By.cssSelector("#header-cart > div.minicart-wrapper > div.minicart-actions" +
                                              " > a")).click();
            driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-actions > ul > " +
                                              "li > a")).click();
            driver.findElement(By.cssSelector("#qty")).click();
            driver.findElement(By.cssSelector("#qty")).clear();
            driver.findElement(By.cssSelector("#qty")).sendKeys("2");
            driver.findElement(By.cssSelector("#product_addtocart_form > div.add-to-cart-wrapper > div > div > " +
                                              "div.add-to-cart-buttons > button > span > span")).click();
            WebElement quantityElement =
                    driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > " +
                                                      "div > div > div.cart.display-single-price > ul > li > ul > " +
                                                      "li > span"));
            Assert.assertEquals("Park Row Throw was updated in your shopping cart.", quantityElement.getText());



            }


       @Test
        public void estimateShippingTax () {
            Actions action = new Actions(driver);
            WebElement accessoriesElement = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-3.parent > a"));
            action.moveToElement(accessoriesElement).perform();
            driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[3]/ul/li[2]/a")).click();
            driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > " +
                                              "div.col-wrapper > div.col-main > div.category-products > ul > li > " +
                                              "div > h2 > a")).click();
            driver.findElement(By.cssSelector("#product_addtocart_form > div.add-to-cart-wrapper > div > div > " +
                                              "div.add-to-cart-buttons > button > span > span")).click();
            Select dropdownCountry = new Select(driver.findElement(By.xpath("//*[@id=\"country\"]")));
            dropdownCountry.selectByValue("FR");

            Select state = new Select(driver.findElement(By.xpath("//*[@id=\"region_id\"]")));
            state.selectByValue("251");

            driver.findElement(By.cssSelector("#city")).sendKeys("Lyon");
            driver.findElement(By.cssSelector("#postcode")).sendKeys("69000");
            driver.findElement(By.cssSelector("#shipping-zip-form > div > button > span > span")).click();

            WebElement totalElement =
                    driver.findElement(By.cssSelector("#shopping-cart-totals-table > tfoot > tr > td:nth-child(1) " +
                                                      "> strong"));
            Assert.assertEquals("GRAND TOTAL" , totalElement.getText());


        }


        @Test
        public void addInvalidDiscountCodeToCart () {

            Actions action = new Actions (driver);
            WebElement homeDecoElement = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-4.parent > a"));
            action.moveToElement(homeDecoElement).perform();
            driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[4]/ul/li[4]/a")).click();
            driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > " +
                                              "div.col-wrapper > div.col-main > div.category-products > ul > " +
                                              "li:nth-child(3) > div > div.actions > button > span > span")).click();
            driver.findElement(By.cssSelector("#coupon_code")).sendKeys("discount");
            driver.findElement(By.cssSelector("#discount-coupon-form > div > div > div > div > button > span " +
                                              "> span")).click();

            WebElement invalidCode =
                    driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > " +
                                                      "div > div > div.cart.display-single-price > ul > li > ul > " +
                                                      "li > span"));
            Assert.assertEquals("Coupon code \"discount\" is not valid." , invalidCode.getText());


        }

        @Test
        public void proceedToCheckoutWithoutLogin () {

            Actions action = new Actions(driver);
            WebElement accessoriesElement = driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-3.parent > a"));
            action.moveToElement(accessoriesElement).perform();
            driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[3]/ul/li[3]/a")).click();
            driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > " +
                                              "div.col-wrapper > div.col-main > div.category-products > ul > " +
                                              "li:nth-child(1) > div > div.actions > button > span > span")).click();
            driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > " +
                                              "div.cart.display-single-price > div.page-title.title-buttons > ul > li " +
                                              "> button > span > span")).click();
            WebElement checkout = driver.findElement(By.cssSelector("#checkout-step-login > div > div.col-1 > h3"));
            Assert.assertEquals("CHECKOUT AS A GUEST OR REGISTER" , checkout.getText());
        }



        @After
        public void exit () {
            driver.quit();
            }

        }

