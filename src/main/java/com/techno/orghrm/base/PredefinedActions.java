package com.techno.orghrm.base;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.techno.orghrm.constant.ConstantPath;

public class PredefinedActions {
	
	protected static WebDriver driver;
	static private WebDriverWait wait;
	
	
	static public void start() {
		start("admin", "admin123",ConstantPath.URL);
	}
	
	static public void start(String username, String password, String url) {
		System.setProperty(ConstantPath.CHROMEDRIVER, ConstantPath.CROMEDRIVEREXE);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(ConstantPath.AVGWAIT));
	}
	
	protected WebElement getElement(String locatorType, String locator, boolean isWaitRequried) {
		WebElement element ;
		switch(locatorType.toUpperCase()) {
		case "XPATH":
			if(isWaitRequried) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			}
			else {
				element = driver.findElement(By.xpath(locator));
			}
			break;
			
		case "ID":
			if(isWaitRequried) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
			}
			else {
				element = driver.findElement(By.id(locator));
				
			}
			break;
			
		case "CLASSNAME":
			if(isWaitRequried) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
			}
			else {
				element = driver.findElement(By.className(locator));
			}
			break;
			
		case "NAME":
			if(isWaitRequried) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
			}
			else {
				element = driver.findElement(By.name(locator));
			}
			break;
			
		case "LINKTEXT":
			if(isWaitRequried) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
			}
			else {
				element = driver.findElement(By.linkText(locator));
			}
			break;
			
		case "TAGNAME":
			if(isWaitRequried) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locator)));
			}
			else {
				element = driver.findElement(By.tagName(locator));
			}
			break;
			
		case "PARTIALLINKTEXT":
			if(isWaitRequried) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator)));
			}
			else {
				element = driver.findElement(By.partialLinkText(locator));
			}
			break;
			
		case "CSSSELECTOR":
			if(isWaitRequried) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
			}
			else {
				element = driver.findElement(By.cssSelector(locator));
			}
			break;
			
			default:
				element = null;
				System.out.println("invalid locatortype");
			
		}
	
		return element;
	}
	
	protected List<WebElement> getAllElements(String locatorType, String locator, boolean isWaitRequried){
		List<WebElement> elements = new ArrayList<>();
		switch(locatorType.toUpperCase()) {
		case "XPATH":
			if(isWaitRequried) {
				elements =  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
			}
			else {
				elements = driver.findElements(By.xpath(locator));
			}
			break;
			
		case "ID":
			if(isWaitRequried) {
				elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(locator)));
			}
			else {
				elements = driver.findElements(By.id(locator));
				
			}
			break;
			
		case "CLASSNAME":
			if(isWaitRequried) {
				elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(locator)));
			}
			else {
				elements = driver.findElements(By.className(locator));
			}
			break;
			
		case "NAME":
			if(isWaitRequried) {
				elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(locator)));
			}
			else {
				elements = driver.findElements(By.name(locator));
			}
			break;
			
		case "LINKTEXT":
			if(isWaitRequried) {
				elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(locator)));
			}
			else {
				elements = driver.findElements(By.linkText(locator));
			}
			break;
			
		case "TAGNAME":
			if(isWaitRequried) {
				elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName(locator)));
			}
			else {
				elements = driver.findElements(By.tagName(locator));
			}
			break;
			
		case "PARTIALLINKTEXT":
			if(isWaitRequried) {
				elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.partialLinkText(locator)));
			}
			else {
				elements = driver.findElements(By.partialLinkText(locator));
			}
			break;
			
		case "CSSSELECTOR":
			if(isWaitRequried) {
				elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(locator)));
			}
			else {
				elements = driver.findElements(By.cssSelector(locator));
			}
			break;
			
			default:
				elements = null;
				System.out.println("invalid locatortype");
			
		}
	
		return elements;
	}
	
	
	protected void scrollToElement(WebElement element) {
		if(!element.isDisplayed()) {
			JavascriptExecutor je = (JavascriptExecutor)driver;
			je.executeScript("arguments[0].scrollintoView(true)", element);
		}
	}
	
	protected boolean isElementDisplayed(WebElement element) {
		if(element.isDisplayed()) {
			return true;
		}
		else{
			scrollToElement(element);
			return element.isDisplayed();
		}
	}
	
	protected boolean isElementDisplayed(String loactorType, String locator, boolean isWaitRequried) {
		try {
			WebElement element = getElement(loactorType, locator, isWaitRequried);
			return isElementDisplayed(element);
		}
		catch(Exception e) {
			return false;
		}
		
	}
	
	protected String getElementText(WebElement element) {
		scrollToElement(element);
		return element.getText();
	}
	
	protected String getElementText(String locatorType, String locator, boolean isWaitRequried) {
		WebElement element = getElement(locatorType, locator, isWaitRequried);
		scrollToElement(element);
		return element.getText();
	}
	
	protected void enterText(WebElement element, String text) {
		scrollToElement(element);
		if(element.isEnabled())
			element.sendKeys(text);
	}
	
	protected void enterText(String locatorType, String locator, boolean isWaitRequried, String text) {
		WebElement element = getElement(locatorType, locator, isWaitRequried);
		scrollToElement(element);
		if(element.isEnabled()) {
			element.sendKeys(text);
		}
		//else throw new ElementNotEnabled("element was not enabled for locatorType "+locatorType+" locator value "+locator)
	}
	
	protected void clickOnElement(WebElement element) {
		scrollToElement(element);
		 wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	protected void clickOnElement(String locatorType, String locator, boolean isWaitRequried) {
		WebElement element = getElement(locatorType, locator, isWaitRequried);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	protected String getElementAttribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}
	
	protected String getElementAttribute(String locatorType, String locator, boolean isWaitRequried, String attribute) {
		return getElement(locatorType, locator, isWaitRequried).getAttribute(attribute);
	}
	
	
	static public void tearDown() {
		driver.close();
	}

}
