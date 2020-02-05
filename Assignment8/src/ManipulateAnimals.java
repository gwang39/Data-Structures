/**
*Assignment 8
*
*This program implements multiple actions to manipulate a collection of objects (i.e. 2 animals and 2 vehicles)
*
*@author Guan Yue Wang
*
*
*/


public class ManipulateAnimals
{
	public static void main (String [] args)
	{
		// create objects and store in array
		Objects [] collection = {new Animal(), new Animal(), new Vehicle(), new Vehicle()};
		
		// loop through the array and manipulate each object
		for( int i = 0; i < collection.length; i++ )
		{
			collection[ i ].drawObject();	// draw object
			collection[ i ].rotateObject();	// rotate object
			collection[ i ].resizeObject();	// resize object
			collection[ i ].playSound();	// play object's sound
			System.out.println();
		}
		
	}

}
