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
 * Test Reference No	: 	A081 Authorisation Groupings (PM)
 * Purpose              :   Create Authorisation Groupings for Purchasing Management
 * Date					:   24-06-2014/Modified on 27-Apr-2017 (Chetna)
 * ACCESS               :   DDC
 */

public class A081_Authorisation_Groupings_For_PMTest extends BaseTest{
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
		List<String> authorisationGroupOne = dataRow.findNamesReturnValues("authorisationGroupOne");
		List<String> authorisationGroupThree = dataRow.findNamesReturnValues("authorisationGroupThree");
		List<String> authorisationGroupFour = dataRow.findNamesReturnValues("authorisationGroupFour");
		List<String> authorisationGroupFive = dataRow.findNamesReturnValues("authorisationGroupFive");

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
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Authorisation Groupings List","Currency search page","displayed");
		
		currencyPage.searchValue(companyId, 6, 0);
		
		currencyPage.clickOnInsert();

		createAuthorisationGroup(currencyPage,authorisationGroupOne);
		createAuthorisationGroup(currencyPage,authorisationGroupThree);
		createAuthorisationGroup(currencyPage,authorisationGroupFour);
		createAuthorisationGroup(currencyPage,authorisationGroupFive);

		currencyPage.clickOnCancel();

		currencyPage.logOut(2);
	}

	
	private void createAuthorisationGroup(CurrencyPage currencyPage,List<String> authorisationControlCode) throws InterruptedException{
		String SuccMessage = "The previously-requested action has been performed";
		
		/*Create batch type code*/
		boolean update = currencyPage.enterAuthorisationGroupingsDetails(authorisationControlCode);	
		
		if(update == true){
			currencyPage.clickOnUpdate();
			
			Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "New authorisation group "+authorisationControlCode.get(0), "created successfully");
			
			
		}
		
		else{
			testcases.add(getCurreentDate()+" | Pass : New authorisation group "+authorisationControlCode.get(0)+ " present in the list");
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
		String xmlFilePath = folder  + "A081.xml";
		DataResource dataResource = new DataResource(xmlFilePath);
		DataRow [] [] rows = dataResource.getDataRows4DataProvider();
		return rows;
	}
}
