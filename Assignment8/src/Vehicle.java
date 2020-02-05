/**
 * This class contains vehicle's attributes, methods, and manipulations
 * 
 */

public class Vehicle extends Objects
{
	// declare variables
	private String name;
	private int age;
	
	
	public Vehicle (String vehicleName, int vehicleAge)
	{
		name = vehicleName;
		age = vehicleAge;
	}
	
	// set name of vehicle
	public void setName (String vehicleName)
	{
		name = vehicleName;
	}
	
	// get name of vehicle
	public String getName()
	{
		return name;
	}
	
	// set age of vehicle
	public void setAge (int vehicleAge)
	{
		age = vehicleAge;
	}
	
	// get age of vehicle
	public int getAge()
	{
		return age;
	}
	
	// default
	public Vehicle()
	{
		name = "NA";
		age = -1;
	}
	
	// draw vehicle
	public void drawObject()
	{
		System.out.println("Drawing a Vehicle");
	}
	
	// rotate vehicle
	public void rotateObject()
	{
		System.out.println("Rotating a Vehicle");		
	}
	
	// resize vehicle
	public void resizeObject()
	{
		System.out.println("Resizing a Vehicle");			
	}
	
	// play sound
	public void playSound()
	{	
		System.out.println("Vehicle sound");		
	}
	
	
}
