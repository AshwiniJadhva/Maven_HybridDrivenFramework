

import java.util.ArrayList;
import java.util.List;

public class MenuList {
	
	public List<String>  dashboardpageMainMenuList() {
		List<String> expectedMenuList = new ArrayList<String>();
		
		expectedMenuList.add("Admin");
		expectedMenuList.add("PIM");
		expectedMenuList.add("Leave");
		expectedMenuList.add("Time");
		expectedMenuList.add("Recruitment");
		expectedMenuList.add("My Info");
		expectedMenuList.add("Performance");
		expectedMenuList.add("Dashboard");
		expectedMenuList.add("Directory");
		expectedMenuList.add("Maintenance");
		expectedMenuList.add("Claim");
		expectedMenuList.add("Buzz");
		
		return expectedMenuList;
	}
	
	public List<String> widgetList() {
		List<String> expectedWidgetList = new ArrayList<String>();
		
		expectedWidgetList.add("Time at Work");
		expectedWidgetList.add("My Actions");
		expectedWidgetList.add("Quick Launch");
		expectedWidgetList.add("Buzz Latest Posts");
		expectedWidgetList.add("Employees on Leave Today");
		expectedWidgetList.add("Employee Distribution by Sub Unit");
		expectedWidgetList.add("Employee Distribution by Location");
		
		return expectedWidgetList;
		
	}

}
