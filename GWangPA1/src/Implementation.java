import java.util.*;

/**
 * This class constructs a double array implementation to store values
 * @author Guan Yue Wang
 * @version Neon.2 Release (4.6.2)
 * 2017-10-02
 */


public class Implementation 
{
	
	int n = 0;
	int longer[];
	int shorter[];
	
	/**
	 * Default constructor
	 */
	public Implementation() 
	{
		longer = new int[0];
		shorter = new int[1];
	}
	
	/**
	 * Merge short and longer into new longer array
	 * @param longArray		longer array needs to be merged
	 * @param shortArray	shorter array needs to be merged
	 * @param newLongArray	new longer array after the merge
	 */
	public void mergeArrays(int longArray[], int shortArray[], int newLongArray[]) 
	{

		int i = 0;
		int j = 0;
		int k = 0;
	
		while (i < longArray.length && j < shortArray.length) 
		{// finish transfer one of the array
	
			if (longArray[i] < shortArray[j])
			{// if longer array has smaller value
				newLongArray[k++] = longArray[i++];
			}
	
			else
			{// if shorter array has smaller value
				newLongArray[k++] = shortArray[j++];
			}
		
		}
		
		// transfer whichever array that's left
	
		while (i < longArray.length)
		{
			newLongArray[k++] = longArray[i++];
		}
	

		while (j < shortArray.length)
		{
			newLongArray[k++] = shortArray[j++];
		}

	}

	/**
	 * Merge longer and shorter array and reallocate shorter array when shorter array reaches limit
	 */
	public void increaseSize() 
	{
	
		int newLonger[] = new int[longer.length + shorter.length];
	
		mergeArrays(longer, shorter, newLonger);
	
		shorter = new int[(int)Math.sqrt(newLonger.length)];
	
		longer = newLonger;
	
		n = 0;

	}

	/**
	 * Add element into double array
	 * @param num	integer to be added into double array
	 */
	public void add(int num) 
	{

		if(n == shorter.length) 
		{// if shorter array reaches limit
			increaseSize();	//merge longer and shorter array and reallocate shorter array
		}
	
		int i=n-1;
	
		while(i >= 0 && num < shorter[i]) 
		{
			shorter[i+1] = shorter[i];
			i--;
		}

		shorter[i+1] = num;
	
		n++;
	}
	
	/**
	 * Seach element in the double array
	 * @param num	interger to be searched in the double array
	 */

	public void search(int num) 
	{
		int index = Arrays.binarySearch(longer, num);	// search longer array
	
		if(index >= 0) 
		{
			System.out.println("Number " + num + " found in longer array at index position: " + index);
			return;
		}
	
		index = Arrays.binarySearch(shorter, 0, n, num);	// search shorter array
	
		if(index >= 0) 
		{
			System.out.println("Number " + num + " found in shorter array at index posotion: " + index);
			return;
		}
		System.out.println("Number " + num + " cannot be found");
		return;
	}
	
	/**
	 * return summary string that gives current state of double array
	 */

	public String toString() 
	{
		String currentState = "";
		currentState = "Longer Array: " + Arrays.toString(longer)+ "\r\nShorter Array: " + Arrays.toString(shorter) + "\r\n";
		return currentState;

	}

}
