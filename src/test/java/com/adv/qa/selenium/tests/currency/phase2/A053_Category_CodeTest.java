package com.adv.qa.selenium.tests.currency.phase2;

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
 * Test Reference No	: 	A053 Category Code
 * Purpose              :   Set Up Initial Batch Types
 * Date					:   19-05-2014
 * ACCESS               :   PAD
 */

public class A053_Category_CodeTest extends BaseTest{
	/*Launch the browser*/
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}
	
	@Test( dataProvider ="dp")
	public void verify(DataRow dataRow) throws InterruptedException{
		String userName = dataRow.get("userName");
		String passWord = dataRow.get("passWord");
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		String code = "EDTPCATEG ACT=INSERT,COMPANY="+companyId;
		List<String> category = dataRow.findNamesReturnValues("category");		
		
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPage currencyPage = new CurrencyPage(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(code);
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(0)+" - Supplier Category Edit","Currency search page","displayed");
		
		/*Create batch type code*/
		String SuccMessage = "The previously-requested action has been performed";
		boolean update= currencyPage.enterCategoryCodeDetails(category);	
		
		if (update==true)
		
		{
			currencyPage.clickOnUpdate();
			Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "New category code "+category.get(0), "created successfully");
		}
		
		else
		{
		
			testcases.add(getCurreentDate()+" | Pass : New category code  "+category.get(0)+ " already created");
			
			currencyPage.clickOnCancel();
			
		}
	
		currencyPage.logOut(2);

	}
		
//		
//		currencyPage.fillCurrenceyCode(currencyCode.get(1));
//		
//		/*Verify currency search page displayed*/
//		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(1)+" - Supplier Category - List","Currency search page","displayed");
//
//		currencyPage.searchValue(companyId,category,2,1);
//		
//		Assert.assertTrue(testcases,currencyPage.verifyValues(category.get(0)), "New category code "+category.get(0),"displayed in the list");
	

	
	
	@AfterClass (alwaysRun = true)
	public void tearDown(){
		super.tearDown();
	}
	
	@DataProvider
	public Object[][] dp() 
	{		
		String folder = "src/test/resources/";
		String xmlFilePath = folder  + "E5H5.xml";
		String[] nodeID = { "A053" };
		String [] selectedNames = {"userName","passWord","code","currencyCode","category"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
