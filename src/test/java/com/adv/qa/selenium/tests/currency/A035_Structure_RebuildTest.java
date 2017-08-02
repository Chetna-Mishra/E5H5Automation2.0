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
 * @author              :   Draxayani
 * Test Reference No	: 	A035 Structure Rebuild (EP3)
 * Purpose              :   Run Structure Rebuild
 * Date					:   02-05-2014
 * ACCESS               :   Submit EP3
 */

public class A035_Structure_RebuildTest extends BaseTest{
	/*Launch the browser*/
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}
	
	@Test( dataProvider ="dp")
	public void verify(DataRow dataRow) throws InterruptedException{
		String userName = dataRow.get("userName");
		String passWord = dataRow.get("passWord");
				
		List<String> ep3ProcessList = dataRow.findNamesReturnValues("ep3ProcessList");
		
		
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPage currencyPage = new CurrencyPage(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		/*Enter Process Details EP3*/
		
		currencyPage.fillCurrenceyCode(ep3ProcessList.get(0));
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+ep3ProcessList.get(1)+" - Structure Rebuild Parameters","Structure Rebuild page","displayed");

		currencyPage.enterEP3ProcessDetails(ep3ProcessList,companyId);
		
		currencyPage.enterAboutsubmitDetails(); 
		
		
		processVerification(currencyPage,ep3ProcessList.get(2), ep3ProcessList.get(3));

		currencyPage.logOut(1);
	}
	
	
	public void processVerification(CurrencyPage currencyPage,String process,String Request){
		boolean value = false;
		
		String statBefore = currencyPage.getProcessDetails(process, Request);
		
		Assert.assertEquals(testcases,statBefore, "2","Process has","entered task list");
		
		if(statBefore.equals("2")){
			currencyPage.updateProcess(process, Request);
		}
		
		String statAfter = currencyPage.getProcessDetails(process, Request);
		

		if (statAfter == null || statAfter.equals("3")) {
			value = true;
		}
		
		Assert.assertTrue(testcases,value,"Process "+process,"performed on "+Request);
		
		currencyPage.clickOnCancel();
		
		currencyPage.isConfirmPopUpDisplayed();
		
	}
	
	

	
	@AfterClass (alwaysRun = true)
	public void tearDown(){
		super.tearDown();
	}
	
	@DataProvider
	public Object[][] dp() 
	{		
		String folder = "src/test/resources/";
		String xmlFilePath = folder  + "E5H5.xml";
		String[] nodeID = { "A035" };
		String [] selectedNames = {"userName","passWord","code","ep3ProcessList","process"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true, nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
