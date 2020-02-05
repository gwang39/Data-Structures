//Assignment 3 Question 2
//author: Guan Yue Wang

import java.util.Scanner;

public class Assignment3Q2 
{
	public static void main (String args [])
	{
		int range;
		int userGuess = 0;
		int randomNumber;
		int i;
		String again;
		
		Scanner input = new Scanner (System.in);
		
		
		do
		{	//loop till user declines to play
			System.out.print("\n");
		
			do
			{	//loop till user enter a positive number
				
				System.out.print("You are guessing a number between 1 and N, please enter upper limit N first: ");
				range = input.nextInt();	//get user input N
			
			} while (range < 1);
			

			randomNumber = (int)(range*Math.random()) + 1;	//generate random number based on N
			
			i = 1;	//reset guess number to 1
			
			System.out.println("\nYou can guess up to 10 times");	//notify user the limit
		
			while (userGuess != randomNumber & i <= 10)		
			{	//loop till user find the number or reach the limit 10

				System.out.print("Please enter your guess # " + i + ": ");	//keep track of the guess #
				userGuess = input.nextInt();	//get user guess
				
				if (userGuess > randomNumber)	//provide hint based on user guess
				{
					System.out.println("Too High");
				}
				
				else if (userGuess < randomNumber)
				{
					System.out.println("Too Low");
				}
				else
				{
					System.out.println("Correct");
				}
				
					i++;	//count user guess
			}
		
			if (i > 10)	//give final notification based on success or failure
			{
				System.out.println("\nGame Over");
			}		
			else	
			{
				System.out.println("\nGood Job");
			}
				
			do
			{	
				System.out.print("\nDo you want to play again? (Y/N): ");
				again = input.next();	//ask user if they want to play again
				
			} while (!again.equals("Y") & !again.equals("N"));	//loop till user either enter Y or N
			
			
		} while (again.equals("Y"));	//keep playing till user declines to play
	
	}
	
}
