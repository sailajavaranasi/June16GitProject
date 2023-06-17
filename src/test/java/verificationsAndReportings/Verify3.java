package verificationsAndReportings;

import com.aventstack.extentreports.Status;

import selenium.BaseTest;

public class Verify3 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		test = report.createTest("Verify3");
		test.log(Status.INFO, "init the properties files...");
		
		launch("chromebrowser");
		test.log(Status.PASS, "Opened the Browser : " +  p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(Status.INFO, "Navigated to url : " + childProp.getProperty("amazonurl"));
		
		String expectedLink = "Customer service";
		
		if(!isLinksEqual(expectedLink))
			//System.out.println("Both links are not equal...");
			reportFailure("Both links are not equal...");
		else
			//System.out.println("Both Links are equal...");
			reportSuccess("Both Links are equal...");
		
		report.flush();
	}


}
