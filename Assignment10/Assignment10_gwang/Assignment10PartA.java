/**
 * Assignment10 PartA
 * @author Guan Yue Wang
 * This program modify the raw data and output the modified file
 */

import java.io.*;
import java.util.Scanner;


public class Assignment10PartA 
{

	public static void main(String[] args) throws IOException
	{	
		
		// get input and output file path
		
		Scanner keyboardInput = new Scanner( System.in );
		System.out.println( "Enter the input file path (with file.txt): " );
		String inputFile = keyboardInput.next();
		File f = new File( inputFile );
		
		System.out.println( "Enter the output file path (with .txt): " );
		String outputFile = keyboardInput.next();
		File o = new File( outputFile );
		
		
		
		//D:\java_workplace\Assignment10\SmallAreaIncomePovertyEstData.txt
		
		//D:\java_workplace\Assignment10\ModifiedData.txt
		
		

		BufferedReader input = new BufferedReader( new FileReader( f ) );
		
		PrintWriter output = new PrintWriter( outputFile);
		
		// read each line and output required info to output file
		
		String record = null;
		while( ( record = input.readLine() ) != null )
		{
			output.print( record.substring(0,2));
			output.print( record.substring(82,90));
			output.print( record.substring(92,99));
			output.print( record.substring(101,108));
			output.println();
			
		}
		
		input.close();
		output.close();
	}

}
