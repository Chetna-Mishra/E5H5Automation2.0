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
 * Test Reference No	: 	A114 Security Group Access Codes   
 * Purpose              :   Security Group Access Codes 
 * Date					:   Modified on 17-May-2017/Chetna
 * ACCESS               :   ADL
 */

public class A114_Security_Group_Access_CodesTest extends BaseTest{
	/*Launch the browser*/
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}
	
	@Test( dataProvider ="dp")
	public void verify(DataRow dataRow) throws InterruptedException{
		String userName = dataRow.get("userName");
		String passWord = dataRow.get("passWord");
		String currencyCode = dataRow.get("currencyCode");
		List<String> securityGroup1 = dataRow.findNamesReturnValues("securityGroup1");
		List<String> securityGroup2 = dataRow.findNamesReturnValues("securityGroup2");
		List<String> securityGroup3 = dataRow.findNamesReturnValues("securityGroup3");
		List<String> securityGroup4 = dataRow.findNamesReturnValues("securityGroup4");

		/*Log in to application*/
		LoginPage loginPage = new LoginPage(driver);
		
		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");
		
		loginPage.logIn(userName, passWord);
		
		/*Navigate to currency page Home page e5 application*/
		CurrencyPageNew currencyPage = new CurrencyPageNew(driver);
		
		/*Verify command line*/
		Assert.assertTrue(testcases,currencyPage.isCommandDisplayed(),"Command line","displayed");
		
		currencyPage.fillCurrenceyCode(currencyCode);
		
		/*Verify currency search page displayed*/
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Security Grp Access Code List","Currency search page","displayed");
		
		currencyPage.searchsecurityrange(companyId,securityGroup1);

		currencyPage.clickOnInsert();
		
		/*Insert security group access code*/
		currencyPage.insertSecurityGroupAccessCode(securityGroup1);
		currencyPage.clickOnUpdate();
		
		currencyPage.insertSecurityGroupAccessCode(securityGroup2);
		currencyPage.clickOnUpdate();
		
		currencyPage.insertSecurityGroupAccessCode(securityGroup3);
		currencyPage.clickOnUpdate();
		
		currencyPage.insertSecurityGroupAccessCode(securityGroup4);
		currencyPage.clickOnUpdate();
				
		currencyPage.clickOnCancel();
		
		verifyValues(currencyPage,securityGroup1);
		verifyValues(currencyPage,securityGroup2);
		verifyValues(currencyPage,securityGroup3);
		verifyValues(currencyPage,securityGroup4);

		
	
		currencyPage.logOut(2);
	}
	
	
	private void verifyValues(CurrencyPageNew currencyPage,List<String> securityGroup){
			
			currencyPage.searchsecurityrange(companyId,securityGroup);
			
			if(currencyPage.verifyValues(securityGroup.get(0))){
				testcases.add(getCurreentDate()+" | Pass : New user company security "+securityGroup.get(0)+ " displayed in the list");
			}
			else{
				testcases.add(getCurreentDate()+" | Fail : New user company security "+securityGroup.get(0)+ " not displayed in the list");
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
		String[] nodeID = { "A114" };
		String [] selectedNames = {"userName","passWord","currencyCode","securityGroup1","securityGroup2","securityGroup3","securityGroup4"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
