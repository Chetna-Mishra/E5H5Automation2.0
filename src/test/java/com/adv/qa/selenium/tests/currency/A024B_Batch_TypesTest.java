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
 * Test Reference No	:   A024 Batch Types
 * Purpose              :   Set Up Additional Batch Types
 * Date					:   05-05-2014
 * ACCESS               :   AKK
 */


public class A024B_Batch_TypesTest extends BaseTest{

	/*Launch the browser*/
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}
	
	@Test( dataProvider ="dp")
	public void verify(DataRow dataRow) throws InterruptedException{	
		String userName = dataRow.get("userName");
		String passWord = dataRow.get("passWord");
		String batchCode = dataRow.get("batchCode");

		List<String> imBatchTypeForIMAD = dataRow.findNamesReturnValues("imBatchTypeForIMAD");
		List<String> imBatchTypeForIMAO = dataRow.findNamesReturnValues("imBatchTypeForIMAO");
		List<String> imBatchTypeForIMVA = dataRow.findNamesReturnValues("imBatchTypeForIMVA");
		
		List<String> imBatchTypeForIMDI = dataRow.findNamesReturnValues("imBatchTypeForIMDI");
		List<String> imBatchTypeForIMTR = dataRow.findNamesReturnValues("imBatchTypeForIMTR");
		List<String> imBatchTypeForIMRS = dataRow.findNamesReturnValues("imBatchTypeForIMRS");
		
		List<String> imBatchTypeForIMRU = dataRow.findNamesReturnValues("imBatchTypeForIMRU");
		List<String> imBatchTypeForIMRC = dataRow.findNamesReturnValues("imBatchTypeForIMRC");
		List<String> imBatchTypeForIMSC = dataRow.findNamesReturnValues("imBatchTypeForIMSC");
		
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPage currencyPage = new CurrencyPage(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		/*Search currency code*/
		currencyPage.fillCurrenceyCode(batchCode);
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+batchCode+" - Batch Type List","Currency search page","displayed");

		currencyPage.searchValue(companyId,2,0);
		
		/*Insert new batch type details*/
		currencyPage.clickOnInsert();
		
		createBatchType(currencyPage,imBatchTypeForIMAD);
		createBatchType(currencyPage,imBatchTypeForIMAO);
		createBatchType(currencyPage,imBatchTypeForIMVA);
		createBatchType(currencyPage,imBatchTypeForIMDI);
		createBatchType(currencyPage,imBatchTypeForIMTR);
		createBatchType(currencyPage,imBatchTypeForIMRS);
		createBatchType(currencyPage,imBatchTypeForIMRU);
		createBatchType(currencyPage,imBatchTypeForIMRC);
		createBatchType(currencyPage,imBatchTypeForIMSC);
		
		/*Exit from the batch details page*/
		currencyPage.clickOnCancel();
		
		currencyPage.isConfirmPopUpDisplayed();
		
		currencyPage.logOut(2);
	}

	
	private void createBatchType(CurrencyPage currencyPage,List<String> batchType) throws InterruptedException{
		String SuccMessage = "The previously-requested action has been performed";

		/*Create new Batch type*/
		boolean update = currencyPage.enterLedgerBatchTypeDetails(batchType);
		
		if(update == true){
			currencyPage.clickOnUpdate();
			
			Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "New batch type "+batchType.get(0), "created successfully");
			
		}
		
	
	else{
		
		testcases.add(getCurreentDate()+" | Pass : New batch type "+batchType.get(0)+" already created");
	}
}
			
//			/*Verify new batch type in the Batch list*/
//			if(currencyPage.getToolContentText().contains(message)){
//				testcases.add(getCurreentDate()+" | Pass : New batch type  "+batchType.get(0)+ " displayed in the list");
//			}
//			else{
//				testcases.add(getCurreentDate()+" | Fail : New batch type  "+batchType.get(0)+ " not displayed in the list");
//			}	
//		}
//		else{
//			testcases.add(getCurreentDate()+" | Pass : New batch type  "+batchType.get(0)+ " displayed in the list");
//		}
	
	@AfterClass (alwaysRun = true)
	public void tearDown(){
		super.tearDown();
	}
	
	@DataProvider
	public Object[][] dp() 
	{
		String folder = "src/test/resources/";
		String xmlFilePath = folder  + "A024B.xml";
		DataResource dataResource = new DataResource(xmlFilePath);
		DataRow [] [] rows = dataResource.getDataRows4DataProvider();
		return rows;
	}
}
