import java.util.*;
import java.io.*;

/**
 * This program reads numbers in a file and generates sorted file
 * @author Guan Yue Wang
 * @version Neon.2 Release (4.6.2)
 * 2017-08-15
 */


public class GWangLab4
{
	
	/**
	 * Main entry point for the program
	 * @param args	hold one command line argument:  [input file location] [output file location] (ex.GWangLab4 rev50.dat rev50sorted.dat)
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
    		System.out.print("Please provide input file location (with .txt/.dat): ");
    		fileName = keyboardInput.next();
    		System.out.print("Please provide output file location (with .txt/.dat): ");
    		outputLocation = keyboardInput.next();
        }
		
		System.out.println();
		

		try 
		{
			int i = 0;
			int n =0;
			
			outputFile = outputLocation;	// get output location
			
			Scanner sizefile = new Scanner(new File(fileName));
			
			// get file size
			while (sizefile.hasNextDouble()) 
			{	// read till there's no more numbers
				double x = sizefile.nextDouble();
				n++;
			}
			
			
			// modify output file name based on output path provided
			String insertionFile = outputFile.replace(".","_InsertionSort.");	
			String heapFile = outputFile.replace(".","_HeapSort.");
			String shellFile1 = outputFile.replace(".","_ShellSort1.");
			String shellFile2 = outputFile.replace(".","_ShellSort2.");
			String shellFile3 = outputFile.replace(".","_ShellSort3.");
			String shellFile4 = outputFile.replace(".","_ShellSort4.");
			String shellFile5 = outputFile.replace(".","_ShellSort5.");

			// initiate output path for all seven sorts
			PrintWriter outputInsertion = new PrintWriter(insertionFile);
			PrintWriter outputHeap = new PrintWriter(heapFile);
			PrintWriter outputShell1 = new PrintWriter(shellFile1);
			PrintWriter outputShell2 = new PrintWriter(shellFile2);
			PrintWriter outputShell3 = new PrintWriter(shellFile3);
			PrintWriter outputShell4 = new PrintWriter(shellFile4);
			PrintWriter outputShell5 = new PrintWriter(shellFile5);
			
			Scanner infile = new Scanner(new File(fileName));

			double data[] = new double[n];
			double insertiondata[] = new double[n];
			double heapdata[] = new double[n];
			double shelldata1[] = new double[n];
			double shelldata2[] = new double[n];
			double shelldata3[] = new double[n];
			double shelldata4[] = new double[n];
			double shelldata5[] = new double[n];
			
			HeapSort heap = new HeapSort();
			ShellSort shell = new ShellSort();
			InsertionSort insertion = new InsertionSort();
			
			
			while (infile.hasNextDouble()) 
			{	// read till there's no more numbers
				double x = infile.nextDouble();
				
				//create data sets for each of the seven sorts
				heapdata[i]=x;
				insertiondata[i]=x;
				shelldata1[i]=x;
				shelldata2[i]=x;
				shelldata3[i]=x;
				shelldata4[i]=x;
				shelldata5[i]=x;
				i++;
			}
			
			//print original array
			printArray(insertiondata);
			
			System.out.println();
			
			
			//INSERTION SORT START
			
	        long startTime = System.nanoTime();
			
			insertion.sort(insertiondata);
			
			long endTime = System.nanoTime();
			
			System.out.println("Insertion Sort");
			System.out.println(sortedOutput(insertiondata));
			System.out.println("Sort Time: "+(endTime - startTime)/1000 + " microseconds");
			
	
			outputInsertion.println("Insertion Sort");
			outputInsertion.println(sortedOutput(insertiondata));
			outputInsertion.println("Sort Time:  "+(endTime - startTime)/1000 + " microseconds");
			
			outputInsertion.close();
			
			//INSERTION SORT END
			
			
			System.out.println();
			
			//HEAP SORT START
			
	        startTime = System.nanoTime();
			
			heap.sort(heapdata);
			
			endTime = System.nanoTime();
			
			System.out.println("Heap Sort");
			System.out.println(sortedOutput(heapdata));
			System.out.println("Sort Time: "+(endTime - startTime)/1000 + " microseconds");
			
	
			outputHeap.println("Heap Sort");
			outputHeap.println(sortedOutput(heapdata));
			outputHeap.println("Sort Time:  "+(endTime - startTime)/1000 + " microseconds");
			
			outputHeap.close();
			
			//HEAP SORT END
			
			
			System.out.println();
			
			//SHELL SORT1 START
			
	        startTime = System.nanoTime();
			
			shell.sort1(shelldata1);
			
			endTime = System.nanoTime();
			
			System.out.println("Shell Sort1");
			System.out.println(sortedOutput(shelldata1));
			System.out.println("Sort Time: "+(endTime - startTime)/1000 + " microseconds");
			
	
			outputShell1.println("Shell Sort1");
			outputShell1.println(sortedOutput(shelldata1));
			outputShell1.println("Sort Time:  "+(endTime - startTime)/1000 + " microseconds");
			
			outputShell1.close();
			
			//SHELL SORT1 END
			
			
			System.out.println();
			
			//SHELL SORT2 START
			
	        startTime = System.nanoTime();
			
			shell.sort2(shelldata2);
			
			endTime = System.nanoTime();
			
			System.out.println("Shell Sort2");
			System.out.println(sortedOutput(shelldata2));
			System.out.println("Sort Time: "+(endTime - startTime)/1000 + " microseconds");
			
	
			outputShell2.println("Shell Sort2");
			outputShell2.println(sortedOutput(shelldata2));
			outputShell2.println("Sort Time:  "+(endTime - startTime)/1000 + " microseconds");
			
			outputShell2.close();
			
			//SHELL SORT2 END
			
			
			System.out.println();
			
			//SHELL SORT3 START
			
	        startTime = System.nanoTime();
			
			shell.sort3(shelldata3);
			
			endTime = System.nanoTime();
			
			System.out.println("Shell Sort3");
			System.out.println(sortedOutput(shelldata3));
			System.out.println("Sort Time: "+(endTime - startTime)/1000 + " microseconds");
			
	
			outputShell3.println("Shell Sort3");
			outputShell3.println(sortedOutput(shelldata3));
			outputShell3.println("Sort Time:  "+(endTime - startTime)/1000 + " microseconds");
			
			outputShell3.close();
			
			//SHELL SORT3 END
			
			
			System.out.println();
			
			//SHELL SORT4 START
			
	        startTime = System.nanoTime();
			
			shell.sort4(shelldata4);
			
			endTime = System.nanoTime();
			
			System.out.println("Shell Sort4");
			System.out.println(sortedOutput(shelldata4));
			System.out.println("Sort Time: "+(endTime - startTime)/1000 + " microseconds");
			
	
			outputShell4.println("Shell Sort4");
			outputShell4.println(sortedOutput(shelldata4));
			outputShell4.println("Sort Time:  "+(endTime - startTime)/1000 + " microseconds");	
			outputShell4.close();
			
			//SHELL SORT4 END
			
			
			System.out.println();
			
			//SHELL SORT5 START
			
	        startTime = System.nanoTime();
			
			shell.sort5(shelldata5);
			
			endTime = System.nanoTime();
			
			System.out.println("Shell Sort5");
			System.out.println(sortedOutput(shelldata5));
			System.out.println("Sort Time: "+(endTime - startTime)/1000 + " microseconds");
			
	
			outputShell5.println("Shell Sort5");
			outputShell5.println(sortedOutput(shelldata5));
			outputShell5.println("Sort Time:  "+(endTime - startTime)/1000 + " microseconds");
			
			outputShell5.close();
			
			//SHELL SORT5 END

			
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
	static void printArray(double[] array)
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
	static String sortedOutput(double[] array)
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
	static void copyArray(double[] array, double[] arrayCopy)
	{
		
		for (int i = 0; i < array.length; i++)
		{
			arrayCopy[i] = array[i];
		}
	}

}