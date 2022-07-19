package pageObjectPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverPackage.PageDriver;
import io.qameta.allure.Step;
import utilitiesPackage.CommonMethods;

public class P008_Checkoutpage extends CommonMethods {
	public P008_Checkoutpage() {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}

	@FindBy(xpath = "(//a[@title='Proceed to checkout'])[2]")
	public WebElement SummaryProceedToCheckoutButton;

	@FindBy(name = "message")
	public WebElement commentField;

	@FindBy(css = "button[name='processAddress'] span")
	public WebElement addressProceedToCheckoutButton;

	@FindBy(id = "cgv")
	public WebElement termsOfServiceCheckbox;

	@FindBy(css = "button[name='processCarrier'] span")
	public WebElement shippingProceedToCheckoutButton;

	@FindBy(css = "a[title='Pay by check.']")
	public WebElement payByCheck;

	@FindBy(xpath = "//span[normalize-space()='I confirm my order']")
	public WebElement confirmMyOrderButton;

	public String checkoutpageTitle = "Order - My Store";

	@Step("Review Cart Summary and click on Proceed To Checkout button")
	public void clickSummaryProceedToCheckout() {
		scrollToElement(SummaryProceedToCheckoutButton);
		SummaryProceedToCheckoutButton.click();

	}

	@Step("Review Address and write Additional Information then click on Proceed To Checkout button")
	public void addCommentAndProceedToCheckout(String comment) {
		scrollToElement(addressProceedToCheckoutButton);
		sendText(commentField, comment);
		addressProceedToCheckoutButton.click();

	}

	@Step("Review Shipping details and checked Terms of service then click on Proceed To Checkout button")
	public void checkTOSAndProceedToCheckout() {
		scrollToElement(shippingProceedToCheckoutButton);
		termsOfServiceCheckbox.click();
		shippingProceedToCheckoutButton.click();

	}

	@Step("Scroll to Payment option and click on Pay By check")
	public void clickPaybyCheque() {
		scrollToElement(payByCheck);
		payByCheck.click();

	}

	@Step("Click on confirm My Order Button to complete the checkout process")
	public void clickConfirmOrder() {
		confirmMyOrderButton.click();

	}
}
