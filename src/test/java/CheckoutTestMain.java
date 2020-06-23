public class CheckoutTestMain {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        CheckoutTest checkoutTest = new CheckoutTest();

        checkoutTest.checkout();



    }
}
