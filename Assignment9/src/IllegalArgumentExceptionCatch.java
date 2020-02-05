/**
 * This program throws IllegalArgumentException
 * @author Guan Yue Wang
 *
 */

public class IllegalArgumentExceptionCatch 
{

	public static void main(String[] args) 
	{
		try
		{
			Character.toChars(-1);
		}
		
		catch (IllegalArgumentException exception)
		{
			System.out.println("Invalid Arguement Found.");
		}
			
	}

}
