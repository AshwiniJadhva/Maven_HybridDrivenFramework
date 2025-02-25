package com.techno.orghrm.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.Test;


import com.techno.orghrm.base.PredefinedActions;

public class DashBoardPage extends PredefinedActions{
	

	//@Test
	/*
	 * void dashboardTest() throws InterruptedException{
	 * 
	 * System.out.println("STEP 1. Lounch Broswer and open URL");
	 * PredefinedActions.start(); Thread.sleep(3000);
	 * driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
	 * driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123"
	 * ); driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	 * System.out.println("STEP 2. Check available wigdets"); int actualWidgetsCount
	 * = 7; Thread.sleep(3000); int expectedWidgetCount = driver.findElements(By.
	 * xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget']"
	 * )).size(); Assert.assertEquals(expectedWidgetCount, actualWidgetsCount); }
	 */
	
	public boolean isBannerDisplayed() {
		
		return isElementDisplayed("className", "oxd-brand-banner", true);
	}
	
	public boolean isdashBoardPreSelected() {
		String attributeValue = getElementAttribute("xPath", "//a[@class='oxd-main-menu-item active']", true, "class");
		return attributeValue.contains("active") ? true:false;
	}
	
	public List<String> getMenulist(){
		List<WebElement> list = getAllElements("xPath", "//li[@class='oxd-main-menu-item-wrapper']", true);
		List<String> menuList = new ArrayList<String>();
		for(WebElement e: list) {
			menuList.add(e.getText());
		}
		return menuList;
	}
	
	
	public List<String> getWidgetList() {
		
		ArrayList<String> wedgetTextList = new ArrayList<String>();
		//List<WebElement> list = driver.findElements(By.xpath("//div[@class='orangehrm-dashboard-widget-name']"));
		List<WebElement> list = getAllElements("xpath","//div[@class='orangehrm-dashboard-widget-name']",false);
		for(WebElement e :list) {
			wedgetTextList.add(e.getText());
			
		}
		//System.out.println(wedgetTextList);
		return wedgetTextList;
	
	}
	
	
	

}
