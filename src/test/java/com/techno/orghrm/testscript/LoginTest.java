package com.techno.orghrm.testscript;
import java.io.IOException;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.techno.orghrm.base.ItestListenerIml;
import com.techno.orghrm.constant.ConstantPath;
import com.techno.orghrm.pages.DashBoardPage;
import com.techno.orghrm.pages.LoginPage;
import com.techno.orghrm.utility.ExcelOperation;


public class LoginTest extends ItestListenerIml{
	
	@Test
	public void loginTest() {
		//PredefinedActions.start();
		LoginPage loginPage = new LoginPage();
		
		
		Assert.assertTrue(loginPage.isLogoDisplayed(), "Logo No Displayed");
		DashBoardPage dashBoardPage = loginPage.doLogin("admin", "admin123");		
		
		Assert.assertTrue(dashBoardPage.isBannerDisplayed(), "Banner Not Displayed");
		
		boolean isDashboardpreselected = dashBoardPage.isdashBoardPreSelected();
		Assert.assertTrue(isDashboardpreselected,"Dashboard was not pre-selected");
		
		List<String>menuList = dashBoardPage.getMenulist();
		Assert.assertEquals(12, menuList.size(),"some menu are missing");
		
	}
	
	//@Test(dataProvider="orghrnLoginDataProvider")
	public void loginTestwithMultipledata(String username, String password, String expectedResult) {
		
		
		if(expectedResult.equals("pass")) {
			
			LoginPage loginPage = new LoginPage();
			
			
			Assert.assertTrue(loginPage.isLogoDisplayed(), "Logo No Displayed");
			DashBoardPage dashBoardPage = loginPage.doLogin("admin", "admin123");		
			
			Assert.assertTrue(dashBoardPage.isBannerDisplayed(), "Banner Not Displayed");
			
			boolean isDashboardpreselected = dashBoardPage.isdashBoardPreSelected();
			Assert.assertTrue(isDashboardpreselected,"Dashboard was not pre-selected");
			
		}
		else if(expectedResult.equals("Requried")) {
			if(!ConstantPath.URL.contains("dashboard")) {
				Assert.assertTrue(true);
			}
			else Assert.assertTrue(false);
		}
		else if(expectedResult.equals("Requried")) {
			if(!ConstantPath.URL.contains("dashboard")) {
				Assert.assertTrue(true);
			}
			else Assert.assertTrue(false);
		}
		else if(expectedResult.equals("Requried")) {
			if(!ConstantPath.URL.contains("dashboard")) {
				Assert.assertTrue(true);
			}
			else Assert.assertTrue(false);
		}
		else if(expectedResult.equals("Invalid credentialsnn")) {
			if(!ConstantPath.URL.contains("dashboard")) {
				Assert.assertTrue(true);
			}
			else Assert.assertTrue(false);
		}
		
		
	}
	@DataProvider(name = "orghrnLoginDataProvider")
	Object[][] logindata() throws IOException{
		return ExcelOperation.getSheetData("LoginData.xlsx","Data",true);
	}

}
