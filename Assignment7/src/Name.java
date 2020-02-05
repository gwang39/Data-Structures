/**
 * This class take the employee first and last name and transform them to corresponding employee name string
 * 
 */

public class Name 

{
	// declare variables
	private String firstName;
	private String lastName;
	
	
	// set variables based on first name and last name
	public void setName ( String firstN, String lastN)
	{
		firstName = firstN;
		lastName = lastN;
	
	}
	
	// return complete name
	public String getName()
	{
		return  firstName + " " + lastName; 
		
		
	}
	// default
	public Name()
	{
		firstName = "N/A";
		lastName = "N/A";
		
		
	}
	
	
	
	
}