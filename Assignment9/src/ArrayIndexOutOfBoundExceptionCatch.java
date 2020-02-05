/**
 * This program catches ArrayIndexOutOfBoundException
 * @author Guan Yue Wang
 *
 */

public class ArrayIndexOutOfBoundExceptionCatch
{
    public static void main(String[] args) 
    {
    	int[] numberList = { 0,1,2,3,4,5,6,7,8,9};
    	
    	try
    	{
    		System.out.print(numberList[10]);
    	}
    	catch(ArrayIndexOutOfBoundsException exception)
    	{
    		System.out.print("Invalid Array Index Found");
    	}
    	
    }
}
