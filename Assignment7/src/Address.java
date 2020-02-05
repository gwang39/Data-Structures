/**
 * This class take the address info and transform it to corresponding address string
 * 
 */

public class Address 

{
	// declare variables
	
	private String street;
	private String city;
	private String state;
	private String zip;
	
	
	// set variables based on street city state and zip
	public void setAddress ( String streetInput, String cityInput, String stateInput, String zipInput)
	{
		street = streetInput;
		city = cityInput;
		state = stateInput;
		zip = zipInput;
	
	}
	
	// return complete address string
	public String getAddress()
	{
		return  street + ", " + city + ", " + state + ", " + zip;
		
		
	}
	
	// default
	public Address()
	{
		street = "N/A";
		city = "N/A";
		state = "N/A";
		zip = "N/A";
		
		
	}
	
	
	
	
}