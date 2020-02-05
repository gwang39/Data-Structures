import java.lang.*;

/**
 * Implementation of Quick Sort (Contains both normal pivot method and medium of three pivot method)
 * Implemented based on CLRS quick sort algorithm
 * @author Guan Yue Wang
 * @version Neon.2 Release (4.6.2)
 * 2017-10-30
 */

public class Quicksort
{
	int swap = 0;	// swap count
	
    /**
     * Recursive quicksort procedure to sort the subarray using normal pivot
     * @param array The array containing the subarray to be sorted.
     * @param p Index of the beginning of the subarray.
     * @param r Index of the end of the subarray.
     */
    protected void quicksortNormal(int[] array, int p, int r)
    {
    	if (p < r) 
    	{
    		int q = partition(array, p, r);
    		quicksortNormal(array, p, q - 1);
    		quicksortNormal(array, q + 1, r);
    	}
    }
    
    /**
     * Recursive quicksort procedure to sort the subarray using medium of three partition pivot
     * @param array The array containing the subarray to be sorted.
     * @param p Index of the beginning of the subarray.
     * @param r Index of the end of the subarray.
     */
    
    protected void quicksortM3P(int[] array, int p, int r)
    {
    	if (p < r) 
    	{
    		int q = m3partition(array, p, r);
    		quicksortM3P(array, p, q - 1);
    		quicksortM3P(array, q + 1, r);
    	}
    }
    
    
    /**
     * Sorts an array of integer using normal pivot
     *
     * @param array The array of integers to be sorted.
     */
    public void sortNormal(int[] array)
    {
    	quicksortNormal(array, 0, array.length - 1); // sort using it
    }
    
    /**
     * Sorts an array of integer using medium of three pivot
     *
     * @param array The array of integers to be sorted.
     */
    
    public void sortM3P(int[] array)
    {
    	quicksortM3P(array, 0, array.length - 1); // sort using it
    }
    
    
    public int m3partition(int[]A ,int i,int j) 
    {
	    if (i < (j-1))
	    {
	    	int k = (int)Math.floor((i + j)/2);
	
	    	if (A[i] <= A[k]) 
	    	{
	
	    		if (A[k] <= A[j]) 
	    		{
	    			exchange(A,i,k);
	    		}
	
	    		else if (A[i] <= A[j]) 
	    		{
	    			exchange(A,i,j);
	    		}
	    	}
	
		    else if (A[i] > A[j]) 
		    {

				if (A[k] <= A[j]) 
				{
					exchange(A,i,j);
				}
		
				else
				{
					exchange(A,i,k);
				}
		
		    }
	    	
	    }

	    return partition(A,i,j);
	}

    
    
    public int partition(int[] array, int p, int r)
    {
	int x = array[r]; // x is the pivot
	int i = p - 1;
	
	for (int j = p; j < r; j++) 
	{

	    if (array[j] <= x)
	    {
	    	i++;
	    	exchange(array, i, j);
	    }
	}

	exchange(array, i+1, r);
	return i + 1;
    }

    /**
     * Exchanges the integers at two positions within an array.
     *
     * @param i The index of one integer
     * @param j The index of the other integer
     */
    public void exchange(int[] array, int i, int j)
    {
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
		swap++;
    }
    
    /**
     * Counts the number of swaps happened
     * @return	number of swaps
     */
    
    public int getSwapCount()
    {
    	return swap;
    }
    
    
}