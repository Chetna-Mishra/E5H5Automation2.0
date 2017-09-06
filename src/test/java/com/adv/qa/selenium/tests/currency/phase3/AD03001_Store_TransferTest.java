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
 * Test Reference No	: 	AD03001 Store Transfer
 * Purpose              :   Check IM Stock Totals before Transfer 
 * Modified Date		:   Modified by Chetna/Dt: 23-Aug-2017
 * ACCESS               :   HBA
 */

public class AD03001_Store_TransferTest extends BaseTest{
	
	
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
		List<String> storeElements = dataRow.findNamesReturnValues("storeElements");
		List<String> westStoreElements = dataRow.findNamesReturnValues("westStoreElements");
		List<String> eastStoreElements = dataRow.findNamesReturnValues("eastStoreElements");
		List<String> westStoreDetails = dataRow.findNamesReturnValues("westStoreDetails");
		List<String> eastStoreDetails = dataRow.findNamesReturnValues("eastStoreDetails");
		List<String> storeDetails = dataRow.findNamesReturnValues("storeDetails");
		
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPageNew currencyPage = new CurrencyPageNew(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.isCommandDisplayed();
		
		currencyPage.fillCurrenceyCode(currencyCode.get(0));
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(0)+" - Item Store Stock Value","Currency search page","displayed");
		
		verifyStockBalance(currencyPage,dataRow,westStoreElements,0);
		verifyStockBalance(currencyPage,dataRow,eastStoreElements,0);
		
		currencyPage.clickOnCancel();
		
		amendInventoryStoreControl(currencyPage,dataRow);
		
		createStoreTransfer(currencyPage,currencyCode.get(1),storeElements,storeDetails);
		
		currencyPage.fillCurrenceyCode(currencyCode.get(0));
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(0)+" - Item Store Stock Value","Currency search page","displayed");

		verifyStockBalance(currencyPage,dataRow,westStoreDetails,1);
		verifyStockBalance(currencyPage,dataRow,eastStoreDetails,0);
		
		currencyPage.clickOnCancel();
		
		reviewBatches(currencyPage, dataRow);
		
		currencyPage.clickOnCancel();
		
		verifyRHEDReport(currencyPage,dataRow);
		
		currencyPage.logOut(2);
	}
	
	
private void verifyStockBalance(CurrencyPageNew currencyPage,DataRow dataRow,List<String> elements,int i) throws InterruptedException{
		
		currencyPage.searchItemStore(companyId,elements);
		
		
		boolean totalStockBalance = currencyPage.verifyTotalStockBalance(elements);
		
		Assert.assertTrue(testcases,totalStockBalance,"Total stock balance "," as expected");
		
		boolean storeItemValues = currencyPage.verifyStoreItemValues(elements,i);
		
		Assert.assertTrue(testcases,storeItemValues,"Store item values "," as expected");
				
		
		if(i==1){
			List<String> westStoreCurrentStock = dataRow.findNamesReturnValues("westStoreCurrentStock");
			
			currencyPage.clickOnCurrentStock();
			
			boolean currentStock = currencyPage.verifyCurrenctStock(westStoreCurrentStock,0);
			
			Assert.assertTrue(testcases,currentStock,"Currenct stock is "," as expected");				
			
			currencyPage.clickOnCancel();
		}
	
	}
	
