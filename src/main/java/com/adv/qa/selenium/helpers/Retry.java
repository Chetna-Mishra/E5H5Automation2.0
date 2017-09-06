package com.adv.qa.selenium.helpers;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.internal.BaseTestMethod;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.adv.qa.selenium.framework.BaseTest;
import com.adv.qa.selenium.framework.pageObjects.LoginPage;
import java.lang.reflect.Method; 


public class Retry implements IRetryAnalyzer {


	
	/*
	 * Trying to tear and do the setup from base test
	 */
//	@BeforeClass
//	public void beforeClass() throws Exception {
//		BaseTest basetest = new BaseTest();
//		basetest.tearDown();
//		basetest.setUp();
//	}

	
//	Class a = Class.forName("BaseTest");
//	Object o= a.newInstance(); 
//    Method m =a.getDeclaredMethod("tearDown", null);  
    
    
//    m.setAccessible(true);  
//    m.invoke(o, null); 
	
	
	
	
		int minretryCount = 0;

	// set maxcounter value this will execute our test 3 times
		int maxretryCount = 2;

	//     override retry Method
	public boolean retry(ITestResult result){
		

	
//this will run until max count completes if test pass within this frame it will come out of for loop

		if(minretryCount<=maxretryCount)
		{
//	print the test name for log purpose   
System.out.println("Following test is failing===="+result.getName());


//print the counter value    
System.out.println("Retrying the test Count is=== "+ (minretryCount+1));



// increment counter each time by 1  

minretryCount++;

return true;

		}
		return false;
}

}
