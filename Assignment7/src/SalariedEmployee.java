/**
 * This class is the sub class of Employee class and includes pay info of salaried employee
 * 
 */

public class SalariedEmployee extends Employee
{
	private double annualSalary;
	
	
	// set variables using Employee class plus assign value to annual salary
	
	public SalariedEmployee ( String firstName, String lastName, String street, String city, String state, 
								String zip, int y, int m, int d, double yearlyRate)
	{
		super (firstName, lastName, street, city, state, zip, y, m, d);
		
		annualSalary = yearlyRate;

	}
	
	
	// set annual salary
	
	public void setAnnualSalary (double yearlyRate)
	
	{
		annualSalary = yearlyRate;
		
		
	}
	
	// return annual salary
	
	public double getAnnualSalary ()
	{
		return annualSalary;
		
	}
	
	// return all information from Employee plus pay information as String
	
	public String toString()
	{
		
		return super.getEmployee() + "\nAnnual Salary: " + annualSalary; 
		
	}
	
	// default
	
	public SalariedEmployee ()
		{
			super ();

			annualSalary = 0;

		}
	
	
	
}
