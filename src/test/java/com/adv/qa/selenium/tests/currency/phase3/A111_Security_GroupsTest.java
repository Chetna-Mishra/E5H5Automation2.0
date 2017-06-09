package com.adv.qa.selenium.tests.currency.phase3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.adv.qa.selenium.framework.Assert;
import com.adv.qa.selenium.framework.BaseTest;
import com.adv.qa.selenium.framework.pageObjects.LoginPage;
import com.adv.qa.selenium.framework.pageObjects.PageObjects;
import com.adv.qa.selenium.framework.pageObjects.currency.CurrencyPageNew;
import com.adv.qa.selenium.helpers.DataResource;
import com.adv.qa.selenium.helpers.DataRow;

/**
 * @author              :   Draxayani
 * Test Reference No	: 	A111 Security Groups 
 * Purpose              :   Security Groups
 * Date					:   Modified on 16-May-2017/Chetna
 * ACCESS               :   ADA
 */

public class A111_Security_GroupsTest extends BaseTest{
	/*Launch the browser*/
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}
	
	
	private PageObjects pObject = new PageObjects();
	

	
	@Test( dataProvider ="dp")
	public void verify(DataRow dataRow) throws InterruptedException{
		
		String userName = dataRow.get("userName");
		String passWord = dataRow.get("passWord");
		String currencyCode = dataRow.get("currencyCode");
		List<String> securityGroupIM1 = dataRow.findNamesReturnValues("securityGroupIM1");
		List<String> securityGroupIM2 = dataRow.findNamesReturnValues("securityGroupIM2");		
		List<String> securityGroupIM3 = dataRow.findNamesReturnValues("securityGroupIM3");
		List<String> securityGroupIM4 = dataRow.findNamesReturnValues("securityGroupIM4");
		List<String> securityGroupIM5 = dataRow.findNamesReturnValues("securityGroupIM5");
		List<String> securityGroupIM6 = dataRow.findNamesReturnValues("securityGroupIM6");

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
		Assert.assertEquals(testcases,currencyPage.getTableHeader(), "M"+currencyCode+" - Security Group List","Currency search page","displayed");
		
		createSecurityGroups(currencyPage,securityGroupIM1);
		currencyPage.clickOnReturnButton();
		WebElement Selection = driver.findElement(By.xpath(pObject.A040_SELE_SEC1));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", Selection);
		
		createSecurityGroups(currencyPage,securityGroupIM2);
		currencyPage.clickOnReturnButton();
		WebElement Selection1 = driver.findElement(By.xpath(pObject.A040_SELE_SEC1));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", Selection1);
		
		createSecurityGroups(currencyPage,securityGroupIM3);
		currencyPage.clickOnReturnButton();
		WebElement Selection2 = driver.findElement(By.xpath(pObject.A040_SELE_SEC1));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", Selection2);
	
		createSecurityGroups(currencyPage,securityGroupIM4);
		currencyPage.clickOnReturnButton();
		WebElement Selection3 = driver.findElement(By.xpath(pObject.A040_SELE_SEC1));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", Selection3);
		
		createSecurityGroups(currencyPage,securityGroupIM5);
		currencyPage.clickOnReturnButton();
		WebElement Selection4 = driver.findElement(By.xpath(pObject.A040_SELE_SEC1));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", Selection4);
		
		
		createSecurityGroups(currencyPage,securityGroupIM6);

		currencyPage.clickOnCancel();
		currencyPage.clickOnCancel1();
		
		currencyPage.logOut(1);
	}
	
	
	private void createSecurityGroups(CurrencyPageNew currencyPage,List<String> elements) throws InterruptedException{
		
		
		currencyPage.searchValue(elements.get(0),2,0);
		
		currencyPage.clickOnInsert1();
		
		boolean update = currencyPage.insertSecurityGroup(elements);
		
		if(update == true){
			currencyPage.clickOnUpdate();		
		}
		
		currencyPage.clickOnCancel();
		
		if(currencyPage.verifyValues(elements.get(0))){			
			testcases.add(getCurreentDate()+" | Pass : Security group "+elements.get(0)+ " displayed in the list");
		}
		else{
			testcases.add(getCurreentDate()+" | Fail : Security group "+elements.get(0)+ " displayed in the list");
		}
		
		currencyPage.clickOnDenials();
		
		int securityGroup = Integer.parseInt(elements.get(2));	
		
		for(int i=3;i<=(securityGroup+3);i++){
			amendDenials(currencyPage,elements,elements.get(i));
		}
	}
	
	public void amendDenials(CurrencyPageNew currencyPage,List<String> elements,String securityGroup){
		WebElement Selection = driver.findElement(By.xpath(pObject.A040_SELE_SEC1));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", Selection);
		
		currencyPage.searchValue(securityGroup,2,1);
		
		if(!currencyPage.verifyDenyAll()){			
			currencyPage.clickOnAmend();
			
			currencyPage.selectDenyAll();
			
			currencyPage.clickOnUpdate();
			
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
		String[] nodeID = { "A111" };
		String [] selectedNames = {"userName","passWord","currencyCode","securityGroupIM1","securityGroupIM2","securityGroupIM3","securityGroupIM4","securityGroupIM5","securityGroupIM6"};
		DataResource dataResourceSelected = new DataResource (xmlFilePath, selectedNames, true,nodeID);
		DataRow [] [] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;	
	}
}
