package com.techno.orghrm.pages;

import com.techno.orghrm.base.PredefinedActions;

public class LoginPage extends PredefinedActions{
	
	public boolean isLogoDisplayed() {
		return isElementDisplayed("xPath", "//div[@class='orangehrm-login-logo']",true);
		
	}
	
	public DashBoardPage doLogin(String username, String password) {
		enterUserName(username);
		enterPassWord(password);
		return clickonbutton();
	}
	
	public LoginPage enterUserName(String username) {
		//driver.findElement(By.name("username")).sendKeys("admin");
		enterText("xpath", "//input[@name='username']", true, username);
		return this;
	}
	
	public LoginPage enterPassWord(String password) {
		//driver.findElement(By.name("password")).sendKeys("admin123");
		enterText("name", "password",false,password);
		return this;
	}
	
	public DashBoardPage clickonbutton() {
		//driver.findElement(By.xpath(" //button[text()=' Login ']")).click();
		clickOnElement("xpath", " //button[text()=' Login ']", false);
		return new DashBoardPage();
	}
	
	
	
	
	
	
}
