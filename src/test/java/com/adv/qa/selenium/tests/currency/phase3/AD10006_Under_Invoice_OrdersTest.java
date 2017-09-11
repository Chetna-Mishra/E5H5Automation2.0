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
 * Test Reference No	: 	AD10006 Under Invoice Orders
 * Purpose              :   Enter Invoices for quantity less than receipts matched to Orders. 
 * Modified Date		:   Modified by Chetna/Dt: 08-Sep-2017  
 * ACCESS               :   DOC,DOA,PLE,GBB
 */

public class AD10006_Under_Invoice_OrdersTest extends BaseTest{
	
	private static String glOrderNumber;
	
	
	public static String getGlOrderNumber() {
		return glOrderNumber;
	}


	private static void setGlOrderNumber(String glOrderNumber) {
		AD10006_Under_Invoice_OrdersTest.glOrderNumber = glOrderNumber;
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
		
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		
		/*Login as Employee*/
		
		loginPage.logIn(userName.get(0), passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPageNew currencyPage = new CurrencyPageNew(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		String orderNumber = createOrder(currencyPage,dataRow);
		
		setGlOrderNumber(orderNumber);
		
	/*	String orderNumber = "0000000005"; //Remove after use*/
	
		currencyPage.isCommandDisplayed();
		
		//Login to the App as User=GREC	
		
		currencyPage.logOut(1);
		
		currencyPage.clickOnReturnForLogin();

		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		
		loginPage.logIn(userName.get(1), passWord);//Login as GREC
		
		createReceiveGoods(currencyPage,dataRow,orderNumber);
		
		currencyPage.isCommandDisplayed();
		
		createInvoice(currencyPage,dataRow,orderNumber);
		
		currencyPage.logOut(1);
		
	}
	
	private String createOrder(CurrencyPageNew currencyPage,DataRow dataRow) throws InterruptedException{
		
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> orderCode = dataRow.findNamesReturnValues("orderCode");
		String message = "Order Reference";
		
		currencyPage.isCommandDisplayed();
		
		currencyPage.fillCurrenceyCode(currencyCode.get(0));
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(0)+" - Order - List","Currency search page","displayed");
		
		currencyPage.searchValue(companyId, orderCode, 19, 8);
	
		currencyPage.clickOnInsert();
		
		currencyPage.createOrderCode(orderCode);
		
		currencyPage.clickOnUpdate();
			
		String referenceMessage = currencyPage.getErrorContentText();
		
		/*Verify new batch type in the list*/
		Assert.assertTrue(testcases,referenceMessage.contains(message), " "+referenceMessage," successfully");	

 	/*	Converting reference msg to Ordernuber, Order Reference 0000000005 will be created.*/
		String orderNumber = referenceMessage.substring(0, referenceMessage.indexOf(" will be created."));
		
		orderNumber = orderNumber.replace("DOC01 : Order Reference ", "");
		
		currencyPage.clickOnCancel();
		
		currencyPage.isConfirmPopUpDisplayed();
		
		currencyPage.clickOnCancel1();
		
		return orderNumber;
		
	}
	
	
	private void createReceiveGoods(CurrencyPageNew currencyPage,DataRow dataRow,String orderNumber) throws InterruptedException{
		
		String code = "EDTPGRNN ACT=INSERT,CMPY="+companyId+",ORDER="+orderNumber+"";

		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> receiveGoods = dataRow.findNamesReturnValues("receiveGoods");
		String message = "GRNs will be created in Background";
		String ADVICE = "ADVICE "+orderNumber+"";
		String GRN = "G"+orderNumber+"";
		
		currencyPage.fillCurrenceyCode(code);
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(1)+" - Goods Receive/Return Edit","Currency search page","displayed");
		
		currencyPage.addGoodsReceive(receiveGoods, ADVICE, GRN);
		
		currencyPage.clickOnUpdate();
		
		String referenceMessage = currencyPage.getErrorContentText();
		
		/*Verify new batch type in the list*/
		Assert.assertTrue(testcases,referenceMessage.contains(message), " "+referenceMessage," successfully");
		
		currencyPage.enterGoodsDetailsInPopUp(orderNumber);
		
		currencyPage.clickOnCancel();
		
		currencyPage.isConfirmPopUpDisplayed();
		
		currencyPage.isCommandDisplayed();
	}
	
	private void createInvoice(CurrencyPageNew currencyPage,DataRow dataRow,String orderNumber) throws InterruptedException{
		String code = "EDTGBTCH ACT=INSERT,CMPY="+companyId+",TRAN=1";
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> invoiceDetails = dataRow.findNamesReturnValues("invoiceDetails");
		List<String> transactionDetails = dataRow.findNamesReturnValues("transactionDetails");
		List<String> lineDetails = dataRow.findNamesReturnValues("lineDetails");
		String message = "Batch number";// Batch number 7 has been created
		
		currencyPage.isCommandDisplayed();
		
		currencyPage.fillCurrenceyCode(code);
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(2)+" - Enter Transaction Batch Header","Currency search page","displayed");
		
		currencyPage.enterInvoice(invoiceDetails,"Transaction");
		
		currencyPage.clickOnNewTransaction();
		
		Assert.assertTrue(testcases,currencyPage.getTableHeader().contains("Transaction Header"),"Transaction page","displayed");
		
		currencyPage.enterTransactionDetails(transactionDetails,orderNumber,"null");
		
		currencyPage.clickOnAcceptWarn();
		
		currencyPage.clickOnLines();
		
		String price = currencyPage.enterTaxableDetails(lineDetails, 3);
		
		Assert.assertTrue(testcases,price.equals(lineDetails.get(3)),"Invoice price is "+ price," expected " + lineDetails.get(3));
						
		currencyPage.clickOnAcceptWarn();
		
		currencyPage.clickOnUpdate();
					
		String referenceMessage = currencyPage.getErrorContentText();
		
		Assert.assertTrue(testcases,referenceMessage.contains(message), "Invoice "+referenceMessage," created successfully");	
		
		currencyPage.clickOnReturnButton();
		
		currencyPage.isCommandDisplayed();

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
		String[] nodeID = { "AD10006" };
		String [] selectedNames = {"userName","passWord","currencyCode","orderCode","receiveGoods","invoiceDetails","transactionDetails","lineDetails"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
