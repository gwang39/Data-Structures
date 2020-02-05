//Assignment 3 Question 1
//author: Guan Yue Wang

import java.util.Scanner;

public class Assignment3Q1 
{
	public static void main ( String args [] )
	{
		// declare variable asterisks maximum number and pattern choice
		int aster_num;
		int pattern;
		
		//User Input
		Scanner input = new Scanner (System.in);
		System.out.print("\n");		
		System.out.print("Please enter the maximum number of asterisks:¡¡");	
		aster_num = input.nextInt();	//get max asterisks number
		
		
		do
		{
		
			System.out.print("Please choose display pattern (1-increase/2-decrease): ");
			pattern = input.nextInt();		//get display pattern
			
		} while (pattern != 1 & pattern !=2);		// loop till user enter one of the display patterns
			
		System.out.println();
		
			
		if (pattern == 1)
		{	//nested loop to display in increasing pattern
			for (int i = 1; i <= aster_num; i++)
			{
				for (int j = 1; j<= i; j++)
				{	
					System.out.print("*");
				}
				System.out.println();
			}
		}
		
		else
		{	//nested loop to display in decreasing pattern
			for (int i = aster_num; i > 0; i--)
			{
				for (int j = i; j > 0; j--)
				{	
					System.out.print("*");
				}
				System.out.println();
			}			
				
		}	
		
	}
	
}
