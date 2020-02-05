/**
 * This class take the employee info and transform it to corresponding employee record string
 * 
 */

public class Employee
{
	// declare variables
	
	private String finalName;
	private String finalAddress = "";
	private String finalDate;
	
	
	//	
	public Employee ( String firstName, String lastName, String street, String city, String state, String zip, int y, int m, int d)
	{	
		
		setEmployee (firstName, lastName, street, city, state, zip, y, m, d);
	}
	
	
	public void setEmployee ( String firstName, String lastName, String street, String city, String state, String zip, int y, int m, int d)
	{	
		
		Name name = new Name();	// create new name object
		name.setName(firstName, lastName);	// using name object function to transform name details to name string
		
		Date date = new Date();	// create new date object
		date.setDate(y, m, d);	// using date object function to transform date details to date string
		
		Address address = new Address();
		address.setAddress(street, city, state, zip);	// using address object function to transform address details to address string
		
		
		// return info from objects and assign them to variables in this class
		
		finalName = name.getName();
		finalAddress = address.getAddress();
		finalDate = date.getDate();
	}
	
	// get employee detail string
	
	public String getEmployee()
	{
		return  "Name: " + finalName +"\nAddress: " + finalAddress + "\nHire Date: " + finalDate; 
		
		
	}
	
	// set default
	
	public Employee()	
	{
		finalName = "N/A";
		finalAddress = "N/A";
		finalDate = "0000/00/00";
		
	}
	
	
	
	
}