package utilitiesPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverPackage.PageDriver;

public class CommonMethods {
	
	/************************
	 * Get Current Page URL * 
	 * **********************
	 */

	public String currentPageUrl() {
		return PageDriver.getCurrentDriver().getCurrentUrl();
	}
	
	/**************************
	 * Get Current Page Title * 
	 * ************************
	 */
	
	public String getTitle() {
		return PageDriver.getCurrentDriver().getTitle();
	}
	
	/**************************
	 * Write in a input field 
	 * @param element This is the target element where to write
	 * @param value what to write
	 * ************************
	 */

	public void sendText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	
	/******************************
	 * Perform Hover on an element 
	 * @param element This is the target element where to perform hover action
	 * ****************************
	 */
	public void hover(WebElement element) {
		Actions actions = new Actions(PageDriver.getCurrentDriver());
		actions.clickAndHold(element).build().perform();
	}
	
	/***********************************
	 * Handle shadow Dome Related Task
	 * @param host is the root element shadow dome
	 * @param element is the targeted element within the shadow dome
	 * *********************************
	 */

	public void shadowDomePopUp(WebElement host, By element) {
		// Finding the ShadowRoot in a WebElement
		SearchContext context = host.getShadowRoot();
		// finding the targeted element
		context.findElement(element).click();
	}
	
	/******************************************
	 * Handle Select Tag Related Element Task * 
	 * ****************************************
	 */
	
	/*********************************************
	 * Handle Select Tag Related Element Task    *
	 * @param element locator of Select tag      *
	 * @param value attribute value of option tag* 
	 * *******************************************
	 */

	public void selectitem(WebElement element, String value) {
		Select selectItems = new Select(element);
		selectItems.selectByValue(value);
	}

	// Get selected item's text
	public String selecteditemText(WebElement element) {
		Select selectItems = new Select(element);
		return selectItems.getFirstSelectedOption().getText();
	}
	
	// Get Items select status True if selected or false
	public Boolean itemSelectStatus(List<WebElement> elements, String value) {
		for (WebElement element : elements) {
			if (element.getAttribute("value").equals(value)) {
				return element.isSelected();
			}
		}
		return false;
	}
	
	/*************************************
	 * Handle List elements Related Task * 
	 * ***********************************
	 */
	
	// Perform any action on nth number elements from an elements list 
	public void clickOnNthNumberButton(List<WebElement> elements, int position) {
		elements.get(position - 1).click();
	}
	
	// Perform click action on a element where visible Text match from an elements list 
	public void listitem(List<WebElement> elements, String visibleText) {
		for (WebElement element : elements) {
			if (element.getText().equals(visibleText)) {
				element.click();
				break;
			}
		}
	}
	
	/**********************************
	 * Handle JavaScript Related Task * 
	 * ********************************
	 */
	// click on a hidden element by using JavascriptExecutor 
	public void clickOnAButtonJs(String script) {
		JavascriptExecutor js = (JavascriptExecutor) PageDriver.getCurrentDriver();
		js.executeScript(script + ".click();");
	}
	
	// Set any DOM element Border color using JavascriptExecutor 
	public void highlighter(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) PageDriver.getCurrentDriver();
		js.executeScript("arguments[0].setAttribute('style','border:2px solid red;background: beige');", element);
	}

	/*********************************************
	 * Scroll to an element
	 * @param element This is the target element * 
	 * *******************************************
	 */
	
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) PageDriver.getCurrentDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	/*********************************************
	 * Scroll Within an element
	 * @param cssLocator is the target element's cssLocator/query selector * 
	 * @param offsetX is the scroll position relative to x axis
	 * @param offsetY is the scroll position relative to Y axis
	 * *******************************************
	 */
	public void scrollInsideElement(String cssLocator, int offsetX, int offsetY) {
		JavascriptExecutor js = (JavascriptExecutor) PageDriver.getCurrentDriver();
		js.executeScript("document.querySelector('" + cssLocator + "').scrollBy(" + offsetX + "," + offsetY + ");");
	}

	/****************************
	 * Handle Wait Related Task * 
	 * **************************
	 */
	WebDriverWait wait;
	// wait for default set seconds  
	public void timeOut() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// wait for customize given seconds  
	public void timeOut(int duretionMS) {
		try {
			Thread.sleep(duretionMS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Wait for an alert present and return with an alert
	public Alert waitForAlert() {
		wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(30));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		return alert;
	}
	
	// Wait for an element to be present
	public void waitForElement(By element) {
		wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}

	/********************************************
	 * Wait for completely load current web page* 
	 * ******************************************
	 */
	public void waitForPageLoad() {
		wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(30));
		wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState;").equals("complete"));
	}

	/*****************************
	 * Handle Alert Related Task * 
	 * ***************************
	 */
	
	// Accept alert whenever it present
	public void alertAccept() {
		Alert alert = waitForAlert();
		alert.accept();
	}
	// Accept alert with giving text whenever it present
	public void allertAccept(String value) {
		Alert alert = waitForAlert();
		alert.sendKeys(value);
		alert.accept();
	}
	// Decline alert whenever it present
	public void alertDismiss() {
		Alert alert = waitForAlert();
		alert.dismiss();
	}

}
