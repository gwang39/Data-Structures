/**
 * Assignment10 PartB
 * @author Guan Yue Wang
 * This program takes modified data and produces final report
 */


import java.io.*;
import java.util.Scanner;

public class Assignment10PartB {

	public static void main(String[] args) throws IOException
	{
		
		// get file path
		
		Scanner keyboardInput = new Scanner( System.in );
		System.out.println( "Enter the input file path (with file.txt): " );
		String inputFile = keyboardInput.next();
		
		File f = new File( inputFile );

		
		//D:\java_workplace\Assignment10\ModifiedData.txt
				

		BufferedReader input = new BufferedReader( new FileReader( f ) );

		// create array to store data
		
		String state[] = new String[13486];
		String population[] = new String[13486];
		String child[] = new String[13486];
		String poorChild[] = new String[13486];
		
		String record = null;
		
		int i = 0;
		
		// read the store records
		
		while( ( record = input.readLine() ) != null )
		{
			state[i] = ( record.substring(0,2));
			population[i] = ( record.substring(3,11).trim());
			child[i] = ( record.substring(12,18).trim());
			poorChild[i] = ( record.substring(19,24).trim());
			i++;
			
		}
		
		input.close();
		
		// generate report
		
		float populationSum=Integer.parseInt(population[0]);
		float childSum=Integer.parseInt(child[0]);
		float poorChildSum=Integer.parseInt(poorChild[0]);
		
		
		System.out.println("\nFile: " + inputFile);
		
		System.out.println();
		
		System.out.printf("%5S%15S%20S%30S%15S","State","Population","Child Population",
							"Child Poverty Population","% Child Poverty");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------");
		
		
		for (int j=0;j<(state.length);j++)
		{
			if (j<state.length-1)
			{

				if (state[j+1].equals(state[j]))
				{
					populationSum += (Integer.parseInt(population[j+1]));
					childSum += (Integer.parseInt(child[j+1]));
					poorChildSum += (Integer.parseInt(poorChild[j+1]));
				}
				else
				{	
					float poorRatio = poorChildSum/childSum*100;
					System.out.printf("%5S%,15.0f%,20.0f%,30.0f%15.2f",state[j],populationSum,childSum,poorChildSum,poorRatio);
					System.out.println();
					populationSum = Integer.parseInt(population[j+1]);
					childSum = (Integer.parseInt(child[j+1]));
					poorChildSum = (Integer.parseInt(poorChild[j+1]));
				}
			}
			
			else
			{
				float poorRatio = poorChildSum/childSum*100;
				System.out.printf("%5S%,15.0f%,20.0f%,30.0f%15.2f",state[j],populationSum,childSum,poorChildSum,poorRatio);
				System.out.println();
			}
			
		}

	}

}
