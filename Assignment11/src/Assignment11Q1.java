/**
 * This program use tree map to simulate a contact list with result input/output from/to local text file
 * 
 * @author Guan Yue Wang
 * 
 */

import java.io.*;
import java.util.*;

public class Assignment11Q1
{
public static void main( String [] args ) throws IOException
	{
	
	// create contact list Tree map
	
	TreeMap< String, String > contactList = new TreeMap< String, String>();
	
	
	//file location - D:\java_workplace\Assignment11\ContactList.txt
	
	// get file location and set up file reader
	Scanner keyboardInput = new Scanner( System.in );
	System.out.println();
	System.out.println( "Enter the input file path (with file.txt): " );
	String inputFile = keyboardInput.next();
	File f = new File( inputFile );
	

	
	int count = 0;
	String name="";
	String contact="";

	BufferedReader input = new BufferedReader( new FileReader( f ) );

	
	// read current contact list and put into tree map
	
	Scanner record = new Scanner(new File(inputFile));
    while (record.hasNextLine()) 
    {
        Scanner word = new Scanner(record.nextLine());
        while (word.hasNext()) 
        {
            String s = word.next();
        	count ++;
        	switch (count)
        	{
        	case 1:
        	name = s;
        	break;
        	case 2:
        	contact = s;
        	break;
        		
        	}
        
        }
        contactList.put(name,contact);	// put into contact list map
        //reset for next record
        count = 0;
        name = "";
        contact = "";
    }
	
	input.close();
	
	
	int choice = -1;
	
	while (choice != 4)
	{	// loop makes user add, remove, display contact and quit
		System.out.print("\nPlease select: 1 - Add a contact, 2 - Delete a contact, 3 - Display all contact, 4 - Save all and close: ");
		choice = keyboardInput.nextInt();
		System.out.println();
		switch (choice)
		{
		case 1:	// add a contact
			
			String fNameNew = "";
			String lNameNew = "";
			String phoneNew = "";
			String emailNew = "";
			String fullNameNew = "";
			String contactNew ="";
			System.out.println("Please enter first name: ");
			fNameNew = keyboardInput.next();
			System.out.println("Please enter last name: ");
			lNameNew = keyboardInput.next();
			System.out.println("Please enter phone number: ");
			phoneNew = keyboardInput.next();
			System.out.println("Please enter email: ");
			emailNew = keyboardInput.next();
			
			fullNameNew = lNameNew + "," + fNameNew;
			contactNew = phoneNew + "|"+emailNew;
			contactList.put(fullNameNew,contactNew);
		
			break;
				
		case 2:	// remove a contact
			String fNameRemove = "";
			String lNameRemove = "";
			String fullNameRemove = "";
			System.out.println("Please enter first name: ");
			fNameNew = keyboardInput.next();
			System.out.println("Please enter last name: ");
			lNameNew = keyboardInput.next();

			
			fullNameRemove = lNameRemove + "," + fNameRemove;
			contactList.remove(fullNameRemove);
			
			break;
		
		case 3:	// display contact list
	
			System.out.println("Contact:");
			for ( Map.Entry product : contactList.entrySet() )
				System.out.println( product.getKey() + " " + product.getValue() );
			break;
			
		case 4:	// output results
			
			PrintWriter output = new PrintWriter(inputFile);
			
			for ( Map.Entry product : contactList.entrySet() )
				output.println( product.getKey() + " " + product.getValue() );	
				output.close();
				System.out.print("Contact list is now saved under location: " + inputFile);
			break;
		
			
		default:	// invalid vase
			System.out.println("Invalid Choice");
			break;
		}
		
		
	}
	}

}
