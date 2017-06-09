package com.adv.qa.selenium.helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


public class CalenderDateTime {
	
	
	private static final String dateFormat1 = "dd-MMM-yyyy";
	
	
	/**
<<<<<<< HEAD
	 *  Program to return Previous System Date (dd-mm-yyyy)(System DateTime- 1 year) in the Format 01-Jan-2018
	 * @return 
	 */	
	
	public String Fromdate() {
	
			DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
			
		    Calendar cal = Calendar.getInstance();
		    cal.add(Calendar.YEAR, -1);
		    
			 // Now format the date
			 String date1= dateFormat.format(cal.getTime());
			 
//			 // Print the Date
//		    System.out.println(date1);
			 
			 return date1; 
		  
	 }
	
	/**
	 *  Program to return Previous System Date (dd-mm-yyyy)(System DateTime- 1 year) in the Format 01-Jan-2018
	 * @return 
	 */	
	
	public String TOdate() {
	
			DateFormat dateFormat = new SimpleDateFormat(dateFormat1);
			
		    Calendar cal = Calendar.getInstance();
		    cal.add(Calendar.YEAR, +1);
		    
			 // Now format the date
			 String date1= dateFormat.format(cal.getTime());
			 
//			 // Print the Date
//		    System.out.println(date1);
			 
			 return date1; 
		  
	 }
	
	
	/**
	 *  Program to extract Present System Date (dd-mm-yyyy) in the Format 01-Jan-2018
	 * @return 
	 */
	public String Presentdate() {
		 
		 // Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat = new SimpleDateFormat(dateFormat1);
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateFormat.format(date);
		 
//		 // Print the Date
//		 System.out.println(date1);
		 
		 return date1; 
		 }

	
	

	/**
	 *  Program to extract present System year 2018 
	 * @return 
	 */
	
	
	public int CurrentYear() {
		

			Calendar cal= Calendar.getInstance();
		
			int year = cal.get(Calendar.YEAR);
		 
			return year;

	}	
	

	/**
	 * Program to extract present System year 2018 -1=2017
	 * @return 
	 */
	
	
	public int fromyear() {
		
			Calendar cal= Calendar.getInstance();
		
			int year = (cal.get(Calendar.YEAR)-1);
		 
	      return year;

	}
	
	/**
	 *  Program to extract present System year 2018+1=2018 
	 * @return 
	 */
	
	public int Toyear() {
		

			Calendar cal= Calendar.getInstance();
		
			int year = (cal.get(Calendar.YEAR)+1);
		 
			return year;
	      
		}
	

	/**
	 *  Program to Return Entered year, month and date in the Provided format as 01-Jan-1996
	 */
	
	
	public String calStartFromYear() {	

		
			String cal = "1996";
			return cal;

	}
	
	/**
	 *  Program to Return Entered year, month and date in the Provided format as 01-Jan-1996
	 */	
	
	
	public String calStartFromDate() {	
		
		GregorianCalendar fmt = new GregorianCalendar(1996, 0, 1);
	
		SimpleDateFormat df = new SimpleDateFormat(dateFormat1);
		String result = df.format(fmt.getTime());

//    System.out.println("fmt: " + result);
	 
		return result; 
		
	}

	
	
	public String calStartNextDate(int nextyear) {	
		
		GregorianCalendar fmt = new GregorianCalendar(nextyear, 0, 1);
	    SimpleDateFormat df = new SimpleDateFormat(dateFormat1);
	    String result = df.format(fmt.getTime());

//	    System.out.println("fmt: " + result);
		 
		 return result; 
			}

public String calEndNextDate(int nextyear) {	
		
		GregorianCalendar fmt = new GregorianCalendar(nextyear, 11, 31);
	    SimpleDateFormat df = new SimpleDateFormat(dateFormat1);
	    String result = df.format(fmt.getTime());

//	    System.out.println("fmt: " + result);
		 
		 return result; 
			}
	
	
	/**
	 *  Program to Return Entered year, month and date in the Provided format as 01-Jan-1996
	 * @return 
	 */
	

