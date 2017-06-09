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
 * Test Reference No	: 	A115 User Roles Set-up
 * Purpose              :   To Set up and Use User Roles
 * Date					:   Modified on 18-May-2017/Chetna
 * ACCESS               :   ADC
 */

public class A115_User_Roles_Set_upTest extends BaseTest{
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
		List<String> role1 = dataRow.findNamesReturnValues("role1");
		List<String> role2 = dataRow.findNamesReturnValues("role2");
		List<String> userRole1 = dataRow.findNamesReturnValues("userRole1");
		List<String> userRole2 = dataRow.findNamesReturnValues("userRole2");		

		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPageNew currencyPage = new CurrencyPageNew(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(currencyCode.get(0));
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(0)+" - Role List","Currency search page","displayed");
		
		createRole(currencyPage,role1,currencyCode);
		createRole(currencyPage,role2,currencyCode);

		currencyPage.clickOnCancel1();
		
		currencyPage.isCommandDisplayed();
		
		currencyPage.fillCurrenceyCode(currencyCode.get(2));

		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode.get(2)+" - User Role List","Currency search page","displayed");
		
		createUserRole(currencyPage,userRole1);
		createUserRole(currencyPage,userRole2);
		
		currencyPage.clickOnCancel1();
		
		currencyPage.logOut(1);
		
	}
	
	public void createRole(CurrencyPageNew currencyPage,List<String> elements,List<String> currencyCode) throws InterruptedException{
	
		currencyPage.searchValue(elements, 1, 0);
		
		if(!currencyPage.verifyValues(elements.get(0)))
		{
		
		currencyPage.clickOnInsert1();
		
		boolean update = currencyPage.createRole(elements);
		
		if(update == true){
			
			currencyPage.clickOnUpdtWarnings();
			currencyPage.clickOnUpdate();
			}
		
		currencyPage.clickOnCancel();
		currencyPage.isConfirmPopUpDisplayed();
		
		currencyPage.searchValue(elements, 1, 0);
		
		if(currencyPage.verifyValues(elements.get(0))){
			testcases.add(getCurreentDate()+" | Pass : Role "+elements.get(0)+" created");
			}
			else{
				testcases.add(getCurreentDate()+" | Fail : Role "+elements.get(0)+" not created");
			}
		
		}
	}
	
	public void createUserRole(CurrencyPageNew currencyPage,List<String> elements){
			
		currencyPage.searchValue(companyId,elements, 3, 2);
		
		
		if(!currencyPage.verifyValues(elements.get(1))){
		
		currencyPage.clickOnInsert1();
		
		boolean update = currencyPage.createUserRole(companyId,elements);
			
		if(update == true){
			
			currencyPage.clickOnUpdate();
			}
			
			currencyPage.clickOnCancel();
			currencyPage.isConfirmPopUpDisplayed();
			
			if(currencyPage.verifyValues(elements.get(1))){
				testcases.add(getCurreentDate()+" | Pass : User Role "+elements.get(1)+" created");
			}
			else{
				testcases.add(getCurreentDate()+" | Fail : User Role "+elements.get(1)+" not created");
			}
			
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
		String xmlFilePath = folder  + "phase3.xml";
		String[] nodeID = { "A115" };
		String [] selectedNames = {"userName","passWord","currencyCode","securityGroup","rangeListP","rangeListPM","rangeListIM","accessCodeP","accessCodePM","accessCodeIM"
				,"securityGroupP","securityGroupPM","securityGroupIM","role1","role2","userRole1","userRole2"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
