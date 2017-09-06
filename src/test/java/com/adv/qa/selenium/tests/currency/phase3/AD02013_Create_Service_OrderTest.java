package com.adv.qa.selenium.tests.currency.phase3;

import static org.testng.Assert.assertTrue;

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
 * Test Reference No	: 	AD02013 Create Service Order 
 * Purpose              :   Create Service Order 
 * Modified Date		:   Modified by Chetna/Dt: 21-Aug-2017
 * ACCESS               :   DOC
 */

public class AD02013_Create_Service_OrderTest extends BaseTest{
	
	
	private static String glOrderNumber;
	
	
	public static String getGlOrderNumber() {
		return glOrderNumber;
	}


	private static void setGlOrderNumber(String glOrderNumber) {
		AD02013_Create_Service_OrderTest.glOrderNumber = glOrderNumber;
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
		List<String> authorisor1 = dataRow.findNamesReturnValues("authorisor1");
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> orderCode = dataRow.findNamesReturnValues("orderCode");
		
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPageNew currencyPage = new CurrencyPageNew(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
				
		String orderNumber = createOrder(currencyPage,dataRow);
		
		setGlOrderNumber(orderNumber);
		
		/*String orderNumber= "0000000002";//Remove after use*/
		
		currencyPage.isCommandDisplayed();
		
		currencyPage.fillCurrenceyCode(currencyCode.get(1));
		
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(1)+" - Unauthorised Documents List","Currency search page","displayed");
		
		authoriseOrder(currencyPage,authorisor1,orderNumber);
		
		currencyPage.clickOnCancel();
		
		currencyPage.isCommandDisplayed();
		
		currencyPage.fillCurrenceyCode(currencyCode.get(0));
				
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(0)+" - Order - List","Currency search page","displayed");
	
		currencyPage.searchOrder(companyId, orderNumber, 19);
		
		boolean verify=currencyPage.verifyStatus(7,16,orderCode);
		
		Assert.assertTrue(testcases,verify,"Order Status is "+orderCode.get(16)," as expected");
		
		currencyPage.logOut(2);
	}
	
	private String createOrder(CurrencyPageNew currencyPage,DataRow dataRow) throws InterruptedException{		
		List<String> currencyCode = dataRow.findNamesReturnValues("currencyCode");
		List<String> orderCode = dataRow.findNamesReturnValues("orderCode");
		String message = "Order Reference";
		
		currencyPage.isCommandDisplayed();
		
		currencyPage.fillCurrenceyCode(currencyCode.get(0));
				
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(0)+" - Order - List","Currency search page","displayed");

		currencyPage.searchValue(companyId, orderCode, 19, 8);
		
		currencyPage.clickOnInsert1();
		
		currencyPage.createServiceOrderCode(orderCode);
		
		
		currencyPage.clickOnAcceptWarnings();
		
		currencyPage.clickOnUpdate();
			
		String referenceMessage = currencyPage.getErrorContentText();
		
		/*Verify new batch type in the list*/
		
		Assert.assertTrue(testcases,referenceMessage.contains(message), " "+referenceMessage," successfully");
			
		// Converting reference msg to Ordernuber, Order Reference 0000000002 will be created.
		String orderNumber = referenceMessage.substring(0, referenceMessage.indexOf(" will be created."));
		
		orderNumber = orderNumber.replace("DOC01 : Order Reference ", "");
		
		currencyPage.clickOnCancel();
		
		currencyPage.isConfirmPopUpDisplayed();
		
		boolean verify=currencyPage.verifyStatus(7,17,orderCode);
		
		Assert.assertTrue(testcases,verify,"Order Status is "+orderCode.get(17)," as expected");
		
		currencyPage.clickOnCancel1();
		
		return orderNumber;	
		
	}
	
	private void authoriseOrder(CurrencyPageNew currencyPage,List<String> authorisorList,String orderNumber) throws InterruptedException{
		
		currencyPage.searchAuthorisor(companyId, authorisorList,orderNumber, 2);
		
		currencyPage.selectMultiOrder();

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
		String[] nodeID = { "AD02013" };
		String [] selectedNames = {"userName","passWord","currencyCode","orderCode","authorisor1"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
