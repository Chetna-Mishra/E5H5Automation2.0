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
 * Test Reference No	: 	AD02009 Goods Receiving
 * Purpose              :   Create Stock Adjustment In 
 * Date					:   Modified on 02June-2017/Chetna  
 * ACCESS               :   DOA,PLE,EDA,HCJ
 */

public class AD02009_Goods_ReceivingTest extends BaseTest{
	
	private static String glOrderNumber;
	
	
	public static String getGlOrderNumber() {
		return glOrderNumber;
	}


	private static void setGlOrderNumber(String glOrderNumber) {
		AD02009_Goods_ReceivingTest.glOrderNumber = glOrderNumber;
	}


	/*Launch the browser*/
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}
	
	
	@Test( dataProvider ="dp")
	public void verify(DataRow dataRow) throws InterruptedException{
		List<String> userName = dataRow.findNamesReturnValues("userName");
		String passWord = dataRow.get("passWord");
		
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> authorisor1 = dataRow.findNamesReturnValues("authorisor1");
		List<String> authorisor2 = dataRow.findNamesReturnValues("authorisor2");
			
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		//Login to the App as User=Admin
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
	
		loginPage.logIn(userName.get(0), passWord);//Login as Employee
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPageNew currencyPage = new CurrencyPageNew(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
				
		String orderNumber = createOrder(currencyPage,dataRow);
		
		setGlOrderNumber(orderNumber);
		
	/*	String orderNumber = "0000000001"; //Remove after use*/
		
		currencyPage.isCommandDisplayed();
		
		currencyPage.fillCurrenceyCode(currencyCode.get(5));
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(5)+" - Unauthorised Documents List","Currency search page","displayed");
		
		authoriseOrder(currencyPage,authorisor1,orderNumber);
		authoriseOrder(currencyPage,authorisor2,orderNumber);
		
		currencyPage.clickOnCancel();
		
		currencyPage.isCommandDisplayed();
		
		currencyPage.logOut(1);
		
		currencyPage.clickOnReturnForLogin();
		

		//Login to the App as User=GREC		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		
		loginPage.logIn(userName.get(1), passWord);//Login as GREC
		
		createReceiveGoods(currencyPage,dataRow,orderNumber);
		
		currencyPage.isCommandDisplayed();
		
		reviewBatches(currencyPage, dataRow);
		
		currencyPage.clickOnCancel();
		
		currencyPage.isCommandDisplayed();
		
		currencyPage.logOut(1);
		
		currencyPage.clickOnReturnForLogin();
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		
		loginPage.logIn(userName.get(2), passWord);//Login as Admin
		
		currencyPage.isCommandDisplayed();
		
		verifyTotalStockBalance(currencyPage,dataRow);
				
		currencyPage.logOut(2);
	}
	
	public String createOrder(CurrencyPageNew currencyPage,DataRow dataRow) throws InterruptedException{
		
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> orderCode = dataRow.findNamesReturnValues("orderCode");
		
		String message = "Order Reference";
		
		currencyPage.isCommandDisplayed();
		
		currencyPage.fillCurrenceyCode(currencyCode.get(0));
				
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(0)+" - Order - List","Order search page","displayed");

		currencyPage.searchValue(companyId, orderCode, 19, 8);
		
		currencyPage.clickOnInsert1();	
		
		currencyPage.createOrderCode(orderCode);
		
		currencyPage.clickOnUpdate();
			
		String referenceMessage = currencyPage.getErrorContentText();
		
		/*Verify new batch type in the list*/
		
		Assert.assertTrue(testcases,referenceMessage.contains(message), " "+referenceMessage," successfully");
			
		// Converting reference msg to Ordernuber, Order Reference 0000000001 will be created.
		String orderNumber = referenceMessage.substring(0, referenceMessage.indexOf(" will be created."));
		
		orderNumber = orderNumber.replace("DOC01 : Order Reference ", "");
		
		/*System.out.println(orderNumber);*/
		
		/*	referenceMessage = referenceMessage.substring(8).replaceAll("[^0-9]", "");//Not in user*/
		
		currencyPage.clickOnCancel();
		
		currencyPage.isConfirmPopUpDisplayed();
		
		currencyPage.clickOnCancel1();
		
		return orderNumber;
		
		
	}
	
	private void authoriseOrder(CurrencyPageNew currencyPage,List<String> authorisorList,String orderNumber) throws InterruptedException{
		
		
		currencyPage.searchAuthorisor(companyId, authorisorList,orderNumber, 2);
		
		currencyPage.selectOrderAuthorisor();

	}
	
	
	private void createReceiveGoods(CurrencyPageNew currencyPage,DataRow dataRow,String orderNumber) throws InterruptedException{
		String code = "EDTPGRNN ACT=INSERT,CMPY="+companyId+",ORDER="+orderNumber+"";
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> receiveGoods = dataRow.findNamesReturnValues("receiveGoods");
		String message = "GRNs will be created in Background";
		String ADVICE = "ADVICE "+orderNumber+"";
		String GRN = "G"+orderNumber+"";
		
		currencyPage.fillCurrenceyCode(code);
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(2)+" - Goods Receive/Return Edit","Currency search page","displayed");
		
		currencyPage.addGoodsReceive(receiveGoods, ADVICE, GRN);
		
		currencyPage.clickOnUpdate();
		
		String referenceMessage = currencyPage.getErrorContentText();
		
		/*Verify new batch type in the list*/
		Assert.assertTrue(testcases,referenceMessage.contains(message), " "+referenceMessage," successfully");
		
		
		currencyPage.enterGoodsDetailsInPopUp(orderNumber);
		
		currencyPage.clickOnCancel();
		
		currencyPage.isConfirmPopUpDisplayed();
		
	}

	private void reviewBatches(CurrencyPageNew currencyPage,DataRow dataRow) throws InterruptedException{
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> batchDetails1 = dataRow.findNamesReturnValues("batchDetails1");
		List<String> batchDetails2 = dataRow.findNamesReturnValues("batchDetails2");
					
		currencyPage.fillCurrenceyCode(currencyCode.get(3));
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(3)+" - Journal List","Journey search page","displayed");
		
	
		currencyPage.searchValue(companyId, 4, 0);
		
		currencyPage.clickOnEXTSections();
		
		currencyPage.searchValue("ACC", 16, 5);
	
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
		List<String> stockBalance = dataRow.findNamesReturnValues("stockBalance");
		List<String> stockBalanceValuation = dataRow.findNamesReturnValues("stockBalanceValuation");
		List<String> stockBalanceCurrencyStock = dataRow.findNamesReturnValues("stockBalanceCurrencyStock");
		
		currencyPage.fillCurrenceyCode(currencyCode.get(4));
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(4)+" - Item Store Stock Value","Currency search page","displayed");
		
		currencyPage.searchItemStore(companyId,stockBalance);
		
		
		boolean totalStockBalance = currencyPage.verifyTotalStockBalance(stockBalance);
		
		Assert.assertTrue(testcases,totalStockBalance,"Total stock balance "," as expected");
		
		
		boolean storeItemValues = currencyPage.verifyStoreItemValues(stockBalance,1);	
		
		Assert.assertTrue(testcases,storeItemValues,"Store item values "," as expected");
		
		currencyPage.clickOnValuation();
		
		boolean valuation = currencyPage.verifyStoreItemValuation(stockBalanceValuation,0);
		
		Assert.assertTrue(testcases,valuation,"Store item valuation is "," as expected");
		
		
		currencyPage.clickOnReturnButton();
		
		currencyPage.clickOnCurrentStock();
		
		boolean currentStock = currencyPage.verifyCurrenctStock(stockBalanceCurrencyStock,0);
		
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
		String[] nodeID = { "AD02009" };
		String [] selectedNames = {"userName","passWord","currencyCode","orderCode","authorisor1","authorisor2","receiveGoods","batchDetails1","batchDetails2","stockBalance","stockBalanceValuation","stockBalanceCurrencyStock"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
