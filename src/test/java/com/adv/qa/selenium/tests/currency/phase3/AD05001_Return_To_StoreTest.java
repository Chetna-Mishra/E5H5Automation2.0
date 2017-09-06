package com.adv.qa.selenium.tests.currency.phase3;

import java.util.List;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.adv.qa.selenium.framework.Assert;
import com.adv.qa.selenium.framework.BaseTest;
import com.adv.qa.selenium.framework.pageObjects.LoginPage;
import com.adv.qa.selenium.framework.pageObjects.currency.CurrencyPageNew;
import com.adv.qa.selenium.helpers.DataResource;
import com.adv.qa.selenium.helpers.DataRow;

/**
 * @author              :   Draxayani
 * Test Reference No	: 	AD05001 Return to Store
 * Purpose              :   Return stock to store using the Fetch facility 
 * Modified Date		:   Modified by Chetna/Dt: 30-Aug-2017
 * ACCESS               :   HCK,HBA,EDA
 */

public class AD05001_Return_To_StoreTest extends BaseTest{
	
	private static String glRefNumber;
	
	
	public static String getGlRefNumber() {
		return glRefNumber;
	}


	private static void setGlRefNumber(String glRefNumber) {
		AD05001_Return_To_StoreTest.glRefNumber = glRefNumber;
	}
	
	
	/*Launch the browser*/
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}
	
	@Test( dataProvider ="dp")
	public void verify(DataRow dataRow) throws InterruptedException{
		String userName = dataRow.get("userName");
		String passWord = dataRow.get("passWord");	
		List<String> stockBalance = dataRow.findNamesReturnValues("stockBalance");		
		List<String> materialIssue = dataRow.findNamesReturnValues("materialIssue");
		List<String> stockBalanceMI = dataRow.findNamesReturnValues("stockBalanceMI");
		List<String> currentStockBalance = dataRow.findNamesReturnValues("currentStockBalance");
		List<String> currencyStockMI = dataRow.findNamesReturnValues("currencyStockMI");
		List<String> stockBalanceRS = dataRow.findNamesReturnValues("stockBalanceRS");
		List<String> currentStockBalanceRS = dataRow.findNamesReturnValues("currentStockBalanceRS");	
		List<String> returnStoreStock = dataRow.findNamesReturnValues("returnStoreStock");
		
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPageNew currencyPage = new CurrencyPageNew(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		verifyStockBalance(currencyPage,dataRow,stockBalance,currentStockBalance,1);
		
		createMaterialIssue(currencyPage,dataRow,materialIssue,0);			
			
		setGlRefNumber(glRefNumber);
		
//		String glRefNumber="000009";//Remove after use
		
		verifyStockBalance(currencyPage,dataRow,stockBalanceMI,currencyStockMI,1);
		
		reviewBatches(currencyPage, dataRow,1,"IMMI");
		
		currencyPage.clickOnCancel();
		
		RetrieveMaterialIssue(currencyPage,dataRow,returnStoreStock,1,glRefNumber);
		
	
		verifyStockBalance(currencyPage,dataRow,stockBalanceRS,currentStockBalanceRS,1);
		
		reviewBatches(currencyPage, dataRow,1,"IMRS");			
		
		currencyPage.logOut(2);
		
	}
	
	public String createMaterialIssue(CurrencyPageNew currencyPage,DataRow dataRow,List<String> elements,int i) throws InterruptedException{
		String code = "EDTHMVMT ACT=INSERT,CMPY="+companyId+",STORE=EAST,MVMT-IND=M";
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");	
		
		String message = "Movement Reference";
		
		currencyPage.fillCurrenceyCode(code);
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(1)+" - Material Issue Line Details Edit","Currency search page","displayed");
		
		if(i==1){
			List<String> storeDetails = dataRow.findNamesReturnValues("storeDetails");
			
			currencyPage.addStoreDetails(storeDetails);
		}
		
		currencyPage.addLineDetails(elements,"M");
		
		currencyPage.clickOnAcceptWarnings();
		
		currencyPage.clickOnUpdate();
		
		String referenceMessage = currencyPage.getErrorContentText();//Movement Reference 000009 will be created
	
		/*Verify new batch type in the list*/
		
		Assert.assertTrue(testcases,referenceMessage.contains(message), " "+referenceMessage," successfully");
		
		String glRefNumber = referenceMessage.substring(0, referenceMessage.indexOf(" will be created"));
		
		glRefNumber = glRefNumber.replace("Movement Reference ", "");
	
		currencyPage.isCommandDisplayed();
		
		return glRefNumber;
		
	}
	
