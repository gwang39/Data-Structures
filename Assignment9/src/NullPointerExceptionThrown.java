/**
 * This program throws NullPointerException
 * @author Guan Yue Wang
 *
 */

public class NullPointerExceptionThrown
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

        example.print();


    }
}


