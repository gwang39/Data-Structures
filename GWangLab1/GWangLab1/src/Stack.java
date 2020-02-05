import java.util.*;

/**
 * This class constructs a stack follows LIFO rules to store data
 * @author Guan Yue Wang
 * @version Neon.2 Release (4.6.2)
 * 2017-06-28
 */

public class Stack 
{
	private final int STACKSIZE = 80;
    private char[] items;
    private int top;
    private int size;


    /**
     * Default constructor with default stack size
     */
    
    public Stack()
    {
        this.size = STACKSIZE;
        items = new char[size];
        top = -1;
    }
    

    /**
     * Constructor with option to set up size
     * @param size	maximum number of chars the stack can hold
     */
    
    public Stack(int size)
    {
        this.size = size;
        items = new char[size];
        top = -1;
    }
    

    /**
     * Check if stack is empty
     * @return	true if empty, false other wise
     */
    
    public boolean isEmpty()
    {
        return (top == -1);
    }
    
    
    /**
     * Push a char onto the top of the stack
     * @param letter	a char to be pushed onto the top of the stack
     */

    public void push(char letter)
    {
    	
    	if (this.top == STACKSIZE-1)
    	{// check for stack overflow
    		System.out.println("Stack Overflow");
    		System.exit(1);
    	}
    	
        items[++top]=letter;
    }
    
    /**
     * Pop one item from the top of the stack
     * @return	top item (char) from the stack
     */
    
    public char pop()
    {
    	
    	if (this.isEmpty())
    	{//check for stack underflow
    		System.out.println("Stack Underflow");
    		System.exit(1);
    	}
    	
        return (items[top--]);
    }
    
    /**
     * Check the item on the top of the stack
     * @return	item (char) on the top of the stack
     */
    
    public char peek()
    {
        return (items[top]);
    }
    
    public void clear()
    {
    	while(!this.isEmpty())
    	{
    		top--;
    		
    	}
    }
    
    /**
     * print the whole stack (for testing and validation purpose)
     */
    
    public void display()
    {
    	System.out.println(Arrays.toString(items));
    }
	
}
