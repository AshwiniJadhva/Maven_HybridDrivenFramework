package com.techno.orghrm.testscript;

//import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.techno.orghrm.base.PredefinedActions;
import com.techno.orghrm.pages.DashBoardPage;
import com.techno.orghrm.pages.LoginPage;
//import com.techno.orghrm.testdata.MenuList;

public class DashBoardTest {
	
	//@Test
	void dashBoard() {
		MenuList menuList = new MenuList();
		List<String> expectedMenuList = menuList.dashboardpageMainMenuList();
		List<String> expectedWidgetList = menuList.widgetList();
		//PredefinedActions.start();
		LoginPage loginPage = new LoginPage();
		DashBoardPage dashBoardPage = loginPage.doLogin("admin", "admin123");
		//DashBoardPage dashBoardPage = new DashBoardPage();
		List<String> actaulMenuList = dashBoardPage.getMenulist();
		System.out.println("menu list - "+actaulMenuList);
		List<String> actaulWidgetList = dashBoardPage.getWidgetList();
		System.out.println("widget list - "+actaulWidgetList);
		Assert.assertEquals(expectedMenuList, actaulMenuList);
		Assert.assertEquals(actaulWidgetList, expectedWidgetList);
		PredefinedActions.tearDown();
	}

}
