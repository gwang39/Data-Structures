/**
 * This program catches ClassCastException
 * @author Guan Yue Wang
 *
 */


public class ClassCastExceptionCatch
{
    public static void main(String[] args) 
    {
    	
    	Fruit oneFruit = new Fruit();
    	
    	try
    	{
    		Apple oneAple = (Apple)oneFruit;
    	}
    	
    	catch ( ClassCastException exception)
    	{
    		System.out.print("Invalid Class Relationship Found");
    	}
    	
    	
    }
}
