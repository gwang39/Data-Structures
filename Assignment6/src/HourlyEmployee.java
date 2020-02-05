/**
 * This class is the sub class of Employee class and includes pay info of hourly paid employee
 * 
 */


public class HourlyEmployee extends Employee
{
	private double weeklyHour;
	private double hourlyRate;
	private double earning;
	
	
	// set variables using Employee class plus assign value to weekly hour, hourly rate
	
	public HourlyEmployee ( String firstName, String lastName, String street, String city, String state, 
								String zip, int y, int m, int d, double actualHour, double actualRate)
	{
		super (firstName, lastName, street, city, state, zip, y, m, d);
		
		weeklyHour = actualHour;
		
		hourlyRate = actualRate;

	}
	
	// set weekly hour worked
	
	public void setWeeklyHour(double actualHour)
	{
		
		weeklyHour = actualHour;
		
	}
	
	// get weekly hour worked
	
	public double getWeeklyHour()
	{
		return weeklyHour;
		
	}
	
	// set hourly rate
	

	public void setHourlyRate(double actualRate)
	{
		
		hourlyRate = actualRate;
		
		
	}
	
	// get hourly rate
	
	public double getHourlyRate()
	{
		return hourlyRate;
		
	}
	
	
	
	// return earning based weekly hour and hourly rate
	
	public double getEarning()
	
	{
		if (weeklyHour > 40)
		{
			earning = (40 * hourlyRate + (weeklyHour - 40) * (hourlyRate * 1.5));
			
		}
		
		else
		{
			earning = (weeklyHour * hourlyRate);
		}
			
		
		return earning;
		
	}
	
	// return all information from Employee plus pay information as String

	public String toString()
	{
		
		if (weeklyHour > 40)
		{
			
			return super.getEmployee() + "\nWeekly Hours Worked: " + weeklyHour + "\nHourly Rate before 40 hrs: " + hourlyRate
					+ "\nHourly Rate after 40 hrs: " + (hourlyRate*1.5) + "\nWeekly Earning: " + getEarning();
			
			
		}
		
		else
		{
			
			return super.getEmployee() + "\nWeekly Hours Worked: " + weeklyHour + "\nHourly Rate: " + hourlyRate + "\nWeekly Earning: " + getEarning();
			
			
		}
		

	}
	
	// default
	public HourlyEmployee ()
		{
			super ();

			weeklyHour = 0;
			hourlyRate = 0;
			earning = 0;
			

		}
	
	
	
}
