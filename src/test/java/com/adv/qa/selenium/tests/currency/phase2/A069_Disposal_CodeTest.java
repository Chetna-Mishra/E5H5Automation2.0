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
 * Test Reference No	: 	A069  Disposal Code
 * Purpose              :   Set Up Initial Batch Types
 * Date					:   19-06-2014/Modified on 25-Apr-2017 (Chetna)
 * ACCESS               :   PXE
 */

public class A069_Disposal_CodeTest extends BaseTest{
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
//		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> disposalCode = dataRow.findNamesReturnValues("disposalCode");
		String code = "EDTPDISP ACT=INSERT,COMPANY="+companyId;
			
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPage currencyPage = new CurrencyPage(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(currencyCode);
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Disposal Codes List","Currency search page","displayed");
		
		currencyPage.searchValue(companyId,disposalCode,2,1);
		
		currencyPage.clickOnInsert();
		
		/*Create batch type code*/
		
		String SuccMessage = "The previously-requested action has been performed";
		boolean update = currencyPage.enterDisposalCode(disposalCode);	
		
		if(update == true){
			currencyPage.clickOnUpdate();
			Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "New disposal code "+disposalCode.get(0), "created successfully");	
			
		}
		else
		{
		
			testcases.add(getCurreentDate()+" | Pass : New disposal code "+disposalCode.get(0)+ " already created");
			
		}
		
		currencyPage.clickOnCancel();
		
//		/*Verify new batch type in the list*/
//		Assert.assertTrue(testcases,currencyPage.verifyValues(disposalCode.get(0)), "New disposal code  "+disposalCode.get(0),"displayed in the list");
			
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
		String xmlFilePath = folder  + "E5H5.xml";
		String[] nodeID = { "A069" };
		String [] selectedNames = {"userName","passWord","currencyCode","disposalCode"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
