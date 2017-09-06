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
 * Test Reference No	: 	A019 Balance Sheet Controls
 * Purpose              :   Set Up Ledger Control Management Code
 * Date					:   22-04-2014
 * ACCESS               :   EBD
 */

public class A019_NotInUse extends BaseTest{
	/*Launch the browser*/
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
		Assert.assertTrue(testcases, getCurreentDate().length()>0, "Login page", "displayed");
	}
	
	@Test( dataProvider ="dp")
	public void verify(DataRow dataRow) throws InterruptedException{
		String userName = dataRow.get("userName");
		String passWord = dataRow.get("passWord");
		String currencyCode = dataRow.get("code");
		List<String> value = dataRow.findNamesReturnValues("value");
		List<String> dummanagementCode = dataRow.findNamesReturnValues("dummanagementCode");
		List<String> n1ManagementCode = dataRow.findNamesReturnValues("n1ManagementCode");
		List<String> n2ManagementCode = dataRow.findNamesReturnValues("n2ManagementCode");
		List<String> s1ManagementCode = dataRow.findNamesReturnValues("s1ManagementCode");
		List<String> e1ManagementCode = dataRow.findNamesReturnValues("e1ManagementCode");
		List<String> w1ManagementCode = dataRow.findNamesReturnValues("w1ManagementCode");
		List<String> nbtzManagementCode = dataRow.findNamesReturnValues("nbtzManagementCode");
		List<String> sbtzManagementCode = dataRow.findNamesReturnValues("sbtzManagementCode");
		List<String> ebtzManagementCode = dataRow.findNamesReturnValues("ebtzManagementCode");
		List<String> wbtzManagementCode = dataRow.findNamesReturnValues("wbtzManagementCode");
		
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
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Management/Analysis Code List","Currency search page","displayed");
		
		currencyPage.searchValue(companyId,value,3,1);
	
		currencyPage.clickOnInsert();
		
		/*Create Management/Analysis code*/
	
		
		createManagementCode(currencyPage,dummanagementCode);
		createManagementCode(currencyPage,n1ManagementCode);
		createManagementCode(currencyPage,n2ManagementCode);
		createManagementCode(currencyPage,s1ManagementCode);
		createManagementCode(currencyPage,e1ManagementCode);
		createManagementCode(currencyPage,w1ManagementCode);
		createManagementCode(currencyPage,nbtzManagementCode);
		createManagementCode(currencyPage,sbtzManagementCode);
		createManagementCode(currencyPage,ebtzManagementCode);
		createManagementCode(currencyPage,wbtzManagementCode);
		
		/*Exit from the management analysis details page*/
		currencyPage.clickOnCancel();

		currencyPage.isConfirmPopUpDisplayed();
		
		currencyPage.logOut(2);
	}
		
	
	//		currencyPage.enterManagementDetails(managementList);
		
	private void createManagementCode(CurrencyPage currencyPage,List<String> managementList){
		
		String SuccMessage = "The previously-requested action has been performed";
		
		/*Create Management/Analysis code*/
		boolean update = currencyPage.enterManagementDetails(managementList);

		if(update == true){
			
			currencyPage.clickOnUpdate();
			
			
	
			Assert.assertTrue(testcases,currencyPage.getErrorContentText().contains(SuccMessage), "New management code "+managementList.get(0), " created successfully");
		
			currencyPage.ClickOnAnyButton("Return",1);
			
		}
		else{
			testcases.add(getCurreentDate()+" | Pass : New management code  "+managementList.get(0)+ " displayed in the list");
		}
			
	}
	
	@AfterClass (alwaysRun = true)
	public void tearDown(){
		super.tearDown();
	}
	
	@DataProvider
	public Object[][] dp() 
	{		
		String folder = "src/test/resources/";
		String xmlFilePath = folder  + "E5H5.xml";
		String[] nodeID = { "A019" };
		String [] selectedNames = {"userName","passWord","code","value","managementCode"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
