package com.adv.qa.selenium.tests.currency.phase3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
import com.adv.qa.selenium.helpers.WaitHelper;

/**
 * @author              :   Draxayani
 * Test Reference No	: 	AD02001 Normal Material Issue
 * Purpose              :   Create Stock Adjustment In 
* Date					:   Modified on 05-June-2017/Chetna  
 * ACCESS               :   HBA
 */

public class AD02001_Normal_Material_IssueTest extends BaseTest{
	/*Launch the browser*/
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}
	
	@Test( dataProvider ="dp")
	public void verify(DataRow dataRow) throws InterruptedException{
		String userName = dataRow.get("userName");
		String passWord = dataRow.get("passWord");
		
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPageNew currencyPage = new CurrencyPageNew(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		amendInventoryStoreControl(currencyPage,dataRow);
				
		createStockAdjustment(currencyPage,dataRow);
		
		verifyStockBalance(currencyPage,dataRow);
		
		currencyPage.clickOnCancel();
		
		currencyPage.isCommandDisplayed();
		
		createMaterialIssue(currencyPage,dataRow);
		
		reviewBatches(currencyPage, dataRow);
		
		currencyPage.clickOnCancel();
		
		currencyPage.isCommandDisplayed();
		
		verifyTotalStockBalance(currencyPage,dataRow);
				
		currencyPage.logOut(2);
	}
	
	
	private void amendInventoryStoreControl(CurrencyPageNew currencyPage,DataRow dataRow) throws InterruptedException{
		
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> eastStoreElements = dataRow.findNamesReturnValues("eastStoreElements");
		
		currencyPage.fillCurrenceyCode(currencyCode.get(3));
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(3)+" - IM Store Controls List","List Page","displayed");
		
		/*Create inventory store*/
		currencyPage.searchValue(companyId,eastStoreElements,3,1);
		
		currencyPage.clickOnAmend();
		
		currencyPage.updateInventoryStore();
		
		currencyPage.clickOnUpdate();
		currencyPage.clickOnCancel();
		
	}
	
	
	
	
	private void createStockAdjustment(CurrencyPageNew currencyPage,DataRow dataRow) throws InterruptedException {
		
		String code = "EDTHMVMT ACT=INSERT,CMPY="+companyId+",STORE=EAST,MVMT-IND=A";
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> eastStoreElements = dataRow.findNamesReturnValues("eastStoreElements");
		String message = "Movement Reference";
		
		currencyPage.isCommandDisplayed();
		
		currencyPage.fillCurrenceyCode(code);
			
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(0)+" - Positive Adjustment Line Detail..","Currency search page","displayed");
		
		currencyPage.addLineDetails(eastStoreElements,"A");
		
		currencyPage.clickOnAcceptWarnings();
		
		currencyPage.clickOnUpdate();
			
		String referenceMessage = currencyPage.getErrorContentText();
		
		/*Verify new material issue*/
		Assert.assertTrue(testcases,referenceMessage.contains(message), " "+referenceMessage," successfully");	
		
		currencyPage.isCommandDisplayed();
	}
	
	private void verifyStockBalance(CurrencyPageNew currencyPage,DataRow dataRow) throws InterruptedException {
		
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> eastStoreDetails = dataRow.findNamesReturnValues("eastStoreDetails");
		
		currencyPage.isCommandDisplayed();
		
		currencyPage.fillCurrenceyCode(currencyCode.get(1));
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(1)+" - Item Store Stock Value","Currency search page","displayed");
		
		currencyPage.searchItemStore(companyId,eastStoreDetails);
		
		currencyPage.clickOnCurrentStock();
		
		boolean verify = currencyPage.verifyCurrenctStock(eastStoreDetails,1);
		
		Assert.assertTrue(testcases,verify,"Current stock values are as "," expected");
		
		currencyPage.clickOnTotalItems();
		
		boolean verifyTotalItem = currencyPage.verifyTotalItems(eastStoreDetails);
		
		Assert.assertTrue(testcases,verifyTotalItem,"Total items are "," as expected");//Need Test
		
		currencyPage.clickOnCancel();
		
		currencyPage.clickOnCancel();
		
	}
	
	private void createMaterialIssue(CurrencyPageNew currencyPage,DataRow dataRow) throws InterruptedException{
		String code = "EDTHMVMT ACT=INSERT,CMPY="+companyId+",STORE=EAST,MVMT-IND=M";
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> eastMaterialIssue = dataRow.findNamesReturnValues("eastMaterialIssue");
		String message = "Movement Reference";
		
		currencyPage.fillCurrenceyCode(code);
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(0)+" - Material Issue Line Details Edit","Currency search page","displayed");
		
		currencyPage.insertMaterialIssue(eastMaterialIssue,"M");
		
		currencyPage.clickOnAcceptWarnings();
		
		currencyPage.clickOnUpdate();
		
		String referenceMessage = currencyPage.getErrorContentText();
		
		/*Verify new batch type in the list*/
		Assert.assertTrue(testcases,referenceMessage.contains(message), " "+referenceMessage," successfully");
		
		currencyPage.isCommandDisplayed();
	}

	private void reviewBatches(CurrencyPageNew currencyPage,DataRow dataRow) throws InterruptedException{
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> batchDetails1 = dataRow.findNamesReturnValues("batchDetails1");
		List<String> batchDetails2 = dataRow.findNamesReturnValues("batchDetails2");
					
		currencyPage.fillCurrenceyCode(currencyCode.get(2));
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(2)+" - Journal List","Journey search page","displayed");
			
		currencyPage.searchValue(companyId, 4, 0);
		
		currencyPage.clickOnEXTSections();
		
		currencyPage.searchValue("IMMI", 16, 5);
		
		currencyPage.sortValues();
		
		currencyPage.clickOnView();
		
		Assert.assertTrue(testcases,currencyPage.getTableHeader().contains("Journal Header"),"Journal header page","displayed");

		currencyPage.clickOnLines();
		
		boolean firstJournalDetails = currencyPage.verifyJournalDetails(1, batchDetails1);
		Assert.assertTrue(testcases,firstJournalDetails,"Batch values are "," as expected");

		boolean secondournalDetails = currencyPage.verifyJournalDetails(2, batchDetails2);
		Assert.assertTrue(testcases,secondournalDetails,"Batch values are "," as expected");
		
		currencyPage.clickOnCancel();			
	}
	
	private void verifyTotalStockBalance(CurrencyPageNew currencyPage,DataRow dataRow) throws InterruptedException{
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> eastStoreBalance = dataRow.findNamesReturnValues("eastStoreBalance");
		List<String> eastStoreValuation = dataRow.findNamesReturnValues("eastStoreValuation");
		List<String> eastStoreCurrentStock = dataRow.findNamesReturnValues("eastStoreCurrentStock");
		
		currencyPage.fillCurrenceyCode(currencyCode.get(1));
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(1)+" - Item Store Stock Value","Currency search page","displayed");
		
		currencyPage.searchItemStore(companyId,eastStoreBalance);
		
		boolean totalBalance = currencyPage.verifyTotalStockBalance(eastStoreBalance);
		Assert.assertTrue(testcases,totalBalance,"Total stock balance "," as expected");

		boolean storeItemValues = currencyPage.verifyStoreItemValues(eastStoreBalance,1);
		Assert.assertTrue(testcases,storeItemValues,"Store item values "," as expected");
		
		currencyPage.clickOnValuation();
		
		boolean verify = currencyPage.verifyStoreItemValuation(eastStoreValuation,1);
		Assert.assertTrue(testcases,verify,"Store item valuation is "," correct");

		currencyPage.clickOnReturnButton();
		
		currencyPage.clickOnCurrentStock();
		
		boolean currentStock = currencyPage.verifyCurrenctStock(eastStoreCurrentStock,0);
		Assert.assertTrue(testcases,currentStock,"Currenct stock is "," as expected");	
		
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
		String[] nodeID = { "AD02001" };
		String [] selectedNames = {"userName","passWord","currencyCode","eastStore","eastStoreElements","eastStoreDetails","eastMaterialIssue","batchDetails1","batchDetails2", "eastStoreBalance","eastStoreValuation","eastStoreCurrentStock"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
