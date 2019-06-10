import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ErrorMessageTest {


    private WebDriver webDriver;

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "D:\\ITEA\\ChromeDriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @DataProvider(name = "createAnAccountValidation")
    public Object[][] dataProviderMethod() {
        return new Object[][]
                {
                        {"invalidEmailAddress","Invalid email address."},
                        {"vvyastrubchak@gmail.com","An account using this email address has already been registered. Please enter a valid password or request a new one."}

                };
    }

    @Test (dataProvider = "createAnAccountValidation")
    public void testErrorMessage(String emailAddressValue, String expectedErrorMessage) {
        LoginSignInPage loginSignInPage = new LoginSignInPage(webDriver);
        loginSignInPage.inputEmail(emailAddressValue);
        loginSignInPage.tapButtonCreateAnAccount();
        webDriver.findElement(By.id("email_create")).clear();


        String actualText = loginSignInPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage,actualText);
    }


}
