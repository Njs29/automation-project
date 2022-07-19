package pageObjectPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverPackage.PageDriver;
import io.qameta.allure.Step;
import utilitiesPackage.CommonMethods;
import utilitiesPackage.Take_Screenshot;

public class P002_SignInpage extends CommonMethods {
	public P002_SignInpage() {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}

	@FindBy(id = "email_create")
	public WebElement emailInputField;

	@FindBy(id = "SubmitCreate")
	public WebElement createAccountButton;

	@FindBy(id = "email")
	public WebElement emailLoginField;

	@FindBy(id = "passwd")
	public WebElement passwordLoginField;

	@FindBy(id = "SubmitLogin")
	public WebElement signInButton;
	
	public String signinPageTitle = "Login - My Store";

	@Step("Provide an Email address and click on create an Account button")
	public void createAccountWithEmail(String email) {
		sendText(emailInputField, email);
		createAccountButton.click();

	}

	@Step("Provide an Email & Password and click on Sign In button")
	public void loginwithEmailPassword(String email, String password) {
		sendText(emailLoginField, email);
		sendText(passwordLoginField, password);
		// Taking a screenshot for reporting purpose
		Take_Screenshot.takeScreenShot("Log In Information");
		signInButton.click();

	}
}
