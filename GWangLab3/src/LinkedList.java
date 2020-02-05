/**
 * This class constructs a double linked list with header
 * Each node inside has reference to previous and next node and optional header
 * @author Guan Yue Wang
 * @version Neon.2 Release (4.6.2)
 * 2017-08-04
 */



public class LinkedList 
{
	

	private int listLength;
	private Node header;
	private Node first;
	private Node last;
	
	/**
	 * Default constructor for double linked list with header
	 */
	
	public LinkedList() 
	{
		header = null;
		first = null;
		last = null;
		listLength = 0;
	}

	
	/**
	 * Add a node to the end of the list
	 * @param data	number need to be stored in this node
	 */
	
	public void add(double data) 
	{
		
		Node node = new Node(data); // create a new node with data
		
		if (first == null) 
		{// if it's the first node
			first = node;
			first.next = last;
			first.previous = header;
		}
		else if (last == null) 
		{// if it's the last node
			last = node;
			last.previous = first;
			first.next = last;
		}
		else
		{// if it's a middle node
			last.next = node;
			node.previous = last;
			last = node;
		}
	}
	
	
	/**
	 * set row index to the header node
	 * @param rowIndex	the row index 
	 */
	public void setHeader(double rowIndex) 
	{
		Node headerNode = new Node(rowIndex);
		header = headerNode;
		header.next = first;
	}
	
	
	/**
	 * Checks if the matrix list is empty
	 * @return True if the list is empty
	 */
	
	public boolean isEmpty() 
	{
		
		if (first == null) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	

	
	/**
	 * get the length of the list 
	 * @return number represents the length of the list
	 */
	public int listLength() 
	{
		
		Node currentNode = first;
		listLength = 0;
		while (currentNode != null) 
		{
			currentNode = currentNode.next;
			listLength++;
		}
		
		return listLength;
	}
		

	/**
	 * get node value based on column index provided
	 * @param colIndex column index of the node
	 * @return number represents the data value in the node
	 */
	public double nodeValue(int colIndex)
	{
		
		Node currentNode = first;
		int i = 0;
		
		while (currentNode != null) 
		{
			
			if (colIndex == i) 
			{
				return currentNode.value();
			}
			else
				currentNode = currentNode.next;
				i++;
		}

		return 0;
	}
}

