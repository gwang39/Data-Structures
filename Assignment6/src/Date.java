/**
 * This class take the date info and transform it to corresponding date string
 * 
 */

public class Date 

{
	// declare variables
	
	private int year;
	private int month;
	private int day;
	
	// set date based on year month and day
	public void setDate ( int y, int m, int d)
	{
		
		year = y;
		month = m;
		day = d;
	
	}
	
	// return the complete date string
	
	public String getDate()
	{
		return  year + "/" + month + "/" + day; 
		
		
	}
	
	// default 
	
	public Date ()
	{
		
		year = 0000;
		month = 00;
		day = 00;
	
	}
	
	
	
}