/*
 * Create Material Issue for Retrieve Doc Reference=000009, from above material issue
 * 
 */	
	
	public String RetrieveMaterialIssue(CurrencyPageNew currencyPage,DataRow dataRow,List<String> elements,int i, String glRefNumber) throws InterruptedException{
		
		String code = "EDTHMVMT ACT=INSERT,MVMT-IND=S";
		
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");	
		
		String message = "Movement Reference";
		
		currencyPage.fillCurrenceyCode(code);
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(1)+" - Return to Store Line Details Edit","Currency search page","displayed");
		
		if(i==1){
			List<String> storeDetails = dataRow.findNamesReturnValues("storeDetails");
			
			currencyPage.addStoreDetails(storeDetails);
		}
		
		currencyPage.clickOnFetch_retrieve();
		
		currencyPage.enterFetchDetails(elements,glRefNumber);
		
		currencyPage.clickOnAcceptWarnings();
		
		currencyPage.clickOnUpdate();
		
		String referenceMessage = currencyPage.getErrorContentText();//Movement Reference 000009 will be created
	
		/*Verify new batch type in the list*/
		Assert.assertTrue(testcases,referenceMessage.contains(message), " "+referenceMessage," successfully");
		
		String glRefNumber1 = referenceMessage.substring(0, referenceMessage.indexOf(" will be created"));
		
		glRefNumber = glRefNumber1.replace("Movement Reference ", "");
	
		currencyPage.isCommandDisplayed();
		
		return glRefNumber;
		
	}	
	
	
	private void verifyStockBalance(CurrencyPageNew currencyPage,DataRow dataRow,List<String> elements,List<String> stockBalance,int i) throws InterruptedException{
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
			
		currencyPage.isCommandDisplayed();
		
		currencyPage.fillCurrenceyCode(currencyCode.get(0));
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(0)+" - Item Store Stock Value","Currency search page","displayed");
		
		currencyPage.searchItemStore(companyId,elements);
		
		boolean totalStockBalance = currencyPage.verifyTotalStockBalance(elements);
		
		Assert.assertTrue(testcases,totalStockBalance,"Total stock balance "," as expected");
			
		boolean storeItemValues = currencyPage.verifyStoreItemValues(elements,0);
		
		Assert.assertTrue(testcases,storeItemValues,"Store item values "," as expected");
		
		if(i==1){
			currencyPage.clickOnCurrentStock();
			
			boolean currentStock = currencyPage.verifyCurrenctStock(stockBalance,0);
			
			Assert.assertTrue(testcases,currentStock,"Currenct stock is "," as expected");				
			
			currencyPage.clickOnCancel();
		}
		
		currencyPage.clickOnCancel();
		
	}
	

	private void reviewBatches(CurrencyPageNew currencyPage,DataRow dataRow,int i,String batch) throws InterruptedException{
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> issuBatchDetails = dataRow.findNamesReturnValues("issuBatchDetails"+i);
		List<String> stkeBatchDetails = dataRow.findNamesReturnValues("stkeBatchDetails"+i);		
		
							
		currencyPage.fillCurrenceyCode(currencyCode.get(2));
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(2)+" - Journal List","Journey search page","displayed");
		
		currencyPage.searchValue(companyId, 4, 0);
		
		currencyPage.clickOnEXTSections();
		
		currencyPage.searchValue(batch, 16, 5);
		
		currencyPage.sortValues();
		
		currencyPage.clickOnView();
		
		Assert.assertTrue(testcases,currencyPage.getTableHeader().contains("Journal Header"),"Journal header page","displayed");

		currencyPage.clickOnLines();
		
		boolean verifyStkeBatch = currencyPage.verifyJournalDetails(1, stkeBatchDetails);
		Assert.assertTrue(testcases,verifyStkeBatch,"STKE batch values are "," correct");
		
		boolean verifyIssuBatch = currencyPage.verifyJournalDetails(2, issuBatchDetails);
		Assert.assertTrue(testcases,verifyIssuBatch,"ISSU batch values are "," correct");		
	
		if(i==2){
			List<String> rstrBatchDetails = dataRow.findNamesReturnValues("rstrBatchDetails"+i);
			
			boolean verifyRstrBatch = currencyPage.verifyJournalDetails(2, rstrBatchDetails);
			Assert.assertTrue(testcases,verifyRstrBatch,"RSTR batch values are "," correct");//Need Test
		}
		
		currencyPage.clickOnCancel();		
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
		String[] nodeID = { "AD05001" };
		String [] selectedNames = {"userName","passWord","currencyCode","stockBalance","currentStockBalance","materialIssue","stockBalanceMI","currencyStockMI","stkeBatchDetails","issuBatchDetails"
				,"storeDetails","returnStoreStock","stockBalanceRS","currentStockBalanceRS","stkeBatchDetails1","rstrBatchDetails2","issuBatchDetails1","stkeBatchDetails2","issuBatchDetails2"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
