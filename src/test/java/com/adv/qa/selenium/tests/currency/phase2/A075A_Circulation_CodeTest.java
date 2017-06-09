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
import com.adv.qa.selenium.framework.pageObjects.currency.CurrencyPageNew;
import com.adv.qa.selenium.helpers.DataResource;
import com.adv.qa.selenium.helpers.DataRow;

/**
 * @author              :   Draxayani
 * Test Reference No	: 	A075 Circulation Code
 * Purpose              :   Set Up Circulation Code.
 * Date					:   24-06-2014/Modified on 26-Apr-2017 (Chetna)
 * ACCESS               :   PX8
 */

public class A075A_Circulation_CodeTest extends BaseTest{
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
		List<String> circulationO1 = dataRow.findNamesReturnValues("circulationO1");
		List<String> circulationRQ = dataRow.findNamesReturnValues("circulationRQ");
		List<String> circulationA1 = dataRow.findNamesReturnValues("circulationA1");
		List<String> circulationB1 = dataRow.findNamesReturnValues("circulationB1");
		List<String> circulationD1 = dataRow.findNamesReturnValues("circulationD1");
							
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
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Circulation Code List","Currency search page","displayed");
		
		currencyPage.searchValue(companyId, 2, 0);
		
		currencyPage.clickOnInsert();
		
		createCirculationCode(companyId,currencyPage,circulationO1);
		createCirculationCode(companyId,currencyPage,circulationRQ);
		createCirculationCode(companyId,currencyPage,circulationA1);
		createCirculationCode(companyId,currencyPage,circulationB1);
		createCirculationCode(companyId,currencyPage,circulationD1);
		

		currencyPage.clickOnCancel();
		
		currencyPage.searchValue(companyId, 2, 0);
		
		verifyValues(currencyPage,circulationO1);
		verifyValues(currencyPage,circulationRQ);
		verifyValues(currencyPage,circulationA1);
		verifyValues(currencyPage,circulationB1);
		verifyValues(currencyPage,circulationD1);
		
		
		currencyPage.logOut(2);
	}
	
	private void createCirculationCode(String companyId, CurrencyPage currencyPage,List<String> circulationCode) throws InterruptedException{
//		String message = "The previously-requested action has been performed";
		/*Create batch type code*/
		boolean update = currencyPage.enterCirculationCode(companyId,circulationCode);
		
		if(update == true){
			
			currencyPage.clickOnUpdate();
		}

		else{
			testcases.add(getCurreentDate()+" | Pass : New circulation code "+circulationCode.get(0)+ " displayed in the list");
		}
	}
	
	
	
//	/*Verify new circulation code type in the list*/
	private void verifyValues(CurrencyPage currencyPage,List<String> circulationCode){
		
	
		if(currencyPage.verifyValues(circulationCode.get(0))){
		
			testcases.add(getCurreentDate()+" | Pass : New circulation code "+circulationCode.get(0)+ " displayed in the list");
		}
		
	else{
		testcases.add(getCurreentDate()+" | Fail : New circulation code "+circulationCode.get(0)+ " not displayed in the list");
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
		String xmlFilePath = folder  + "A075A.xml";
		DataResource dataResource = new DataResource(xmlFilePath);
		DataRow [] [] rows = dataResource.getDataRows4DataProvider();
		return rows;
	}
}
