import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * This program reads text file with numbers, takes each number and add into double array implementation, and output results to a text file with step by step trail
 * @author Guan Yue Wang
 * @version Neon.2 Release (4.6.2)
 * 2017-10-02
 */

public class GWangPA1 
{
	/**
	 * Main entry point for the program
	 * @param args	hold two command line argument:  [input file location] [output file location] (ex.PA1input.txt PA1output.txt)
	 * 				(can be left blank, if so program would prompt for file location in console)
	 */
	
	public static void main(String[] args) 
	{

		Implementation doubleArray = new Implementation();
		
		
		String fileName;
		String outputFile;
		String outputLocation;
		Scanner keyboardInput = new Scanner(System.in);
		
		// GET FILE LOCATION
	    if (args.length == 2) 
	    {// check if command line argument is valid
	        fileName = args[0];
	        System.out.println("Input file path: " + fileName);
	        outputLocation = args[1];
	    }
	    else
	    {// if no valid command line arguments found, prompt for user input to get input and output files location
	    	System.out.println("Invalid I/O file locations.");
			System.out.print("Please provide input file location (with .txt): ");
			fileName = keyboardInput.next();
			System.out.print("Please provide output file location (with .txt): ");
			outputLocation = keyboardInput.next();
	    }
	    
	    
		try 
		{
			outputFile = outputLocation;	// read output location
			
			PrintWriter output = new PrintWriter(outputFile);
			Scanner infile = new Scanner(new File(fileName));
			int num;
	
			
			long startTime = System.nanoTime();
			
			while (infile.hasNextInt()) 
			{	// read till there's no more numbers
				
				num = infile.nextInt();
				
				System.out.println("Adding " + num);
				output.println("Adding " + num);
				
				doubleArray.add( num);	// add number to double array
				
				//output in console and output txt file
				
				System.out.println(doubleArray.toString());
				output.println(doubleArray.toString());
				output.println();
			}
			
			// time tracker
			long endTime = System.nanoTime();
			
			System.out.println("Program Run Time: "+(endTime - startTime)/1000 + " microseconds");
			output.println("Program Run Time: "+(endTime - startTime)/1000 + " microseconds");
			
			System.out.println();
			
			int choice = 0;
			int value;
			
			// allow user to do more add and search 
			while (choice !=4)
			{
				System.out.println("Please select if you want to do anything else:");
				System.out.println("1 - add a number\t\t2 - search for a number\t\t3 - print current double array\t\t4 - Exit");
	
				
				choice = keyboardInput.nextInt();
				if (choice == 1)
				{// add new number into double array
					System.out.println("Please enter the value you want to add: ");
					value = keyboardInput.nextInt();
					System.out.println("Adding " + value);
					doubleArray.add(value);	
					System.out.println(doubleArray.toString());
					output.println(doubleArray.toString());
					output.println();
				}
				
				else if (choice == 2)
				{// search for new number in double array
					System.out.println("Please enter the value you want to search: ");
					
					value = keyboardInput.nextInt();
					doubleArray.search(value);
				}
				
				else if (choice == 3)
				{// print current double array
					System.out.println(doubleArray.toString());
				}
				
				else if (choice == 4)
				{// exit
					break;
				}
				
				else
				{
					System.out.println("Invalid choice. Please select again.");
					
				}
				
			}
				
			output.close();
			System.out.println("\nOutput File Saved Under - " + outputFile);
		}
		catch (IOException exception) 
		{	// throws exception if there's no existing I/O text data file found
			System.out.print("\nInvalid I/O. Program Terminated.");
			System.exit(1);
	
		}

	}

}

