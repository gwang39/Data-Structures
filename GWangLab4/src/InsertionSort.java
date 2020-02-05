import java.util.*;

/**
 *	This class implements insertion sort based on open source code
 * 
 * 	@author Guan Yue Wang
 * 	@version Neon.2 Release (4.6.2)
 * 	2017-08-16
 * 
 *	Citation:
 *  Title: <Insertion Sort>
 *  Author: <javacodex>
 *  Source: HeapSort.java
 *  Date: <2017.08.15>
 *  Availability: <http://www.javacodex.com/Sorting/Insertion-Sort>
 *
 */

public class InsertionSort 
{
 
	public void sort(double[] array) 
	{
		double tmp;
		for (int i = 1; i < array.length; i++) 
		{
			for(int j = i ; j > 0 ; j--) 
			{
				if(array[j] < array[j-1]) 
				{
					tmp = array[j];
					array[j] = array[j-1];
					array[j-1] = tmp;
				}
			}
		}
	}
}