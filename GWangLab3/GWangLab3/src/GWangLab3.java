import java.util.*;
import java.io.*;

/**
 * This program reads matrices with a text file, calculates determinant of each matrix, and output the determinant to another text file
 * @author Guan Yue Wang
 * @version Neon.2 Release (4.6.2)
 * 2017-08-04
 */


public class GWangLab3
{
	
	/**
	 * Main entry point for the program
	 * @param args	hold one command line argument:  [input file location] [output file location] (ex.D:\lab3input.txt)
	 * 				(can be left blank, if so program would prompt for file location in console)
	 */
	
	public static void main(String[] args) 
	{

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
        

        
        // VALIDATION
		
		inputValidation(fileName);	// Check if matrix size and matrix format make sense
		
		System.out.println();
		
		// DATA INPUT
		

		LinkedList rowList;
		LinkedList[] matrixList;
		String calculationSummary ="";
		
		//time test
        //long startTime = System.nanoTime();
		
		try 
		{
			outputFile = outputLocation;	// read output location
			
			PrintWriter output = new PrintWriter(outputFile);
			Scanner infile = new Scanner(new File(fileName));

			while (infile.hasNextDouble()) 
			{	// read till there's no more numbers
				// as file is validated so it always follows size n and then n*n matrix
				
				double size = infile.nextDouble();	// get next size number
				
				int n = (int) size;
				
				matrixList = new LinkedList[(int)size];	// create a list to store matrix based on matrix dimension
				
				
				for (int i = 0; i < n;i++)
				{	// for each row
					
					rowList = new LinkedList();	// initiate a new list for row
					rowList.setHeader(i);	// create header for row number
					
					for (int j = 0; j < n;j++)
					{	// for each column
						rowList.add(infile.nextDouble()); // store next column value in current row
					}
					
					matrixList[i] = rowList;	// store the row list to the matrix
				}
				
				// Create new Determinant Calculator
				
				DeterminantCalculator calculator = new DeterminantCalculator();
				
				// run determinant calculation and store result
				
				calculationSummary = calculator.matrixSummary(matrixList);
				
				// Console Output
				System.out.println(calculationSummary);

				// File Output
				output.println(calculationSummary);
				output.println();

			}
			output.close();
			System.out.println("\nOutput File Saved Under - " + outputFile);
		}
		catch (IOException exception) 
		{	// throws exception if there's no existing I/O text data file found
			System.out.print("\nInvalid I/O. Program Terminated.");
			System.exit(1);

		}
		
		// time test
		//long endTime = System.nanoTime();
		//System.out.println("Took "+(endTime - startTime) + " ns");
		
	}	
	
	/**
	 * This method validate if input file follows correct size n + n*n matrix format
	 * @param inputFile	location of the text file to be validated
	 */
	
	public static void inputValidation (String inputFile)
	{
		try 
		{	// read existing text data file
			
			Scanner infile = new Scanner(new File(inputFile));
			int size;
			
			while (infile.hasNextLine()) 
			{	// read each line
				String sizeLine = infile.nextLine();
				String[] sizeN = sizeLine.split(" ");	// store items in each line in a array
				size = Integer.parseInt(sizeN[0]);	//get the first item and treat as size of matrix
				
				if (size<=0 || sizeN.length!=1)
				{	// if size number is not valid or size line contains multiple elements, exit program
					System.out.println("Invalid Size Found In File. Program Terminated");
					System.exit(1);
				}

				for (int i = 0; i<size;i++)
				{ // create for loop based on size to read matrix
					if (infile.hasNextLine())
					{	// if there's next line
						String line = infile.nextLine();	// get next line
						String[] element = line.split(" ");		// store all elements in an array
						if (element.length!=size)
						{	// check if column length is the same as matrix size
							System.out.println("Invalid Matrix Found In File. Program Terminated");
							System.exit(1);
						}
					}
					
					else
					{	// exit loop if it's the end of file
						break;
					}
				}				


			}

		}
		catch (IOException exception) 
		{	// throws exception if there's no existing text data file found
			System.out.print("\nInvalid Input. Program Terminated.");
			System.exit(1);
		}
		
	}

}
