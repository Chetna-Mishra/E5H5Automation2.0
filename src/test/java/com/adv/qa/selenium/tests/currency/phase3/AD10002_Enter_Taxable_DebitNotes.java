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
 * Test Reference No	: 	AD10002_Enter_Taxable_DebitNotes
 * Purpose              :   Create Stock Adjustment In 
 * Modified Date		:   Modified by Chetna/Dt: 04-Sep-2017
 * ACCESS               :   GCA/GBB
 */

public class AD10002_Enter_Taxable_DebitNotes extends BaseTest{
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
		
		String SuccMessage = "The previously-requested action has been performed";
		
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPageNew currencyPage = new CurrencyPageNew(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(currencyCode.get(0));
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(0)+" - AP Company Controls List","Currency search page","displayed");

		currencyPage.searchValue(companyId,1,0);
		
		currencyPage.clickOnAmend();
		
		currencyPage.amendAPCompanyControl(4,"Manual and Generated");
		
		currencyPage.clickOnUpdate();
		
		Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "New account payable control "+companyId, "updated successfully");
		
		currencyPage.clickOnCancel();
		
		currencyPage.isCommandDisplayed();
				
		createInvoice(currencyPage,dataRow);
		
		currencyPage.isCommandDisplayed();
		
		reviewBatches(currencyPage, dataRow);
								
		currencyPage.logOut(2);
	}
	
	
	private void createInvoice(CurrencyPageNew currencyPage,DataRow dataRow) throws InterruptedException{
		String code = "EDTGBTCH ACT=INSERT,CMPY="+companyId+",TRAN=6";
	    List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> invoiceDetails = dataRow.findNamesReturnValues("invoiceDetails");
		List<String> transactionDetails = dataRow.findNamesReturnValues("transactionDetails");
		List<String> lineDetails = dataRow.findNamesReturnValues("lineDetails");
		String message = "Batch number";//Batch number 3 has been created
		
		currencyPage.isCommandDisplayed();
		
		currencyPage.fillCurrenceyCode(code);
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(1)+" - Enter Transaction Batch Header","Currency search page","displayed");
		
		currencyPage.enterInvoice(invoiceDetails,"Transaction");
		
		currencyPage.clickOnNewTransaction();
		
		Assert.assertTrue(testcases,currencyPage.getTableHeader().contains("Transaction Header"),"Transaction page","displayed");

		currencyPage.enterTransactionDetails(transactionDetails,"null","null");
		
		currencyPage.clickOnAcceptWarn();
		
		currencyPage.clickOnLines();
		
		currencyPage.enterTaxableDetails(lineDetails, 1);
		
		currencyPage.clickOnAcceptWarn();	
		
		currencyPage.clickOnUpdate();
		
		String referenceMessage = currencyPage.getErrorContentText();
		
		Assert.assertTrue(testcases,referenceMessage.contains(message), "Invoice "+referenceMessage," created successfully");	
		
		currencyPage.clickOnReturnButton();

	}

	private void reviewBatches(CurrencyPageNew currencyPage,DataRow dataRow) throws InterruptedException{
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> batchDetails1 = dataRow.findNamesReturnValues("batchDetails1");
		List<String> batchDetails2 = dataRow.findNamesReturnValues("batchDetails2");
		List<String> batchDetails3 = dataRow.findNamesReturnValues("batchDetails3");
					
		currencyPage.fillCurrenceyCode(currencyCode.get(2));
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(2)+" - Journal List","Journey search page","displayed");
		
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
		
		boolean batchDetailsValues3 = currencyPage.verifyJournalDetails(3, batchDetails3);
		Assert.assertTrue(testcases,batchDetailsValues3,"DEN batch values are "," correct");
		
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
		String[] nodeID = { "AD10002" };
		String [] selectedNames = {"userName","passWord","currencyCode","invoiceDetails","transactionDetails","lineDetails","batchDetails1","batchDetails2","batchDetails3"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
