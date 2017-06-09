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
 * Test Reference No	: 	A032 Management codes
 * Purpose              :   Set Up Management Codes
 * Date					:   14-05-2014
 * ACCESS               :   EBD
 */

public class A033_Analysis_CodeTest extends BaseTest{
	/*Launch the browser*/
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}
	
	@Test( dataProvider ="dp")
	public void verify(DataRow dataRow) throws InterruptedException{
		String userName = dataRow.get("userName");
		String passWord = dataRow.get("passWord");
		String code = dataRow.get("code");
		List<String> values = dataRow.findNamesReturnValues("values");
		List<String> avManagementCode = dataRow.findNamesReturnValues("avManagementCode");
		List<String> hiFIManagementCode = dataRow.findNamesReturnValues("hiFIManagementCode");
		
		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPage currencyPage = new CurrencyPage(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(code);
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+code+" - Management/Analysis Code List","Currency search page","displayed");
		
		currencyPage.searchValue(companyId,values,3,1);
		
		currencyPage.clickOnInsert();
		
		createAnalysisCode(currencyPage,avManagementCode);
		createAnalysisCode(currencyPage,hiFIManagementCode);
		
	
		/*Exit from the management analysis details page*/
		currencyPage.clickOnCancel();

		currencyPage.isConfirmPopUpDisplayed();
		
		currencyPage.logOut(2);
	}
	

	private void createAnalysisCode(CurrencyPage currencyPage,List<String> managementList){
		String message = "The previously-requested action has been performed";
		/*Create Management/Analysis code*/
		boolean update = currencyPage.enterAnalysisDetails(managementList);

		if(update == true)
		
		{
			currencyPage.clickOnUpdate();
			
			currencyPage.ClickOnAnyButton("Return",1);
			
			/*Verify new management code in the list*/
			if(currencyPage.getToolContentText().contains(message))
			
			{
				testcases.add(getCurreentDate()+" | Pass : New management code "+managementList.get(0)+ " displayed in the list");
			}
			else{
				testcases.add(getCurreentDate()+" | Fail : New management code "+managementList.get(0)+ " not displayed in the list");
			}
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
		String xmlFilePath = folder  + "A033.xml";
		DataResource dataResource = new DataResource(xmlFilePath);
		DataRow [] [] rows = dataResource.getDataRows4DataProvider();
		return rows;
	}
}
