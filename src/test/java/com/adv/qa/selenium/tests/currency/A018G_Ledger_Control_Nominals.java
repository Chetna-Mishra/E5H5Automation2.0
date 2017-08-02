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
 * Test Reference No	: 	A018 Ledger Control Nominals
 * Purpose              :   Set Up Ledger Control Nominals
 * Date					:   22-04-2014
 * ACCESS               :   EBA
 */

public class A018G_Ledger_Control_Nominals extends BaseTest{
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

		List<String> nominal5100 = dataRow.findNamesReturnValues("nominal5100");
		List<String> nominal6200 = dataRow.findNamesReturnValues("nominal6200");
		List<String> nominalSONY = dataRow.findNamesReturnValues("nominalSONY");
		List<String> nominalPION = dataRow.findNamesReturnValues("nominalPION");
		List<String> nominalTOSH = dataRow.findNamesReturnValues("nominalTOSH");
		List<String> nominalPANN = dataRow.findNamesReturnValues("nominalPANN");
		List<String> nominalWHAF = dataRow.findNamesReturnValues("nominalWHAF");
		List<String> nominalSHIN = dataRow.findNamesReturnValues("nominalSHIN");
		List<String> nominalGRUN = dataRow.findNamesReturnValues("nominalGRUN");
		List<String> nominalSAMS = dataRow.findNamesReturnValues("nominalSAMS");
		List<String> nominalHITC = dataRow.findNamesReturnValues("nominalHITC");
		List<String> nominalAIWA = dataRow.findNamesReturnValues("nominalAIWA");
		List<String> nominalAKAI = dataRow.findNamesReturnValues("nominalAKAI");

		
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
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Nominal List","Currency search page","displayed");

		currencyPage.searchValue(companyId,2,0);
		
		currencyPage.clickOnInsert();

		
		createNominal(nominal5100,dataRow,currencyPage);
		createNominal(nominal6200,dataRow,currencyPage);
		createNominal(nominalSONY,dataRow,currencyPage);
		createNominal(nominalPION,dataRow,currencyPage);
		createNominal(nominalTOSH,dataRow,currencyPage);
		createNominal(nominalPANN,dataRow,currencyPage);
		createNominal(nominalWHAF,dataRow,currencyPage);
		createNominal(nominalSHIN,dataRow,currencyPage);
		createNominal(nominalGRUN,dataRow,currencyPage);
		createNominal(nominalSAMS,dataRow,currencyPage);
		createNominal(nominalHITC,dataRow,currencyPage);
		createNominal(nominalAIWA,dataRow,currencyPage);
		createNominal(nominalAKAI,dataRow, currencyPage);
		/*Exit from the company details page*/
		currencyPage.clickOnCancel();
		
		currencyPage.isConfirmPopUpDisplayed();
		
		currencyPage.logOut(2);

}
	
private void createNominal(List<String> nominal,DataRow dataRow,CurrencyPage currencyPage) throws InterruptedException
	
	{
		String SuccMessage = "The previously-requested action has been performed";
		
		/*Create new nominal control*/
		boolean update = currencyPage.enterNominalControl(nominal);
		
			if(update == true){
				
				currencyPage.clickOnUpdate();
		
				Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "New ledger control "+nominal.get(0), "created successfully");
		}
		else{
			testcases.add(getCurreentDate()+" | Pass : New ledger control "+nominal.get(0)+ " already created");
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
		String xmlFilePath = folder  + "A018G.xml";
		DataResource dataResource = new DataResource(xmlFilePath);
		DataRow [] [] rows = dataResource.getDataRows4DataProvider();
		return rows;
	}
}
