package com.adv.qa.selenium.tests.currency.phase3;

import java.util.List;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.adv.qa.selenium.framework.Assert;
import com.adv.qa.selenium.framework.BaseTest;
import com.adv.qa.selenium.framework.pageObjects.LoginPage;
import com.adv.qa.selenium.framework.pageObjects.currency.CurrencyPage;
import com.adv.qa.selenium.framework.pageObjects.currency.CurrencyPageNew;
import com.adv.qa.selenium.helpers.DataResource;
import com.adv.qa.selenium.helpers.DataRow;

/**
 * @author              :   Draxayani
 * Test Reference No	: 	A113 Security Access Codes  
 * Purpose              :   Access Codes 
 * Date					:   Modified on 17-May-2017/Chetna
 * ACCESS               :   ADJ
 */

public class A113_Security_Access_CodesTest extends BaseTest{
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
		List<String> securityAccess1 = dataRow.findNamesReturnValues("securityAccess1");
		List<String> securityAccess2 = dataRow.findNamesReturnValues("securityAccess2");
		List<String> securityAccess3 = dataRow.findNamesReturnValues("securityAccess3");
		List<String> securityAccess4 = dataRow.findNamesReturnValues("securityAccess4");

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
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Access Code List","Currency search page","displayed");
		
		currencyPage.searchsecurityrange(companyId,securityAccess1);

		currencyPage.clickOnInsert();
		
		currencyPage.insertAccessCode(securityAccess1);
		currencyPage.clickOnUpdate();
		
		currencyPage.insertAccessCode(securityAccess2);
		currencyPage.clickOnUpdate();
		
		currencyPage.insertAccessCode(securityAccess3);
		currencyPage.clickOnUpdate();
		
		currencyPage.insertAccessCode(securityAccess4);
		currencyPage.clickOnUpdate();
		
		
		currencyPage.clickOnCancel();
		
		verifyValues(currencyPage,securityAccess1);
		verifyValues(currencyPage,securityAccess2);
		verifyValues(currencyPage,securityAccess3);
		verifyValues(currencyPage,securityAccess4);
				
		currencyPage.logOut(2);
	}
	
	
private void verifyValues(CurrencyPageNew currencyPage,List<String> securityAccess){
		
		currencyPage.searchsecurityrange(companyId,securityAccess);
		
		if(currencyPage.verifyValues(securityAccess.get(0))){
			testcases.add(getCurreentDate()+" | Pass : New user company security "+securityAccess.get(0)+ " displayed in the list");
		}
		else{
			testcases.add(getCurreentDate()+" | Fail : New user company security "+securityAccess.get(0)+ " not displayed in the list");
		}
		
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
		String[] nodeID = { "A113" };
		String [] selectedNames = {"userName","passWord","currencyCode","securityAccess1","securityAccess2","securityAccess3","securityAccess4"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
