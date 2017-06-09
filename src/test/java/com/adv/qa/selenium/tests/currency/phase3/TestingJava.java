package com.adv.qa.selenium.tests.currency.phase3;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import com.adv.qa.selenium.framework.BaseTest;

public class TestingJava extends BaseTest{

	private static final String dateFormat1 = "dd-MMM-yyyy";
	public static void main(String[] args) throws ScriptException {
		
			 // Create object of SimpleDateFormat class and decide the format
			 DateFormat dateFormat = new SimpleDateFormat(dateFormat1);
					
				    Calendar cal = Calendar.getInstance();
				    cal.add(Calendar.YEAR, +1);
				    
					 // Now format the date
					 String date1= dateFormat.format(cal.getTime());
					 
					 // Print the Date
				    System.out.println(date1);

}
}