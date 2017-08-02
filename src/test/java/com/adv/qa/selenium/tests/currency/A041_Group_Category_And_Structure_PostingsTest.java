package com.adv.qa.selenium.tests.currency;

import java.util.List;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.adv.qa.selenium.framework.Assert;
import com.adv.qa.selenium.framework.BaseTest;
import com.adv.qa.selenium.framework.pageObjects.LoginPage;
import com.adv.qa.selenium.framework.pageObjects.currency.CurrencyPage;
import com.adv.qa.selenium.helpers.DataResource;
import com.adv.qa.selenium.helpers.DataRow;

/**
 * @author : Draxayani Test Reference No : A041 Group Category & Structure
 *         Postings Purpose : Run Group Category and Structure Postings Update
 *         Date : 26-05-2014 
 *         ACCESS : Submit EP4 and Submit EP5
 *         Modified: Chetna Dt:11 July 2017, for Process 1,2 & 3
 */

public class A041_Group_Category_And_Structure_PostingsTest extends BaseTest {
	/* Launch the browser */
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}

	@Test( dataProvider ="dp")
	public void verify(DataRow dataRow) throws InterruptedException{
		String userName = dataRow.get("userName");
		String passWord = dataRow.get("passWord");
		List<String> ep1ProcessList = dataRow.findNamesReturnValues("ep1ProcessList");
		List<String> ep2ProcessList = dataRow.findNamesReturnValues("ep2ProcessList");
		List<String> ep3ProcessList = dataRow.findNamesReturnValues("ep3ProcessList");
		List<String> ep4ProcessList = dataRow.findNamesReturnValues("ep4ProcessList");
		List<String> ep5ProcessList = dataRow.findNamesReturnValues("ep5ProcessList");
		List<String> ep1PathFun = dataRow.findNamesReturnValues("ep1PathFun");
		
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPage currencyPage = new CurrencyPage(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
	
	

		/*Enter Process Details EP1*/
		currencyPage.fillCurrenceyCode(ep1ProcessList.get(0));
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+ep1ProcessList.get(1)+" - Path Rebuild Parameters","Structure Rebuild page","displayed");
			
		currencyPage.enterEP1ProcessDetails(ep1ProcessList,3, companyId, ep1PathFun);	//Need to create for EP1
	
		currencyPage.enterAboutsubmitDetails();
		
		processVerification(currencyPage,ep1ProcessList.get(2), ep1ProcessList.get(3));
		
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		
/*		Enter Process Details EP2	*/
		
		currencyPage.fillCurrenceyCode(ep2ProcessList.get(0));

		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+ep2ProcessList.get(1)+" - Postings Rebuild Parameters","Structure Rebuild page","displayed");
		
		currencyPage.enterEP2ProcessDetails(ep2ProcessList,companyId);
		
		currencyPage.enterAboutsubmitDetails();
		
		processVerification(currencyPage,ep2ProcessList.get(2), ep2ProcessList.get(3));

		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
	
		
		/*	Enter Process Details EP3	*/
		
		currencyPage.fillCurrenceyCode(ep3ProcessList.get(0));
		

		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+ep3ProcessList.get(1)+" - Structure Rebuild Parameters","Structure Rebuild page","displayed");

		currencyPage.enterEP3ProcessDetails(ep3ProcessList,companyId);
		
		currencyPage.enterAboutsubmitDetails(); 
		
		
		processVerification(currencyPage,ep3ProcessList.get(2), ep3ProcessList.get(3));	
		
		
		/*Enter Process Details EP4*/	
		
		currencyPage.fillCurrenceyCode(ep4ProcessList.get(0));
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+ep4ProcessList.get(1)+" - Company Parameter Edit The quic..","Structure Rebuild page","displayed");
		

		currencyPage.enterEP4ProcessDetails(ep4ProcessList,companyId);	
		
		currencyPage.enterAboutsubmitDetails();
		
		processVerification(currencyPage,ep4ProcessList.get(2), ep4ProcessList.get(3));
		
		
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		
		/*Enter Process Details EP5*/	
		
		currencyPage.fillCurrenceyCode(ep5ProcessList.get(0));
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+ep5ProcessList.get(1)+" - Postings Rebuild Parameters","Structure Rebuild page","displayed");
		
		currencyPage.enterEP5ProcessDetails(ep5ProcessList,companyId);	
		
		currencyPage.enterAboutsubmitDetails();
				
		processVerification(currencyPage,ep5ProcessList.get(2), ep5ProcessList.get(3));
		
		currencyPage.logOut(1);
	}

	public void processVerification(CurrencyPage currencyPage, String process, String Request) {
		boolean value = false;

		String statBefore = currencyPage.getProcessDetails(process, Request);

		Assert.assertEquals(testcases, statBefore, "2", "Process has", "entered task list");

		if (statBefore.equals("2")) {
			currencyPage.updateProcess(process, Request);
		}

		String statAfter = currencyPage.getProcessDetails(process, Request);

		if (statAfter == null || statAfter.equals("3")) {
			value = true;
		}

		Assert.assertTrue(testcases, value, "Precess " + process, "performed on " + Request);

		currencyPage.clickOnCancel();

		currencyPage.isConfirmPopUpDisplayed();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		super.tearDown();
	}

	@DataProvider
	public Object[][] dp() {
		String folder = "src/test/resources/";
		String xmlFilePath = folder + "E5H5.xml";
		String[] nodeID = { "A041" };
		String[] selectedNames = { "userName", "passWord", "ep1ProcessList", "ep2ProcessList", "ep3ProcessList",
				"ep4ProcessList", "ep5ProcessList", "ep1PathFun" };
		DataResource dataResourceSelected = new DataResource(xmlFilePath, selectedNames, true, nodeID);
		DataRow[][] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;
	}
}
