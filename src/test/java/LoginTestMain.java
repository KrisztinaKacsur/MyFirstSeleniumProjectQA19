public class LoginTestMain {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");

        LoginTest login = new LoginTest();

        login.login();
        login.invalidEmailLogin();
        login.invalidPasswordLogin();

    }
}
