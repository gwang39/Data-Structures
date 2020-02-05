import java.util.*;

/**
 * This class constructs an arraylist to store data which can increase its size whenever it reaches its maximum
 * @author Guan Yue Wang
 * @version Neon.2 Release (4.6.2)
 * 2017-06-28
 */

public class OutputList 
{
    private int n = 0;
    private static final int DEFAULTSIZE = 20;
    private String resultsList[];

    /**
     * Constructor with default array size
     */
    
    public OutputList() 
    {
        resultsList = new String[DEFAULTSIZE];
    }

    /**
     * Add one String to the arraylist
     * @param oneResult	String to be added to the end of the arraylist
     */
    
    public void add(String oneResult) 
    {
        if (n == resultsList.length) 
        {//check if array list is at maximum
            increaseSize();
        }
        resultsList[n++] = oneResult;
    }
    
    /**
     * Double the size of the array
     */

    private void increaseSize() 
    {
        int nDouble = resultsList.length * 2;
        resultsList = Arrays.copyOf(resultsList, nDouble);
    }

    /**
     * Get item (String) from the arraylist
     * @param i	index of the element to be extracted
     * @return	String at index i in the arraylist
     */
    
    public String get(int i) 
    {
        if (i>= resultsList.length || i <0) 
        {
            throw new IndexOutOfBoundsException();
        }
        return resultsList[i];
    }
    /**
     * Get the index of the last element in the arraylist
     * @return	index of the last element in the arraylist
     */
    
    public int getLastIndex() 
    {
    	int count=-1;
    	
        for (int i=0;i<resultsList.length;i++)
        {
        	if (this.get(i)!=null)
        	{
        		count++;
        	}
        }
        
        return count;
        
    }

    

}
