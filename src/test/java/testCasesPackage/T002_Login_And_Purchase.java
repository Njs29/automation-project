package testCasesPackage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import driverPackage.BaseDriver;
import io.qameta.allure.Description;
import pageObjectPackage.P001_Homepage;
import pageObjectPackage.P002_SignInpage;
import pageObjectPackage.P004_MyAccountpage;
import pageObjectPackage.P005_CasualDressespage;
import pageObjectPackage.P006_T_Shirtspage;
import pageObjectPackage.P007_Cartpage;
import pageObjectPackage.P008_Checkoutpage;
import testDataPackage.DataSet;
import utilitiesPackage.Take_Screenshot;

public class T002_Login_And_Purchase extends BaseDriver {

	@Test(description = "Perform Login, Purchase, and Logout", dataProvider = "userInfo", dataProviderClass = DataSet.class)
	@Description("Test Description: This test will log-in to automationpractice.com, "
			+ "Then add two different category products to the cart and complete the checkout process with payment. "
			+ "Finally, It will Sign out from the system.")
	public void loginAndPurchase(String email, String password, String comment) {
		P001_Homepage homepage = new P001_Homepage();
		P002_SignInpage signInpage = new P002_SignInpage();
		P004_MyAccountpage myAccountpage = new P004_MyAccountpage();
		P005_CasualDressespage casualDressespage = new P005_CasualDressespage();
		P006_T_Shirtspage t_Shirtspage = new P006_T_Shirtspage();
		P007_Cartpage cartpage = new P007_Cartpage();
		P008_Checkoutpage checkoutpage = new P008_Checkoutpage();
		SoftAssert softAssert = new SoftAssert();

		// Got to Sign Page
		homepage.clickSignInButton();

		// Waiting for Completely load Sing In page
		signInpage.waitForPageLoad();
		
		softAssert.assertEquals(signInpage.getTitle(), signInpage.signinPageTitle);

		// Provide email & password and click on Log In for complete Login Process
		signInpage.loginwithEmailPassword(email, password);

		// Taking a screenshot for reporting purpose
		Take_Screenshot.takeScreenShot("After Log In -My Account Page");

		// Click Casual Dresses from Menu bar by hover on Dresses
		homepage.hoverAndClickCasualDresses();

		// Waiting for Completely load Casual Dresses page
		casualDressespage.waitForPageLoad();
		
		softAssert.assertEquals(casualDressespage.getTitle(), casualDressespage.casualDressesPageTitle);

		// Scroll to product and add product to cart
		casualDressespage.productAddToCart();

		// Choose Continue Shopping option
		cartpage.clickContinueShopping();

		// Click on T-Shirts from Menu bar
		homepage.clickOnTShirtsButton();

		// Waiting for Completely load T-Shirts page
		t_Shirtspage.waitForPageLoad();
		
		softAssert.assertEquals(t_Shirtspage.getTitle(), t_Shirtspage.t_ShirtsPageTitle);

		// Filter Blue Color from CATALOG-Color section
		t_Shirtspage.filterBlueColor();

		// Scroll to product and add product to cart
		t_Shirtspage.productAddToCart();

		// Choose Proceed To Checkout option
		cartpage.clickProceedToCheckout();

		// Waiting for Completely load Order/Checkout page
		checkoutpage.waitForPageLoad();
		
		softAssert.assertEquals(checkoutpage.getTitle(), checkoutpage.checkoutpageTitle);

		// Taking a screenshot for reporting purpose
		Take_Screenshot.takeScreenShot("Cart Details");

		// Click Order/Checkout summary page 'Proceed To Checkout' button
		checkoutpage.clickSummaryProceedToCheckout();

		// Write addition info and Click Order/Checkout Address page 'Proceed To
		// Checkout' button
		checkoutpage.addCommentAndProceedToCheckout(comment);

		// Agree TOS and Click Order/Checkout shipping page 'Proceed To Checkout' button
		checkoutpage.checkTOSAndProceedToCheckout();

		// Scroll and select Pay By Check option
		checkoutpage.clickPaybyCheque();

		// Scroll and click on "I confirm my order" button for complete checkout process
		checkoutpage.clickConfirmOrder();

		myAccountpage.clickSignOutButton();
		
		softAssert.assertAll();
	}

}
