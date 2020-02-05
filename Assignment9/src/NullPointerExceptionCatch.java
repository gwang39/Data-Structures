/**
 * This program catches NullPointerException
 * @author Guan Yue Wang
 *
 */

public class NullPointerExceptionCatch
{
    private String name;

    public void print() {
        toString(name);
    }

    private void toString(String s) 
    {
        System.out.println(s + s.length());
    }

    public static void main(String[] args) 
    {
    	NullPointerExceptionThrown example = new NullPointerExceptionThrown();
        try
        {
        	example.print();
        }
    	catch(NullPointerException exception)
        {
    		System.out.print("Invalid Pointer Found");
        }
    }
}


