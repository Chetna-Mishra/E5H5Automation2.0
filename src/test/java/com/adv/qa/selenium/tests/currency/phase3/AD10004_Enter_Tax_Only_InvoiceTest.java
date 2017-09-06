package com.adv.qa.selenium.tests.currency.phase3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
 * Test Reference No	: 	AD10004 Enter Tax Only Invoice
 * Purpose              :   Enter Tax Only Invoice 
 * Modified Date		:   Modified by Chetna/Dt: 05-Sep-2017 
 * ACCESS               :   GBB
 */

public class AD10004_Enter_Tax_Only_InvoiceTest extends BaseTest{
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
				
		createInvoice(currencyPage,dataRow);
		
		currencyPage.isCommandDisplayed();
		
		reviewBatches(currencyPage, dataRow);
		
		currencyPage.clickOnCancel();
								
		enterCreditNotes(currencyPage,dataRow);
		
		currencyPage.isCommandDisplayed();
		
		reviewBatchesCreditNotes(currencyPage, dataRow);
		
		currencyPage.logOut(2);
	}

	
	private void createInvoice(CurrencyPageNew currencyPage,DataRow dataRow) throws InterruptedException{
		String code = "EDTGBTCH ACT=INSERT,CMPY="+companyId+",TRAN=1";
		
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> invoiceDetails = dataRow.findNamesReturnValues("invoiceDetails");
		List<String> transactionDetails = dataRow.findNamesReturnValues("transactionDetails");
		List<String> lineDetails = dataRow.findNamesReturnValues("lineDetails");
		String message = "Batch number";//Batch number 4 has been created
		
		currencyPage.isCommandDisplayed();
		
		currencyPage.fillCurrenceyCode(code);
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(0)+" - Enter Transaction Batch Header","Currency search page","displayed");
		
		currencyPage.enterInvoice(invoiceDetails,"Transaction");
		
		currencyPage.clickOnNewTransaction();
		
		Assert.assertTrue(testcases,currencyPage.getTableHeader().contains("Transaction Header"),"Transaction page","displayed");
		
		currencyPage.enterTransactionDetails(transactionDetails,"null","null");
		
		currencyPage.clickOnAcceptWarn();
		
		currencyPage.clickOnLines();
		
		currencyPage.enterTaxableDetails(lineDetails, 0);
						
		currencyPage.clickOnAcceptWarn();
		
		currencyPage.clickOnUpdate();	
		
		String referenceMessage = currencyPage.getErrorContentText();
		
		Assert.assertTrue(testcases,referenceMessage.contains(message), "Invoice "+referenceMessage," created successfully");	
		
		currencyPage.clickOnReturnButton();
	}
	
	private void enterCreditNotes(CurrencyPageNew currencyPage,DataRow dataRow) throws InterruptedException{
		String code = "EDTGBTCH ACT=INSERT,CMPY="+companyId+",TRAN=2";
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> invoiceDetails = dataRow.findNamesReturnValues("invoiceDetails");
		List<String> transactionDetailsCRN = dataRow.findNamesReturnValues("transactionDetailsCRN");
		List<String> lineDetails = dataRow.findNamesReturnValues("lineDetails");
		String message = "Batch number";//Batch number 5 has been created
		
		currencyPage.isCommandDisplayed();
		
		currencyPage.fillCurrenceyCode(code);
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(0)+" - Enter Transaction Batch Header","Currency search page","displayed");
		
		currencyPage.enterInvoice(invoiceDetails,"Transaction");
		
		currencyPage.clickOnNewTransaction();
		
		Assert.assertTrue(testcases,currencyPage.getTableHeader().contains("Transaction Header"),"Transaction page","displayed");
		
		currencyPage.enterTransactionDetails(transactionDetailsCRN,"null","null");
		
		currencyPage.clickOnAcceptWarn();
		
		currencyPage.clickOnLines();
		
		currencyPage.enterTaxableDetails(lineDetails, 0);
		
		currencyPage.clickOnAcceptWarn();
						
		currencyPage.clickOnUpdate();
		
		String referenceMessage = currencyPage.getErrorContentText();
		
		Assert.assertTrue(testcases,referenceMessage.contains(message), "Credit note invoice "+referenceMessage," created successfully");	
		
		currencyPage.clickOnReturnButton();
		
				
	}


	private void reviewBatches(CurrencyPageNew currencyPage,DataRow dataRow) throws InterruptedException{
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> batchDetails1 = dataRow.findNamesReturnValues("batchDetails1");
		List<String> batchDetails2 = dataRow.findNamesReturnValues("batchDetails2");
					
		currencyPage.fillCurrenceyCode(currencyCode.get(1));
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(1)+" - Journal List","Journey search page","displayed");
		

		currencyPage.searchValue(companyId, 4, 0);
		
		currencyPage.clickOnEXTSections();
		
		currencyPage.searchValue("PDE3", 16, 5);
		
		currencyPage.sortValues();
		
		currencyPage.clickOnView();
		
		Assert.assertTrue(testcases,currencyPage.getTableHeader().contains("Journal Header"),"Journal header page","displayed");

		currencyPage.clickOnLines();
		
		boolean batchDetailsValues1 = currencyPage.verifyJournalDetails(1, batchDetails1);
		Assert.assertTrue(testcases,batchDetailsValues1,"2000 batch values are "," correct");
		
		boolean batchDetailsValues2 = currencyPage.verifyJournalDetails(2, batchDetails2);
		Assert.assertTrue(testcases,batchDetailsValues2,"VATA batch values are "," correct");
		
		currencyPage.clickOnCancel();				
	}
	
	private void reviewBatchesCreditNotes(CurrencyPageNew currencyPage,DataRow dataRow) throws InterruptedException{
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> batchDetails3 = dataRow.findNamesReturnValues("batchDetails3");
		List<String> batchDetails4 = dataRow.findNamesReturnValues("batchDetails4");
					
		currencyPage.fillCurrenceyCode(currencyCode.get(1));
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(1)+" - Journal List","Journey search page","displayed");
		

		currencyPage.searchValue(companyId, 4, 0);
		
		currencyPage.clickOnEXTSections();
		
		currencyPage.searchValue("PDE3", 16, 5);
		
		currencyPage.sortValues();
		
		currencyPage.clickOnView();
		
		Assert.assertTrue(testcases,currencyPage.getTableHeader().contains("Journal Header"),"Journal header page","displayed");

		currencyPage.clickOnLines();
		
		boolean batchDetailsValues3 = currencyPage.verifyJournalDetails(1, batchDetails3);
		Assert.assertTrue(testcases,batchDetailsValues3,"2000 batch values are "," correct");
		
		boolean batchDetailsValues4 = currencyPage.verifyJournalDetails(2, batchDetails4);
		Assert.assertTrue(testcases,batchDetailsValues4,"VATA batch values are "," correct");
		
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
		String[] nodeID = { "AD10004" };
		String [] selectedNames = {"userName","passWord","currencyCode","invoiceDetails","transactionDetails","transactionDetailsCRN","lineDetails","batchDetails1","batchDetails2","batchDetails3","batchDetails4"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
