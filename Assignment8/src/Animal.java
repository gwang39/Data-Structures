/**
 * This class contains animal's attributes, methods, and manipulations
 * 
 */


public class Animal extends Objects
{	
	// declare variables
	private String name;

	public Animal (String animalName)
	{
		name = animalName;
	}
	
	// set name of animal
	public void setName (String animalName)
	{
		name = animalName;
	}
	
	// get name of animal
	public String getName()
	{
		return name;
	}
	
	// default
	public Animal()
	{
		name = "NA";
	}
	
	// draw animal
	public void drawObject()
	{
		System.out.println("Drawing an Animal");
	}
	
	// rotate animal
	public void rotateObject()
	{
		System.out.println("Rotating an Animal");		
	}
	
	// resize animal
	public void resizeObject()
	{
		System.out.println("Resizing an Animal");			
	}
	
	// play sound
	public void playSound()
	{	
		System.out.println("Animal sound");		
	}
	
	
}