private void amendInventoryStoreControl(CurrencyPageNew currencyPage,DataRow dataRow) throws InterruptedException{
	
	List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
	List<String> storeElements = dataRow.findNamesReturnValues("storeElements");
	
	currencyPage.isCommandDisplayed();
	
	currencyPage.fillCurrenceyCode(currencyCode.get(4));
	
	/*Verify currency search page displayed*/
	Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(4)+" - IM Store Controls List","List Page","displayed");
	
	/*Create inventory store*/
	currencyPage.searchValue(companyId,storeElements,3,1);
	
	currencyPage.clickOnAmend();
	
	currencyPage.updateInventoryStore();
	
	currencyPage.clickOnUpdate();
	currencyPage.clickOnCancel();
	
}

	
	
	private void createStoreTransfer(CurrencyPageNew currencyPage,String currencyCode,List<String> storeElements,List<String> elements) throws InterruptedException{
//		String code = "EDTHMVMT ACT=INSERT,CMPY="+companyId+",STORE=EAST,MVMT-IND=T";
		
		String code = "EDTHMVMT ACT=INSERT,CMPY="+companyId+",STORE=WEST,MVMT-IND=T";
		String message = "Movement Reference ";
		
		currencyPage.isCommandDisplayed();
		
		currencyPage.fillCurrenceyCode(code);
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Store Transfer Line Details Edit","Currency search page","displayed");
		
		currencyPage.addStoreTransferDetails(storeElements);
		
		currencyPage.addLineDetails(elements,"T");
		
		currencyPage.clickOnAcceptWarnings();
		
		currencyPage.clickOnUpdate();
			
		String referenceMessage = currencyPage.getErrorContentText();
		
		Assert.assertTrue(testcases,referenceMessage.contains(message), " "+referenceMessage," successfully");
		
		currencyPage.isCommandDisplayed();
	}
	

	private void reviewBatches(CurrencyPageNew currencyPage,DataRow dataRow) throws InterruptedException{
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> stkwBatchDetails = dataRow.findNamesReturnValues("stkwBatchDetails");
		List<String> stkeBatchDetails = dataRow.findNamesReturnValues("stkeBatchDetails");
		List<String> imdfBatchDetails = dataRow.findNamesReturnValues("imdfBatchDetails");
		List<String> imdfEBatchDetails = dataRow.findNamesReturnValues("imdfEBatchDetails");		
					
		currencyPage.fillCurrenceyCode(currencyCode.get(2));
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(2)+" - Journal List","Journey search page","displayed");
		
		currencyPage.searchValue(companyId, 4, 0);
		
		currencyPage.clickOnEXTSections();

		
		currencyPage.searchValue("IMTR", 16, 5);

		currencyPage.sortValues();
		
		currencyPage.clickOnView();
		
		Assert.assertTrue(testcases,currencyPage.getTableHeader().contains("Journal Header"),"Journal header page","displayed");

		currencyPage.clickOnLines();
		
		boolean stkwDetails = currencyPage.verifyJournalDetails(1, stkwBatchDetails);
		Assert.assertTrue(testcases,stkwDetails,"IMTR batch details for STKW report is "," correct");
		boolean stkeDetails = currencyPage.verifyJournalDetails(2, stkeBatchDetails);
		Assert.assertTrue(testcases,stkeDetails,"IMTR batch details for STKE report is "," correct");
		boolean imdfDetails = currencyPage.verifyJournalDetails(3, imdfBatchDetails);
		Assert.assertTrue(testcases,imdfDetails,"IMTR batch details for IMDF report is "," correct");
		boolean imdfEDetails = currencyPage.verifyJournalDetails(4, imdfEBatchDetails);
		Assert.assertTrue(testcases,imdfEDetails,"IMTR batch details for IMDF report is "," correct");
		
		currencyPage.clickOnCancel();				
	}
	
	
	
	private void verifyRHEDReport(CurrencyPageNew currencyPage,DataRow dataRow) throws InterruptedException{
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> reportSearchValue = dataRow.findNamesReturnValues("reportSearchValue");
		
		currencyPage.isCommandDisplayed();
		
		currencyPage.fillCurrenceyCode(currencyCode.get(3));
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(3)+" - Spool List","Currency search page","displayed");
		
		currencyPage.searchValue(companyId,reportSearchValue,10,1);
		
		currencyPage.clickOnSelectCheck();
		
		currencyPage.clickOnViewDocument();		
		
		boolean verifyReport = currencyPage.verifyRHEDReport(reportSearchValue);
		Assert.assertTrue(testcases,verifyReport,"RHED05 report is "," as expected");
		
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
		String[] nodeID = { "AD03001" };
		String [] selectedNames = {"userName","passWord","currencyCode","storeElements","westStoreElements","eastStoreElements",
		"westStoreCurrentStock","westStoreDetails","eastStoreDetails","storeDetails","stkwBatchDetails","stkeBatchDetails","imdfBatchDetails"
		,"imdfEBatchDetails","reportSearchValue"};;
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
