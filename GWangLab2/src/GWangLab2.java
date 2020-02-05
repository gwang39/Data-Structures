import java.util.*;
import java.io.*;

/**
 * This program reads a text file, takes the matrix within and calculates determinant of each matrix
 * @author Guan Yue Wang
 * @version Neon.2 Release (4.6.2)
 * 2017-07-17
 */


public class GWangLab2
{
	
	/**
	 * Main entry point for the program
	 * @param args	hold one command line argument:  [input file location] [output file location] (ex.D:\lab2.txt)
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
		//time test
        long startTime = System.nanoTime();
		try 
		{
			outputFile = outputLocation;	// read output location
			
			PrintWriter output = new PrintWriter(outputFile);

			
			Scanner infile = new Scanner(new File(fileName));


			while (infile.hasNextDouble()) 
			{	// read till there's no more numbers
				// as file is validated so it always follows size n and then n*n matrix
				
				double size = infile.nextDouble();	// get next size number
				
				double matrix[][] = new double[(int) (size)][(int) (size)];	// set up array space to store matrix
				
				for (int i = 0; i < matrix.length;i++)
				{	// for each row
					for (int j = 0; j < matrix[i].length;j++)
					{	// for each column
					matrix[j][i] = infile.nextDouble(); // store next number in [j][i]
					}
				}
				
				// Create new Determinant Calculator for current n*n matrix
				DeterminantCalculator dc = new DeterminantCalculator(matrix,(int)(size));
				
				// Console Output
				System.out.println(dc.matrixSummary(matrix,(int)(size)));
				System.out.println();
				
				// File Output
				output.println(dc.matrixSummary(matrix,(int)(size)));
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
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns");
		
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
