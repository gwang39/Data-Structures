/**
*Assignment 7
*
*This program displays all detailed information from SalariedEmployee and HourlyEmployee sub class
*
*@author Guan Yue Wang
*
*
*/

public class Assignment7Main 
{
	public static void main (String [] args)
	{
		
		// create objects using SalariedEmployee sub class

		SalariedEmployee gary = new SalariedEmployee("Guan Yue", "Wang", "27 Waterwheel Street", "Markham", "ON", "10000", 2017, 3, 12, 60000);
		
		// create objects using HourlyEmployee sub class
		
		HourlyEmployee tony = new HourlyEmployee("Tony", "Gatsby", "street 1", "city 1", "AB", "10001", 2017, 3, 13, 35, 20); // 35 hours worked
		
		HourlyEmployee alice = new HourlyEmployee("Alice", "Kim", "street 2", "city 2", "CS", "10002", 2017, 3, 14, 50, 20);  // 50 hours worked
		
		
		// display detailed information of each employee
		
		System.out.println(gary.toString());
		
		System.out.println();
		
		System.out.println(tony.toString());
		
		System.out.println();
		
		System.out.println(alice.toString());
		
		
	}
}



	
	

