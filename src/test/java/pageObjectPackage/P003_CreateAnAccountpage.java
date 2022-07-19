package pageObjectPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverPackage.PageDriver;
import io.qameta.allure.Step;
import utilitiesPackage.CommonMethods;
import utilitiesPackage.Take_Screenshot;

public class P003_CreateAnAccountpage extends CommonMethods {

	public P003_CreateAnAccountpage() {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}

	@FindBy(css = "label[for='id_gender1']")
	public WebElement mrTitle;

	@FindBy(css = "label[for='id_gender2']")
	public WebElement mrsTitle;

	@FindBy(id = "customer_firstname")
	public WebElement firstName;

	@FindBy(id = "customer_lastname")
	public WebElement lastName;
	
	@FindBy(id = "email")
	public WebElement emailField;

	@FindBy(id = "passwd")
	public WebElement passwordField;

	@FindBy(id = "days")
	public WebElement dayforDOB;

	@FindBy(id = "months")
	public WebElement monthforDOB;

	@FindBy(id = "years")
	public WebElement yearforDOB;

	@FindBy(id = "newsletter")
	public WebElement newsletter;

	@FindBy(id = "optin")
	public WebElement offer;

	@FindBy(id = "company")
	public WebElement companyNameField;

	@FindBy(id = "address1")
	public WebElement yourAddressOneField;

	@FindBy(id = "address2")
	public WebElement yourAddressTwoField;

	@FindBy(id = "city")
	public WebElement cityfield;

	@FindBy(id = "id_state")
	public WebElement stateSelect;

	@FindBy(id = "postcode")
	public WebElement postCode;

	@FindBy(id = "id_country")
	public WebElement countrySelect;

	@FindBy(id = "other")
	public WebElement otherInformationfield;

	@FindBy(id = "phone")
	public WebElement homePhonefield;

	@FindBy(id = "phone_mobile")
	public WebElement mobilePhoneField;

	@FindBy(id = "alias")
	public WebElement aliasfield;

	@FindBy(id = "submitAccount")
	public WebElement registerButton;
	
	@FindBy(xpath = "//h3[normalize-space()='Your personal information']")
	public WebElement pageSubHeading;
	
	public String pageSubHeadingText = "YOUR PERSONAL INFORMATION";
	

	@Step("Provide New User Personal Information")
	public void fillPersonalInformation(String fisrtname, String lastname, String password, String day, String month,
			String year) {
		mrTitle.click();
		sendText(firstName, fisrtname);
		sendText(lastName, lastname);
		sendText(passwordField, password);
		selectitem(dayforDOB, day);
		selectitem(monthforDOB, month);
		selectitem(yearforDOB, year);
		newsletter.click();
		offer.click();
		// Taking a screenshot for reporting purpose
		Take_Screenshot.takeScreenShot("Personal Information");
	}

	@Step("Provide New User Address Information")
	public void fillYourAddress(String companyName, String addressone, String addresstwo, String city, String statename,
			String zipCode, String countryname, String addiAddress, String homephone, String mobilephone,
			String alias) {
		sendText(companyNameField, companyName);
		sendText(yourAddressOneField, addressone);
		sendText(yourAddressTwoField, addresstwo);
		sendText(cityfield, city);
		selectitem(stateSelect, statename);
		sendText(postCode, zipCode);
		selectitem(countrySelect, countryname);
		sendText(otherInformationfield, addiAddress);
		sendText(homePhonefield, homephone);
		sendText(mobilePhoneField, mobilephone);
		sendText(aliasfield, alias);
		// Taking a screenshot for reporting purpose
		Take_Screenshot.takeScreenShot("Address Information");

	}

	public void clickOnRegisterButton() {
		registerButton.click();
	}
}
