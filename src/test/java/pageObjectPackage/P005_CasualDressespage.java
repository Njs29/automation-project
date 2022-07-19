package pageObjectPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverPackage.PageDriver;
import io.qameta.allure.Step;
import utilitiesPackage.CommonMethods;

public class P005_CasualDressespage extends CommonMethods {
	public P005_CasualDressespage() {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}

	@FindBy(className = "product-container")
	public WebElement product;

	@FindBy(xpath = "//span[normalize-space()='Add to cart']")
	public WebElement addToCartButton;
	
	public String casualDressesPageTitle = "Casual Dresses - My Store";

	@Step("Scroll to Product then Hover on Product and Click on add To Cart Button Button")
	public void productAddToCart() {
		scrollToElement(product);
		hover(product);
		addToCartButton.click();

	}
}
