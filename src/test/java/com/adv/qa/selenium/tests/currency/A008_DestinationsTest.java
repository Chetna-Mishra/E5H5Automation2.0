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
 * Modified By 			: 	Chetna, Dt: 23-Jan-2017
 * Test Reference No	: 	A008 Destinations
 * Purpose              :   Set Up Destinations
 * Date					:   23-04-2014
 * ACCESS               :   ANC
 */

public class A008_DestinationsTest extends BaseTest{
	/*Launch the browser*/
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}
	
	
	@Test( dataProvider ="dp")
	public void verify(DataRow dataRow) throws InterruptedException{
		String userName = dataRow.get("userName");
		String passWord = dataRow.get("passWord");
		String currencyCode = dataRow.get("code");
		List<String> firstDestination = dataRow.findNamesReturnValues("firstDestination");
		List<String> secondDestination = dataRow.findNamesReturnValues("secondDestination");
		
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPage currencyPage = new CurrencyPage(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(currencyCode);
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Destination List","Currency search page","displayed");
		
		/*Create Destination*/
		createDestination(currencyPage,dataRow,firstDestination);
		createDestination(currencyPage,dataRow,secondDestination);
		
		/*Logout from the application*/
		currencyPage.logOut(2);

	}

	
	
	
	private void createDestination(CurrencyPage currencyPage, DataRow dataRow,List<String> destinationList) throws InterruptedException
	
	{

		currencyPage.searchValue(destinationList,1,0);
		
		if(!currencyPage.verifyValues(destinationList.get(0))){
		
			String SuccMessage = "The previously-requested action has been performed";
			
			currencyPage.clickOnInsert();
			
			/*Create destination code*/
//			currencyPage.enterDestinationDetails(destinationList);
			
			boolean update = currencyPage.enterDestinationDetails(destinationList);
			
			if (update == true) {
				
				currencyPage.clickOnUpdate();

				
				Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "New destination "+destinationList.get(0), "created successfully");
				
				
				currencyPage.clickOnCancel();
				}
			
			}
			
			/*Exit from the destination edit page*/
	
			else	{
			testcases.add(getCurreentDate()+" | Pass : New destination "+destinationList.get(0)+ " already created");
				}
			
	
			}
			
	
	
	
	
	
//	private void createDestination(CurrencyPage currencyPage, DataRow dataRow,List<String> destinationList) throws InterruptedException
//	
//	{
//
//		currencyPage.searchValue(destinationList,1,0);
//		
//		if(!currencyPage.verifyValues(destinationList.get(0))){
//		
//			String message = "The previously-requested action has been performed";
//			
//			currencyPage.clickOnInsert();
//			
//			/*Create destination code*/
////			currencyPage.enterDestinationDetails(destinationList);
//			
//			boolean update = currencyPage.enterDestinationDetails(destinationList);
//			
//			if (update == true) {
//				
//				currencyPage.clickOnUpdate();
//
//				if (currencyPage.getErrorContentText().contains(message))
//				{
//
//					testcases.add(getCurreentDate()+" | Pass : New destination "+destinationList.get(0)+ " created");
//				}
//				else{
//					testcases.add(getCurreentDate()+" | Fail : New destination "+destinationList.get(0)+ " not created");
//				}
//				
//				
//				currencyPage.clickOnCancel();
//				}
//			
//			}
//			
//			/*Exit from the destination edit page*/
//	
//			else	{
//			testcases.add(getCurreentDate()+" | Pass : New destination "+destinationList.get(0)+ " already created");
//				}
//			
//	
//			}
//			

	
	@AfterClass (alwaysRun = true)
	public void tearDown(){
		super.tearDown();
	}
	
	@DataProvider
	public Object[][] dp() 
	{		
		String folder = "src/test/resources/";
		String xmlFilePath = folder  + "E5H5.xml";
		String[] nodeID = { "A008" };
		String [] selectedNames = {"userName","passWord","code","firstDestination","secondDestination"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
