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
 * Test Reference No	: 	AD10001 Log Single Invoice
 * Purpose              :   Create Stock Adjustment In 
 * Modified Date		:   Modified by Chetna/Dt: 01-Sep-2017
 * ACCESS               :   GCA
 */

public class AD10001_Log_Single_InvoiceTest extends BaseTest{
	/*Launch the browser*/
	
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}
	
	@Test( dataProvider ="dp")
	public void verify(DataRow dataRow) throws InterruptedException{
		String userName = dataRow.get("userName");
		String passWord = dataRow.get("passWord");
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		
		
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPageNew currencyPage = new CurrencyPageNew(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(currencyCode.get(2));
		
		/*Verify supplier search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(2)+" - Supplier List","Currency search page","displayed");

		/*Amending Supplier for Tax Code and */
		amendSupplier(currencyPage,dataRow);

		createInvoice(currencyPage,dataRow);
		
		currencyPage.isCommandDisplayed();
		
		reviewBatches(currencyPage, dataRow);
								
		currencyPage.logOut(2);
	}
	
	
	
	private void amendSupplier(CurrencyPageNew currencyPage,DataRow dataRow) throws InterruptedException{
		
		String SuccMessage = "The previously-requested action has been performed";
		List<String> aMendSonySupplier = dataRow.findNamesReturnValues("aMendSonySupplier");
		
		currencyPage.searchValue(companyId,aMendSonySupplier,8,1);
		
		currencyPage.clickOnAmend();
		currencyPage.clickOnPurControl();
		
		currencyPage.clickOnTax();
		
		currencyPage.aMendSupplierTaxInfo(aMendSonySupplier);
		
		currencyPage.clickOnUpdate();
		
		Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "Supplier "+aMendSonySupplier.get(0), "updated successfully");
		
		currencyPage.clickOnCancel();
		
	}
	
	
	private void createInvoice(CurrencyPageNew currencyPage,DataRow dataRow) throws InterruptedException{
		
		String code = "LOGGBTCH ACT=INSERT,CMPY="+companyId+",TRAN-TYPE=1";
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> invoiceDetails = dataRow.findNamesReturnValues("invoiceDetails");
		List<String> transactionDetails = dataRow.findNamesReturnValues("transactionDetails");
		List<String> header = dataRow.findNamesReturnValues("header");
		
		String message = "Batch number";// Batch number 2 has been created
		
		
		currencyPage.isCommandDisplayed();
		
		currencyPage.fillCurrenceyCode(code);
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(0)+" - Log Batch Header","Currency search page","displayed");
		
		currencyPage.enterInvoice(invoiceDetails,"Invoice");
		
		currencyPage.clickOnTransaction();
		
		Assert.assertTrue(testcases,currencyPage.getTableHeader().contains("Log Transaction Header"),"Transaction page","displayed");
		
		currencyPage.logTransactionDetails(transactionDetails);
		
		currencyPage.clickOnAcceptWarnings();
						
		currencyPage.clickOnUpdate();
						
		String referenceMessage = currencyPage.getErrorContentText();
		
		/*Verify new batch type in the list*/
		Assert.assertTrue(testcases,referenceMessage.contains(message), "Invoice "+referenceMessage," created successfully");
		
		boolean storeItemValues = currencyPage.verifyStoreItem(header, 1);
		
		Assert.assertTrue(testcases,storeItemValues, "Store item values are ", " as expected");
		
		currencyPage.clickOnCancel();
		
		currencyPage.isCommandDisplayed();
	}

	private void reviewBatches(CurrencyPageNew currencyPage,DataRow dataRow) throws InterruptedException{
	
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> batchDetails1 = dataRow.findNamesReturnValues("batchDetails1");
		List<String> batchDetails2 = dataRow.findNamesReturnValues("batchDetails2");
					
		currencyPage.fillCurrenceyCode(currencyCode.get(1));
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(1)+" - Journal List","Journey search page","displayed");
		
		currencyPage.searchValue(companyId, 4, 0);
		
		currencyPage.clickOnEXTSections();
		
		currencyPage.searchValue("PDE2", 16, 5);
		
		currencyPage.sortValues();
		
		currencyPage.clickOnView();
		
		Assert.assertTrue(testcases,currencyPage.getTableHeader().contains("Journal Header"),"Journal header page","displayed");

		currencyPage.clickOnLines();
		
		boolean batchDetailsValues1 = currencyPage.verifyJournalDetails(1, batchDetails1);
		Assert.assertTrue(testcases,batchDetailsValues1,"2150 batch values are "," correct");
		
		boolean batchDetailsValues2 = currencyPage.verifyJournalDetails(2, batchDetails2);
		Assert.assertTrue(testcases,batchDetailsValues2,"VATA batch values are "," correct");
		
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
		String[] nodeID = { "AD10001" };
		String [] selectedNames = {"userName","passWord","currencyCode","invoiceDetails","aMendSonySupplier","transactionDetails","header","batchDetails1","batchDetails2"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
