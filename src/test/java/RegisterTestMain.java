public class RegisterTestMain {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");

        RegisterTest registerTest = new RegisterTest();

        registerTest.registerNewUser();



    }
}