	public String calStartToDate() {	
		
			GregorianCalendar fmt = new GregorianCalendar(1996, 11, 31);
			SimpleDateFormat df = new SimpleDateFormat(dateFormat1);
			String result = df.format(fmt.getTime());

			//	System.out.println("fmt: " + result);
 
			return result; 
	
	}

	
	public static void main(String[] args) {
		
	{
		System.out.println(Calendar.getInstance().getTimeZone().getDisplayName());
	}
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.YEAR, 96);
//		
//	System.out.println("fmt: " + result);
	
=======
	 *  Program to extract System Date in the Format 01-Jan-2018
	 * @return 
	 */
	public String date() {
		 
		 // Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat = new SimpleDateFormat(dateFormat1);
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateFormat.format(date);
		 
//		 // Print the Date
//		 System.out.println(date1);
		 
		 return date1; 
		 }

	

	/**
	 *  Program to extract System year 
	 * @return 
	 */
	
	
	public int CurrentYear() {
		

			Calendar cal= Calendar.getInstance();
		
			int year = cal.get(Calendar.YEAR);
		 
			return year;

	}	
	

	/**
	 *  Program to extract System year-1 
	 * @return 
	 */
	
	
	public int fromyear() {
		
			Calendar cal= Calendar.getInstance();
		
			int year = (cal.get(Calendar.YEAR)-1);
		 
	      return year;

	}
	
	/**
	 *  Program to extract System year+11 
	 * @return 
	 */
	
	public int Toyear() {
		

			Calendar cal= Calendar.getInstance();
		
			int year = (cal.get(Calendar.YEAR)+1);
		 
			return year;
	      
		}
	

	/**
	 *  Program to Return  Entered year, month and date in the Provided format as 01-Jan-1996
	 */
	
	
	public String calStartFromYear() {	

//			Calendar cal = Calendar.getInstance();
//			cal.set(Calendar.YEAR, 1996);
		
			String cal = "1996";
			return cal;

	}
	
	
	
	public String calStartFromDate() {	
		
		GregorianCalendar fmt = new GregorianCalendar(1996, 0, 1);
	
		SimpleDateFormat df = new SimpleDateFormat(dateFormat1);
		String result = df.format(fmt.getTime());

//    System.out.println("fmt: " + result);
	 
		return result; 
		
	}

	
	public String calStartNextDate(int nextyear) {	
		
		GregorianCalendar fmt = new GregorianCalendar(nextyear, 0, 1);
	    SimpleDateFormat df = new SimpleDateFormat(dateFormat1);
	    String result = df.format(fmt.getTime());

//	    System.out.println("fmt: " + result);
		 
		 return result; 
			}

public String calEndNextDate(int nextyear) {	
		
		GregorianCalendar fmt = new GregorianCalendar(nextyear, 11, 31);
	    SimpleDateFormat df = new SimpleDateFormat(dateFormat1);
	    String result = df.format(fmt.getTime());

//	    System.out.println("fmt: " + result);
		 
		 return result; 
			}
	
	
	/**
	 *  Program to Return Entered year, month and date in the Provided format as 01-Jan-1996
	 * @return 
	 */
	

	public String calStartToDate() {	
		
			GregorianCalendar fmt = new GregorianCalendar(1996, 11, 31);
			SimpleDateFormat df = new SimpleDateFormat(dateFormat1);
			String result = df.format(fmt.getTime());

			//	System.out.println("fmt: " + result);
 
			return result; 
	
	}

	
	public static void main(String[] args) {
		
	{
		System.out.println(Calendar.getInstance().getTimeZone().getDisplayName());
	}
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.YEAR, 96);
//		
//	System.out.println("fmt: " + result);
>>>>>>> branch 'master' of https://github.com/Chetna-Mishra/E5H5Automation.git
	}

	
	
}
