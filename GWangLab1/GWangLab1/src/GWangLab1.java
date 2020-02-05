import java.util.*;
import java.io.*;

/**
 * This program reads a text file, evaluates if each string in the file falls under below language category,
 * exports the all results to another text file.
 * L1= { w: w contains equal numbers of A's and B's (in any order) and no other characters}
 * L2 = { w: w is of the form AnBn, for some n >= 0 }
 * L3 = { w: w is of the form AnB2n, for some n >= 0 }
 * L4 = { w: w is of the form (AnBm)p, for some m,n,p >= 0 }
 * L5 = { w: w is of the form AnBmC(m+n), for some m,n >= 0 }
 * L6 = { w: w is of the form AnBmCpDCpBmAn (Reverse after D), for some m,n,p >= 0 }
 * @author Guan Yue Wang
 * @version Neon.2 Release (4.6.2)
 * 2017-06-28
 */


public class GWangLab1
{
	
	/**
	 * Main entry point for the program
	 * @param args	hold one command line argument:  the input file location (ex.D:\lab1input.txt)
	 * 				(can be left blank, if so program would prompt for file location in console)
	 */
	
	public static void main(String[] args) 
	{
		String fileName;
		String outputFile;
		int choice=-1;
		OutputList myList = new OutputList();
		Scanner keyboardInput = new Scanner(System.in);
		
		// FILE INPUT
        if (args.length == 1) 
        {// check if command line argument is valid
            fileName = args[0];
            System.out.println("Input file path: " + fileName);
        }
        else
        {// if no valid command line argument found, prompt for user input to get input file location
    		System.out.print("Please provide input file location (with .txt): ");
    		fileName = keyboardInput.next();
        }
		System.out.println();
		
		// READ FILE AND EVALUATE EACH LINE
		long startTime = System.nanoTime();
		
		try 
		{	// read existing text data file
			BufferedReader input = new BufferedReader( new FileReader( fileName ) );
			
			LanguageParser myParser = new LanguageParser(); // create a new language parser object to do evaluation

			String record = null;
			
			while( ( record = input.readLine() ) != null )
			{	// read each line
			
				myParser.readLanguage(record);	// take line and feed into language parser (from my LanguageParser class)

				myParser.printTestResults();	// print results for L1-L6 evaluation in the console for this line
				
				myList.add(myParser.getTestResults());	// store results in arrayList (from my OutputList class) for Export
			}

		}
		catch (IOException exception) 
		{	// throws exception if there's no existing text data file found
			System.out.print("\nNo Input File Found. Program Terminated.");
			System.exit(1);

		}
		
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns"); 
		
		// FILE OUTPUT
		while (choice!=1 && choice!=2)
		{	// ask user whether they want to provide output location or save under the same location as input file with modified name
			System.out.print("\nFile output - Please select from below\n 1 - Provide output location "
					+ "OR 2 - Save under the same location as fileName_outputGW.txt: ");
			choice = keyboardInput.nextInt();
			System.out.println();
		}
		
		if (choice ==1)
		{	// user chooses to provide file location
			System.out.print("\nPlease enter output location (with .txt): ");
			outputFile = keyboardInput.next();
		}
		else
		{	// user chooses to use original input file location
			outputFile = fileName.replaceFirst(".txt","_outputGW.txt"); //modify output file name
		}
	
		try
		{	
			PrintWriter output = new PrintWriter(outputFile);
			for(int i =0; i <= myList.getLastIndex();i++) 
			{	//loop through all element in the arraylist
				output.println(myList.get(i)); // output each result in myList to the output file
			}
			output.close();
		}
	
		catch (FileNotFoundException outputEception) 
		{ // throws exception if output file name is invalid
			System.out.println("\nOutput Failure. Program Terminated.");
			System.exit(1);
		}
	
	System.out.println("\nOutput File Saved Under - " + outputFile);
	}	
}
