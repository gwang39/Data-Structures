/**
 * Assignment4 Question2
 * This program displays yearly calendar based on month and year input by user
 * 
 * @author: Guan Yue Wang
 * 
 */



import java.util.Scanner;


public class Assignment4Q2
{	
	
	public static void main (String [] args)
	{	
		
		Scanner input = new Scanner (System.in);
		
		System.out.print("Please enter the year (e.g. 2016): ");
		
		int y = input.nextInt();		// get year
		
		System.out.println();

		printYearCalendar (y);			// display yearly calendar based on user input
		
	}
	
	/****
	 * 	The method printYearCalendar() displays the calendar for a specific year 
	 *
	 *	Pre-Conditions: The year value, y, is the full year (e.g., 2012)	
	 *                  
	 *	Post-Conditions: nothing is returned (but calendar info is displayed)
	 *
	 ****/
	
	
	public static void printYearCalendar (int y)
	{
		
		for (int m = 1; m <= 12; m++)	// for each of the month in a year
		{
			printMonthCalendar( m, y);	// display the monthly calendar
			System.out.println("\n");
			
		}
		
		
	}
	
	/****
	 * 	The method printMonthCalendar() displays the calendar for a specific month 
	 * 	based on given month and year
	 *
	 *	Pre-Conditions: The month value, m,  is 1-12
	 *					The year value, y, is the full year (e.g., 2012)
	 *                  
	 *	Post-Conditions: nothing is returned (but calendar info is displayed)
	 *
	 ****/
	
	
	public static void printMonthCalendar (int m, int y)
	{
		printMonthHeader (m, y);		// print calendar month header based on given month and year
		printMonthBody (m, y);			// print calendar month body based on given month and year

	}
	
	/****
	 * 	The method printMonthHeader() displays header information for a calendar
	 * 	based on given month and year
	 *
	 *	Pre-Conditions: The month value, m,  is 1-12
	 *					The year value, y, is the full year (e.g., 2012)
	 *                  
	 *	Post-Conditions: nothing is returned (but header is displayed)
	 *
	 ****/
	
	public static void printMonthHeader(int m, int y)
	{
		
		System.out.println("\t\t   " + getMonthName(m) + "    " + y);		// month header
		System.out.println("-----------------------------------------------------");
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");			// week day header
		
		
	}
	
	
	/****
	 * 	The method printMonthBody() displays the days in the calendar associated 
	 *	with the corresponding days of the week for a calendar
	 * 	based on given month and year
	 *
	 *	Pre-Conditions: The month value, m,  is 1-12
	 *					The year value, y, is the full year (e.g., 2012)
	 *                  
	 *	Post-Conditions: nothing is returned (but calendar body is displayed)
	 *
	 ****/
	
	public static void printMonthBody (int m, int y)
	{
		
		int calendarSpace = 1;	//set start point to 1 on the calendar
		
		int days = getNumDaysInMonth (m , y);	//get the total day in the month
		
		int startDay = getStartDay (m, 1, y);	//get the start position
		
		if (startDay != 7)	//if the start point is not Sunday, push the output point
			
			for (int j = 1; j <= startDay; j++)	// push the output point to start position
			
			{
				System.out.print("\t");
				calendarSpace++;
			
			}
	
		for ( int i = 1; i <= days; i++)	//run a loop based on total day of the month
		{
			
			System.out.print(i + "\t");
			
			if (calendarSpace % 7 == 0)		// whenever it reaches the 7th position, change line
				System.out.println();			
		
			calendarSpace++;				// count the position in the calendar
			
		}
	
	}
	
	/****
	 * 	The method getMonthName() transforms the month number to month string name
	 *
	 *	Pre-Conditions: The month value, m,  is 1-12
	 *                  
	 *	Post-Conditions: A string is returned, representing the corresponding month name
	 *
	 ****/
	
	
	public static String getMonthName (int m)
	{
		
		String month = "";
		
		switch (m)	//matches the month number to the corresponding string
		{
		case 1:
			month = "January";
			break;
		case 2:
			month = "February";
			break;
		case 3:
			month = "March";
			break;
		case 4:
			month = "April";
			break;
		case 5:
			month = "May";
			break;
		case 6:
			month = "June";
			break;
		case 7:
			month = "July";
			break;
		case 8:
			month = "August";
			break;
		case 9:
			month = "September";
			break;
		case 10:
			month = "October";
			break;
		case 11:
			month = "November";
			break;
		case 12:
			month = "December";
			break;
		}	
		
		return month;
		
	}
	
	
	
	/****
	* 	The method getStartDay() implements Zeller"s Algorithm for determining the day of the
	* 	week the first day of a month is. The method adjusts Zeller"s numbering scheme
	* 	for day of week ( 0=Saturday, ..., 6=Friday ) to conform to a day of week number
	* 	that corresponds to ISO conventions (i.e., 1=Monday, ..., 7=Sunday)
	*  
	* 	Pre-Conditions: The month value, m,  is 1-12
	*				 	The day value, d, is 1-31, or 1-28, 1-29 for February
	*					The year value, y, is the full year (e.g., 2012)
	*                  
	* 	Post-Conditions: A value of 1-7 is returned, representing the first day of the month
 	*					1 = Monday, ..., 7 = Sunday
	****/
	
	public static int getStartDay( int m, int d, int y )
	{
		// Adjust month number & year to fit Zeller"s numbering system
		if (m < 3) 
		{
			m = m + 12;
			y = y - 1;
		}
	        
		int k = y % 100;      // Calculate year within century
		int j = y / 100;      // Calculate century term
		int h = 0;            // Day number of first day in month "m"
	        
		h = ( d + ( 13 * ( m + 1 ) / 5 ) + k + ( k / 4 ) + ( j / 4 ) + ( 5 * j ) ) % 7;
	        
		// Convert Zeller"s value to ISO value (1 = Mon, ... , 7 = Sun )
		int dayNum = ( ( h + 5 ) % 7 ) + 1;
		return dayNum;

	}
	
	/****
	 * 	The method getNumDaysInMonth() gives the number of days in a month 
	 * 	based on given month and year
	 *
	 *	Pre-Conditions: The month value, m,  is 1-12
	 *					The year value, y, is the full year (e.g., 2012)
	 *                  
	 *	Post-Conditions: A value of 28 - 31 is returned, 
	 *					representing the number of days in the month
	 *
	 ****/
	
	public static int getNumDaysInMonth( int m, int y)
	{
		int days = 0;
		
		switch(m)	//determines the number of days based on months
		{
		 case 1:
         case 3:
         case 5:
         case 7:
         case 8:
         case 10:
         case 12:
             days = 31;
             break;
         case 4:
         case 6:
         case 9:
         case 11:
             days = 30;
             break;
         case 2:
             if (isLeapYear(y))	//check if it is a February in a leap year
                 days = 29;
             else
                 days = 28;
             break;
		}
		
		return days;
		
	}
	
	/****
	 * 	The method isLeapYear() determines if a given year is a leap year or not.
	 *	A typical leap year would be divisible by 4 and not 100, or divisible by 400
	 *
	 *	Pre-Conditions: The year value, y, is the full year (e.g., 2012)
	 *                  
	 *	Post-Conditions: A value of True or False is returned, 
	 *					representing it is a leap year or not 
	 *
	 ****/
	
	public static boolean isLeapYear(int y)
	{
		return ((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0); // check the leap year condition
	}
	

}
