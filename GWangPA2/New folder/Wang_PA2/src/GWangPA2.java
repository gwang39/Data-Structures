import java.util.*;
import java.io.*;

/**
 * This program reads numbers in a data file, sorts the numbers, and generates two sorted file (one for normal pivot and one for medium of three pivot)
 * @author Guan Yue Wang
 * @version Neon.2 Release (4.6.2)
 * 2017-10-30
 */


public class GWangPA2
{
	
	/**
	 * Main entry point for the program
	 * @param args	hold one command line argument:  [input file location] [output file location] (ex.GWangPA2 ran100data.txt ran100output.txt)
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
    		System.out.print("Please provide input file location (with .txt/.dat): ");	// ex. ran100data.txt
    		fileName = keyboardInput.next();
    		System.out.print("Please provide output file location (with .txt/.dat): ");	// ex. ran100output.txt
    		outputLocation = keyboardInput.next();
        }
		
		System.out.println();
		

		try 
		{
			int i = 0;
			int n =0;
			
			outputFile = outputLocation;	// get output location
			
			Scanner sizefile = new Scanner(new File(fileName));
			
			// get data size in input file
			while (sizefile.hasNextInt()) 
			{	// read till there's no more numbers
				int x = sizefile.nextInt();
				n++;
			}
			
			
			// modify output file name based on output path provided
			String normalFile = outputFile.replace(".","_NormalPivot.");	
			String m3pFile = outputFile.replace(".","_MediumOf3Pivot.");


			// initiate output path for both sorts
			PrintWriter outputNormal = new PrintWriter(normalFile);
			PrintWriter outputM3P = new PrintWriter(m3pFile);

			
			Scanner infile = new Scanner(new File(fileName));

			int data1[] = new int[n];
			int data2[] = new int[n];
			
			Quicksort qs1 = new Quicksort();
			
			while (infile.hasNextInt()) 
			{	// read till there's no more numbers
				int x = infile.nextInt();
				
				//create data sets for each of quick sorts
				data1[i]=x;
				data2[i]=x;
				i++;
			}
			
			//print original array
			printArray(data1);
			
			System.out.println();
			
			
			//Quick Sort With Notmal Pivot

			qs1.sortNormal(data1);
			
			System.out.println("Quick Sort - Normal Pivot");
			System.out.println(sortedOutput(data1));
			System.out.println();
			System.out.println("Exchanges: "+ qs1.getSwapCount());
		
	
			outputNormal.println("Quick Sort - Normal Pivot");
			outputNormal.println(sortedOutput(data1));
			outputNormal.println();
			outputNormal.println("Exchanges: "+ qs1.getSwapCount());
			
			outputNormal.close();
			
			//Normal Pivot Quick Sort  END
			
			Quicksort qs2 = new Quicksort();
			
			System.out.println();
			
			//print original array
			
			printArray(data2);
			
			System.out.println();
			
			
			//Quick Sort With Medium of Three Pivot
			
			qs2.sortM3P(data2);
			
			
			System.out.println("Quick Sort - Medium of Three Pivot");
			System.out.println(sortedOutput(data2));
			System.out.println();
			System.out.println("Exchanges: "+ qs2.getSwapCount());
			
			
			outputM3P.println("Quick Sort - Medium of Three Pivot");
			outputM3P.println(sortedOutput(data2));
			outputM3P.println();
			outputM3P.println("Exchanges: "+ qs2.getSwapCount());
			
			outputM3P.close();
			
			System.out.println();
			
		}
		
		catch (IOException exception) 
		{	// throws exception if there's no existing I/O text data file found
			System.out.print("\nInvalid I/O. Program Terminated.");
			System.exit(1);
		}
	
	}	
	
	
	/**
	 * This method prints all elements in the array
	 * @param array		array to be printed
	 */
	static void printArray(int[] array)
	{
		for(int i=0; i< array.length; i++)
		{
			   System.out.print(array[i] +" ");
		}
		System.out.println();
	}
	
	
	/**
	 * This method gives string includes all elements in the array
	 * @param array		array with elements to be added to the string
	 * @return			String contains all elements in the array
	 */
	static String sortedOutput(int[] array)
	{
		String summary = "";
		for(int i=0; i< array.length; i++)
		{
			   summary += array[i] +" ";
		}
		return summary;
	}
	
	/**
	 * This method copies one array to another
	 * @param array			original array we want to copy
	 * @param arrayCopy		new array with copied elements
	 */
	static void copyArray(int[] array, int[] arrayCopy)
	{
		
		for (int i = 0; i < array.length; i++)
		{
			arrayCopy[i] = array[i];
		}
	}

}