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
 * Test Reference No	: 	A078  Authorisation Control Codes (AP)
 * Purpose              :   Create Authorisation Control Codes for Accounts Payable
 * Date					:   24-06-2014/Modified on 27-Apr-2017 (Chetna)
 * ACCESS               :   GOA
 */

public class A078A_Authorisation_Control_Codes_For_APTest extends BaseTest{
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
		List<String> authorisationCodeL3 = dataRow.findNamesReturnValues("authorisationCodeL3");
		List<String> authorisationCodeL4 = dataRow.findNamesReturnValues("authorisationCodeL4");
		List<String> authorisationCodeL5 = dataRow.findNamesReturnValues("authorisationCodeL5");
					
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
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Authorisation Controls List","Currency search page","displayed");

		currencyPage.searchValue(companyId, 2, 0);
		
		currencyPage.clickOnInsert();
		
		createAuthorisationCode(currencyPage,authorisationCodeL3);
		createAuthorisationCode(currencyPage,authorisationCodeL4);
		createAuthorisationCode(currencyPage,authorisationCodeL5);
		
		currencyPage.clickOnCancel();
		
//		verifyValues(currencyPage,authorisationCodeL3);
//		verifyValues(currencyPage,authorisationCodeL4);
//		verifyValues(currencyPage,authorisationCodeL5);

		currencyPage.logOut(2);
	}

	
private void createAuthorisationCode(CurrencyPage currencyPage,List<String> authorisationControlCode) throws InterruptedException{
		
		String SuccMessage = "The previously-requested action has been performed";
		
		/*Create authorization control code*/
		boolean update = currencyPage.enterAuthorisationControlDetails(authorisationControlCode);			
		
		if(update == true){
			
			currencyPage.clickOnUpdate();
			
			Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "New authorisation controls code  "+authorisationControlCode.get(0), "created successfully");
			
		}
		else{
			testcases.add(getCurreentDate()+" | Pass : New authorisation controls code "+authorisationControlCode.get(0)+ " already created");
		}
	}

	
//	private void verifyValues(CurrencyPage currencyPage,List<String> authorisationControlCode){
//		
//		/*Verify new authorisation code type in the list*/
//		if(currencyPage.verifyValues(authorisationControlCode.get(0))){
//			testcases.add(getCurreentDate()+" | Pass : New authorisation controls code "+authorisationControlCode.get(0)+ " displayed in the list");
//		}
//		else{
//			testcases.add(getCurreentDate()+" | Fail : New authorisation controls code "+authorisationControlCode.get(0)+ " not displayed in the list");
//		}
//	}


	
	@AfterClass (alwaysRun = true)
	public void tearDown(){
		super.tearDown();
	}
	
	@DataProvider
	public Object[][] dp() 
	{
		String folder = "src/test/resources/";
		String xmlFilePath = folder  + "A078A.xml";
		DataResource dataResource = new DataResource(xmlFilePath);
		DataRow [] [] rows = dataResource.getDataRows4DataProvider();
		return rows;
	}
}
