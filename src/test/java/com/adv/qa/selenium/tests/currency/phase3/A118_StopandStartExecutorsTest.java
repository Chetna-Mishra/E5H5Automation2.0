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
 * @author : Chetna Test Reference No : A11 Simplified Security Date :
 *         02-June-2017 ACCESS : AQD (As per Paul) To ensure the fail doesn't
 *         happen again I think you'll need to add a test, after A117, to log
 *         out of the system log back in (not resume) and stop and start the
 *         executors.
 * 
 */

public class A118_StopandStartExecutorsTest extends BaseTest {
	/* Launch the browser */
	@BeforeClass
	public void beforeClass() throws Exception {
		super.setUp();
	}

	@Test(dataProvider = "dp")
	public void verify(DataRow dataRow) throws InterruptedException {
		String userName = dataRow.get("userName");
		String passWord = dataRow.get("passWord");
		String currencyCode = dataRow.get("currencyCode");
		List<String> processZY1 = dataRow.findNamesReturnValues("processZY1");
		List<String> processAF5 = dataRow.findNamesReturnValues("processAF5");

		/* Log in to application */
		LoginPage loginPage = new LoginPage(driver);

		Assert.assertTrue(testcases, loginPage.isLoginPageDisplayed(), "Login page", "displayed");

		loginPage.logIn(userName, passWord);

		/* Navigate to currency page Home page e5 application */
		CurrencyPageNew currencyPage = new CurrencyPageNew(driver);

		/* Verify command line */
		Assert.assertTrue(testcases, currencyPage.isCommandDisplayed(), "Command line", "displayed");

		currencyPage.fillCurrenceyCode(currencyCode);

		/* Verify currency search page displayed */
		Assert.assertEquals(testcases, currencyPage.getTableHeader(), "M" + currencyCode + " - Region List",
				"Currency searchpage", "displayed");

		currencyPage.startAndStopDispatcher();

		currencyPage.clickOnCancel();

		/* Verify command line */
		Assert.assertTrue(testcases, currencyPage.isCommandDisplayed(), "Command line", "displayed");

		submitProcess(currencyPage, processZY1, 0);
		submitProcess(currencyPage, processAF5, 0);

		currencyPage.logOut(1);
	}

	public void submitProcess(CurrencyPageNew currencyPage, List<String> processList, int i)
			throws InterruptedException {
		boolean value = false;

		currencyPage.fillCurrenceyCode(processList.get(0));

		currencyPage.enterAboutsubmitDetails1();

		String statBefore = currencyPage.getProcessDetails(processList.get(2), processList.get(1));

		Assert.assertEquals(testcases, statBefore, "2", "Precess has", "entered task list");

		if (statBefore.equals("2")) {
			currencyPage.updateProcess(processList.get(2), processList.get(1));
		}

		String statAfter = currencyPage.getProcessDetails(processList.get(2), processList.get(1));

		if (statAfter == null || statAfter.equals("3")) {
			value = true;
		}
		Assert.assertTrue(testcases, value, "Precess " + processList.get(2),
				" performed on request" + processList.get(1));

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		super.tearDown();
	}

	@DataProvider
	public Object[][] dp() {
		String folder = "src/test/resources/";
		String xmlFilePath = folder + "phase3.xml";
		String[] nodeID = { "A118" };
		String[] selectedNames = { "userName", "passWord", "currencyCode", "processZY1", "processAF5" };
		DataResource dataResourceSelected = new DataResource(xmlFilePath, selectedNames, true, nodeID);
		DataRow[][] rows = dataResourceSelected.getDataRows4DataProvider();
		return rows;
	}
}
