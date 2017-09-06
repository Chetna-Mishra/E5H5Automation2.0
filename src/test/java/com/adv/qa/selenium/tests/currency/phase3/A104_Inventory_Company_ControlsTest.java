package com.adv.qa.selenium.tests.currency.phase3;

import java.util.List;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.adv.qa.selenium.framework.Assert;
import com.adv.qa.selenium.framework.BaseTest;
import com.adv.qa.selenium.framework.pageObjects.LoginPage;
import com.adv.qa.selenium.framework.pageObjects.currency.CurrencyPageNew;
import com.adv.qa.selenium.helpers.DataResource;
import com.adv.qa.selenium.helpers.DataRow;

/**
 * @author              :   Draxayani
 * Test Reference No	: 	A104 Inventory Company Controls
 * Purpose              :   Inventory Company Controls 
 * Date					:   Modified on 11-May-2017  
 * ACCESS               :   HAA
 */

public class A104_Inventory_Company_ControlsTest extends BaseTest{
	/*Launch the browser*/
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}
	
	@Test( dataProvider ="dp")
	public void verify(DataRow dataRow) throws InterruptedException{
		String userName = dataRow.get("userName");
		String passWord = dataRow.get("passWord");
		String currencyCode = dataRow.get("currencyCode");
		List<String> inventoryControl = dataRow.findNamesReturnValues("inventoryControl");		
		
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPageNew currencyPage = new CurrencyPageNew(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(currencyCode);
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - IM Company Controls List","Currency search page","displayed");
		
		currencyPage.searchValue(companyId, 1, 0);
		
		currencyPage.clickOnInsert();
		
		boolean update=currencyPage.insertIMCompanyControl(companyId,inventoryControl);
		String SuccMessage = "The previously-requested action has been performed";
		
		if(update==true)
			{
			currencyPage.clickOnUpdtWarnings();
			currencyPage.clickOnUpdate();
			
			Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "New inventory company "+companyId, " created successfully");

			}
		
		else
			{
				
				testcases.add(getCurreentDate()+" | Pass : New inventory company "+companyId+ " already created");
			}
			
		 
		 currencyPage.clickOnCancel();
		 currencyPage.isConfirmPopUpDisplayed();
		 
//		if(!currencyPage.verifyValues(companyId)){
//			testcases.add(getCurreentDate()+" | Pass : New inventory company "+companyId+ "  displayed in the list");
//		}
//		else{
//			testcases.add(getCurreentDate()+" | Fail : New inventory company "+companyId+ "  not displayed in the list");
//		}

		 
		currencyPage.logOut(2);
	}
	
	@AfterClass (alwaysRun = true)
	public void tearDown(){
		super.tearDown();
	}
	
	@DataProvider
	public Object[][] dp() 
	{		
		String folder = "src/test/resources/";
		String xmlFilePath = folder  + "phase3.xml";
		String[] nodeID = { "A104" };
		String [] selectedNames = {"userName","passWord","currencyCode","inventoryControl"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
