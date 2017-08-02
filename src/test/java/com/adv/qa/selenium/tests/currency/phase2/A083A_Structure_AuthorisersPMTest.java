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
 * Test Reference No	: 	A083 Structure Authorisers (PM)
 * Purpose              :   Create Structure Authorisers for Accounts Payable
 * Date					:   24-06-2014/Modified on 27-Apr-2017 (Chetna)
 * ACCESS               :   DBS
 */

public class A083A_Structure_AuthorisersPMTest extends BaseTest{
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
		List<String> values = dataRow.findNamesReturnValues("values");
		List<String> pmStructureForUser = dataRow.findNamesReturnValues("pmStructureForUser");
		List<String> pmStructureForManager = dataRow.findNamesReturnValues("pmStructureForManager");
		List<String> pmStructureForAdmin = dataRow.findNamesReturnValues("pmStructureForAdmin");
		List<String> pmStructureForQuery = dataRow.findNamesReturnValues("pmStructureForQuery");
		List<String> pmStructureForEmployee = dataRow.findNamesReturnValues("pmStructureForEmployee");		
		

		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPage currencyPage = new CurrencyPage(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(currencyCode);
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Structure Authorisor List","Currency search page","displayed");
		
		currencyPage.searchValue(companyId,values, 4, 1);
		
		currencyPage.clickOnInsert();
		
		createStructureAuthorisers(currencyPage,pmStructureForUser);
		createStructureAuthorisers(currencyPage,pmStructureForManager);
		createStructureAuthorisers(currencyPage,pmStructureForAdmin);
		createStructureAuthorisers(currencyPage,pmStructureForQuery);
		createStructureAuthorisers(currencyPage,pmStructureForEmployee);

		currencyPage.clickOnCancel();
		
//		verifyValues(currencyPage,pmStructureForUser);
//		verifyValues(currencyPage,pmStructureForManager);
//		verifyValues(currencyPage,pmStructureForAdmin);
//		verifyValues(currencyPage,pmStructureForQuery);
//		verifyValues(currencyPage,pmStructureForEmployee);
		
		currencyPage.logOut(2);
	}

	
	private void createStructureAuthorisers(CurrencyPage currencyPage,List<String> structureAuthorisers) throws InterruptedException{
		
		String SuccMessage = "The previously-requested action has been performed";
		
		boolean update=currencyPage.enterStructureAuthorisorForPM(structureAuthorisers);

		if(update==true)
		{
		
		currencyPage.clickOnUpdate();
		Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "New structure authorizers "+structureAuthorisers.get(1), "created successfully");
		
		}
		else{
			testcases.add(getCurreentDate()+" | Pass : New structure authorizers "+structureAuthorisers.get(1)+ " already created");
		
		}
	}


//	private void verifyValues(CurrencyPage currencyPage,List<String> structureAuthorisers){
//		
//		/*Verify new structure authorizers displayed in the list*/
//		if(currencyPage.verifyValues(structureAuthorisers.get(1))){
//			testcases.add(getCurreentDate()+" | Pass : New structure authorizers "+structureAuthorisers.get(1)+ " displayed in the list");
//		}
//		else{
//			testcases.add(getCurreentDate()+" | Fail : New structure authorizers "+structureAuthorisers.get(1)+ " not displayed in the list");
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
		String xmlFilePath = folder  + "A083A.xml";
		DataResource dataResource = new DataResource(xmlFilePath);
		DataRow [] [] rows = dataResource.getDataRows4DataProvider();
		return rows;
	}
}
