package pageObjectPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverPackage.PageDriver;
import io.qameta.allure.Step;
import utilitiesPackage.CommonMethods;

public class P006_T_Shirtspage extends CommonMethods {
	public P006_T_Shirtspage() {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}

	@FindBy(id = "layered_id_attribute_group_14")
	public WebElement filterBlueColorCheckbox;

	@FindBy(className = "product-container")
	public WebElement product;

	@FindBy(xpath = "//span[normalize-space()='Add to cart']")
	public WebElement addToCartButton;
	
	public String t_ShirtsPageTitle = "T-shirts - My Store";

	@Step("Filter Blue Color from CATALOG-Color section")
	public void filterBlueColor() {
		filterBlueColorCheckbox.click();
	
	}
	@Step("Scroll to Product then Hover on Product and Click on add To Cart Button Button")
	public void productAddToCart() {
		scrollToElement(product);
		hover(product);
		addToCartButton.click();
	}
}
