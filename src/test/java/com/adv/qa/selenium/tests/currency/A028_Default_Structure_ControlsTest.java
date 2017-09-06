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
 * Test Reference No	: 	A028 Default Structure Controls
 * Purpose              :   Set Up Default Structure Controls
 * Date					:   24-04-2014
 * ACCESS               :   ECC
 */

public class A028_Default_Structure_ControlsTest extends BaseTest {
	/*Launch the browser*/
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}
	
	@Test( dataProvider ="dp")
	public void verify(DataRow dataRow) throws InterruptedException{
		String userName = dataRow.get("userName");
		String passWord = dataRow.get("passWord");
		String currencyCode = dataRow.get("code");
		List<String> controlList = dataRow.findNamesReturnValues("controlList");
		
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPage currencyPage = new CurrencyPage(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");//Failed
		
		currencyPage.fillCurrenceyCode(currencyCode);
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Controls List","Currency search page","displayed");
	
		currencyPage.searchValue(companyId,controlList,2,6);
		
		if(!currencyPage.verifyValues(controlList.get(1)))
			
		{
			
		currencyPage.clickOnInsert1();

		
		/*Create structure control*/
		currencyPage.enterControlDetails(controlList);
		
		currencyPage.clickOnUpdate();
		currencyPage.clickOnUpdtWarnings();
		
		/*Exit from the structure control edit page*/
		currencyPage.clickOnCancel();
		
		currencyPage.isConfirmPopUpDisplayed();

		/*Verify new structure control displayed in the list*/
		Assert.assertTrue(testcases,currencyPage.verifyValues(controlList.get(1)), "Default control structure "+controlList.get(1)," displayed in the list");
		}
		
		currencyPage.clickOnCancel1();
		currencyPage.logOut(1);
	}


	@DataProvider
	public Object[][] dp() 
	{		
		String folder = "src/test/resources/";
		String xmlFilePath = folder  + "E5H5.xml";
		String[] nodeID = { "A028" };
		String [] selectedNames = {"userName","passWord","code","controlList"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames,true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
		
	@AfterClass (alwaysRun = true)
	public void tearDown(){
		super.tearDown();
	}
}
