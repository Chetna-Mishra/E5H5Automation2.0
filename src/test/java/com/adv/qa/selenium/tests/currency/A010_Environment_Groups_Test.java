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
 * Modified By			:   Chetna, 24-Jan-2017
 * Test Reference No	: 	A010 Environment Groups
 * Purpose              :   Set Up Environment Groups
 * Date					:   23-04-2014
 * ACCESS               :   AFA
 */

public class A010_Environment_Groups_Test extends BaseTest{
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
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Environment Group List","Currency search page","displayed");
		
		currencyPage.clickOnInsert();
		
		/*Create environment */
		createEnvironmentGroup(currencyPage,firstDestination);
		createEnvironmentGroup(currencyPage,secondDestination);

		/*Exit from the environment group details page*/
		currencyPage.clickOnCancel();
		
		currencyPage.isConfirmPopUpDisplayed();
		
		/*Already included successful msg in the creation part hence commenting*/
		
//		verifyValues(currencyPage,firstDestination);
//		verifyValues(currencyPage,secondDestination);
		
		currencyPage.logOut(2);

	}
	
	private void createEnvironmentGroup(CurrencyPage currencyPage,List<String> environmentList) throws InterruptedException{
		
		/*Create environment group code*/
		boolean update = currencyPage.enterEnvironmentDetails(environmentList);

		String SuccMessage = "The previously-requested action has been performed";
		
		if(update == true){
			
			currencyPage.clickOnUpdate();
			
			
			Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "New environment group "+environmentList.get(0), "created successfully");
		}
		else{
			testcases.add(getCurreentDate()+" | Pass : New environment group "+environmentList.get(0)+ " already created");
		}
	}

//	private void verifyValues(CurrencyPage currencyPage,List<String> environmentList){
//		currencyPage.searchValue(environmentList,1,0);
//		
//		/*Verify new environment group in the list*/
//		if(currencyPage.verifyValues(environmentList.get(0))){
//			testcases.add(getCurreentDate()+" | Pass : New environment group "+environmentList.get(0)+ " displayed in the list");
//		}
//		else{
//			testcases.add(getCurreentDate()+" | Fail : New environment group "+environmentList.get(0)+ " not displayed in the list");
//		}
//	}

	
	@AfterClass (alwaysRun = true)
	public void tearDown(){
		super.tearDown();
	}
	
	@DataProvider
	public Object[][] dp() 
	{		
		String folder = "src/test/resources/";
		String xmlFilePath = folder  + "E5H5.xml";
		String[] nodeID = { "A010" };
		String [] selectedNames = {"userName","passWord","code","firstDestination","secondDestination"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
