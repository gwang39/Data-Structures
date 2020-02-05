/**
 * This program use linked list to simulate printing queues
 * 
 * @author Guan Yue Wang
 *
 */


import java.util.*;
import java.util.Random;



public class Assignment11Q2 {

	
	public static void main(String[] args) 
	{
		
		// declare variables
		int randomNumber;
		int printTime;
		int jobNumber = 0;
		int choice = 1;
		
		Scanner input = new Scanner (System.in);
		
		// create linked list
		LinkedList <String>jobs = new LinkedList<String>();
		Random rnGenerator = new Random( 100 );
		
		while (choice !=2)
		{// loop asks user add job or quit
			System.out.println("Please select: 1 - Add a job OR 2 - Quit: ");
			choice = input.nextInt();	// get user choice
			
			switch (choice)
			{
			case 1:	// add a new job and random print time
				jobNumber ++;
				printTime =  rnGenerator.nextInt( 1000 ) + 10;
				jobs.add( "ID: " + jobNumber + "\tPrint Time: " + printTime);
				System.out.println("New queue added - ID " + jobNumber);
				break;
			case 2:	//output all current queues and print time
				System.out.println("In Queue:");
				for (int i = 0; i < jobs.size(); i++)
				{
					System.out.println(jobs.get(i));
				}
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}

	}	

}
