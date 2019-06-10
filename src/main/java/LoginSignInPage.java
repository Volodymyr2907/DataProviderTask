import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSignInPage {

    @FindBy (id = "email_create")
    private WebElement inputEmailField;

    @FindBy (id= "SubmitCreate")
    private WebElement createAnAccountButton;

    @FindBy (xpath = "//*[@id=\"create_account_error\"]/ol/li")
    private WebElement errorMessage;


    LoginSignInPage (WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }

    public void inputEmail (String newEmail) {
        inputEmailField.sendKeys(newEmail);
    }

    public void tapButtonCreateAnAccount () {
        createAnAccountButton.click();
    }

    public String getErrorMessage() {
        return  errorMessage.getText();
    }

}
