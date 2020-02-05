/**
 * This class constructs a generic node for linked list. 
 * Each node contains data and reference to previous and next node
 * @author Guan Yue Wang
 * @version Neon.2 Release (4.6.2)
 * 2017-08-04
 */


public class Node 
{
	
	private double data;
	Node next;	// reference to next node
	Node previous;	// reference to previous node
	
	/**
	 * Default constructor
	 */
	
	public Node() 
	{
		this.data = 0;
	}
	
	
	/**
	 * Node constructor to create node with data inside
	 * @param 	number needs to be stored in this node
	 */
	
	public Node(double data) 
	{
		this.data = data;
	}
	
	/**
	 * Get the value inside the node
	 * @return number stored in this node
	 */
	public double value()
	{
		return data;
	}
} 