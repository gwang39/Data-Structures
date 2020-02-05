/**
*Assignment 6
*
*This program allow users input 2 employee information and then display them together
*
*@author Guan Yue Wang
*
*
*/

import java.util.Scanner;


public class Assignment6Main 
{
//	public static void main (String [] args)
	{
		
		// Declare variables
		
		String firstName;
		String lastName;
		String street;
		String city;
		String state;
		String zip;
		int year;
		int month;
		int day;
		
		
		String [] employeeRecords = new String [2];	// create array to store employee info
		
		
		Employee e1 = new Employee();	// create object for the first employee
		Employee e2 = new Employee();	// create object for the second employee
		
		int count = 1;
		
		
		Scanner input = new Scanner(System.in);
		
		//	give user brief info about what program does
		
		System.out.println("This program allows you to enter record for "+ employeeRecords.length +" employees");
		System.out.println();
		
		// User input
		
		for ( int i = 0; i < employeeRecords.length; i ++)
		{	//loop based on array length to ask questions for each records in array
			
			// loop till user input the valid name section
			
			do
			{
				
				System.out.println("Please enter the first name for employee " + count);			
				
				firstName = input.nextLine();
				
				System.out.println("Please enter the last name for employee " + count);			
				
				lastName = input.nextLine();
				
				if (firstName == "" || lastName == "")	// validation check
				{
					//	error message
					System.out.println ("ERROR: one or more fields are empty, please enter again.");
					
				}
				
				
			} while (firstName == "" || lastName == "");
			
			// loop till user input the valid address section
			
				do
				{
					
					System.out.println("Please enter street name for employee" + count);			
					
					street = input.nextLine();
					
					System.out.println("Please enter city name for employee" + count);			
					
					city = input.nextLine();
					
					System.out.println("Please enter state for employee" + count + " (2 characters)");			
					
					state = input.nextLine();
					
					System.out.println("Please enter zip code for employee " + count + " (5 digits)");			
					
					zip = input.nextLine();
					
					if (street == "" || city == "" || state == "" || zip == "" || state.length()!=2 || zip.length()!=5)
					{	// validation check and error message
						
						System.out.println ("ERROR: one or more fields has invalid input, please enter again.");
						
					}
					
					
				} while (street == "" || city == "" || state == "" || zip == "" || state.length()!=2 || zip.length()!=5);
				
				
				
				do
				{	// loop till user enter the valid hire day info
					
					System.out.println("Please enter hire year for employee " + count);			
					
					year = input.nextInt();
					
					System.out.println("Please enter hire month for employee " + count);			
					
					month = input.nextInt();
					
					System.out.println("Please enter hire day for employee " + count);			
					
					day = input.nextInt();
					input.nextLine();
					
					if ( day > 31 || day < 1 || month < 1 || month > 12 || year > 2020 || year < 1900)
					{	// validation check and error message
						
						System.out.println ("ERROR: one or more fields are empty, please enter again.");
						
					}
					
					
				} while ( day > 31 || day < 1 || month < 1 || month > 12 || year > 2020 || year < 1900);
			

			
			switch (count)	// use object function to transform user input to appropriate output
			{
			case 1:
				e1.setEmployee (firstName, lastName, street, city, state, zip, year, month, day);
				employeeRecords[i] = e1.getEmployee();	// store result into array

				break;
				
			case 2:
				e2.setEmployee (firstName, lastName, street, city, state, zip, year, month, day);
				employeeRecords[i] = e2.getEmployee();	// store result into array
				break;
			
			}		
			
			System.out.println();
			
			count ++;
			
		}
		
		//Output
		
		for ( int j = 0; j < employeeRecords.length; j ++)
		{	// loop through array and print the content
			System.out.println("Employee" + (j+1));
			
			System.out.print(employeeRecords[j]);
			
			System.out.println();
		}
		
	}
	
}



	
	

