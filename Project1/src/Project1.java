/**
 * 605.201 Java Mini Project #1
 * 
 * This program simulates a tortoise and hare race along a horizontal course contains 50 positions. 
 *
 * @author GUAN YUE WANG
 *
 */

public class Project1 
{
	public static void main ( String [] args)
	{	
		// declare variables
		
		int harePosition = 1;
		int tortoisePosition = 1;
		int caseNum;
		int furthestPoint;
		
		// display message for the beginning 
		
		System.out.println("AND THEY'RE OFF!!");
		
		System.out.println("Hare - Position: " + harePosition);
		System.out.println("Tortoise - Position: " + tortoisePosition);
		
		
		
		while (harePosition < 50 && tortoisePosition < 50)
		{	// loop till either hare or tortoise reaches position 50
			
			System.out.println();
			
			caseNum = randomNum();	// generate a random number for this round
			
			harePosition += hareMove (caseNum);			//	change position based on random number
			harePosition = Math.max(1, harePosition);	// prevent position drops below 1
			
			tortoisePosition += tortoiseMove (caseNum);			//	change position based on random number
			tortoisePosition = Math.max(1, tortoisePosition);	// prevent position drops below 1
			
			
			furthestPoint = Math.max(harePosition, tortoisePosition);	// get the furthest position they reach
			
			
			if (harePosition == tortoisePosition)	// when both land on the same square, display 'OUCH'
			{	
				printDescription(caseNum, harePosition, tortoisePosition);	// print tracking info
				
				for ( int i = 1; i <= Math.max(50, furthestPoint); i ++)
				{	// loop based on either 50 course length or the furthest position reached to prevent failing to print position beyond 50
					if ( i == harePosition )
					{	// when reach the position both land, print 'OUCH'
						System.out.print("OUCH");
					}
					else
					{	// otherwise print space
						System.out.print(" ");
				
					}
				}	
			}
			
			else	// when they do not land on the same square, print the position of both
			{
				
				printDescription(caseNum, harePosition, tortoisePosition);	// print tracking info
				
			for ( int i = 1; i <= Math.max(50, furthestPoint); i ++)
				{	// loop based on either 50 course length or the furthest position reached to prevent failing to print position beyond 50
					if ( i == harePosition )
					{	// when loop reaches hare position, print 'H'
						System.out.print("H");
					}
					else if ( i == tortoisePosition)
					{	// when loop reaches tortoisePosition, print 'T'
						System.out.print("T");
					}
					else
					{	// otherwise print space
						System.out.print(" ");
				
					}
				}
				
			}
			
			System.out.println();
	
		}	
		
		// Display Result based one or both reaches position 50
		
		printResult (harePosition, tortoisePosition);

	}
	
	/**
	 * This method printDescription displays the race result based on position of hare and tortoise
	 * 
	 * Pre-conditions: 	integer, hPosition, is the position of hare
	 * 					integer, tPosition, is the position of tortoise
	 * 
	 * Post-conditions: nothing is returned
	 * 
	 */
	
	public static void printResult (int hPosition, int tPosition)
	{
		if (hPosition >=50 && tPosition >=50)
		{
			System.out.println("IT'S A TIE!!");
			
		}
		
		
		else if (hPosition >= 50 && tPosition < 50)
		{
			System.out.println("HARE WINS!!");
		}
		
		else if (hPosition < 50 && tPosition >= 50)
		{
			System.out.println("TORTOISE WINS!!");
		}
		
		else
		{	// prevent any potential error case
			System.out.println("Error in results.");
			
		}
		
	}
	
	
	
	/**
	 * This method printDescription displays move and position information of hare and tortoise
	 * 
	 * Pre-conditions: integer, tCase, is the random integer generated in each round
	 * 					integer, hPosition, is the position of hare
	 * 					integer, tPosition, is the position of tortoise
	 * 
	 * Post-conditions: nothing is returned
	 * 
	 */
	
	public static void printDescription (int caseNum, int hPosition, int tPosition)
	{
		System.out.println("Random number: " + caseNum);
		System.out.println("Hare - Move: " + hareMoveType (caseNum) + "\tChange: " + hareMove (caseNum) + "\tPosition: " + hPosition);
		System.out.println("Tortoise - Move: " + tortoiseMoveType (caseNum) + "\tChange: " + tortoiseMove (caseNum) + "\tPosition: " + tPosition);
		System.out.println();
	}
	
	/**
	 * This method tortoiseMove() gives tortoise's move in position based on random number generated
	 * 
	 * Pre-conditions: integer, tCase, is the random integer generated in each round
	 * 
	 * Post-conditions: An integer is returned, representing the change in position based on random number
	 * 
	 */
	
	
    public static int tortoiseMove( int tCase)
    {
    	int tMove;

        switch (tCase)	// give movement number based on case number generated
        {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5: 
            	tMove = 3;
                break;
            case 6:
            case 7:
            case 8: 
            	tMove = 1;
                break;
            case 9:
            case 10: 
            	tMove = -6;
                break;
            default: 
            	tMove = 0;
                break;
        }
        
        return tMove;
    }
    
	/**
	 * This method tortoiseMoveType() gives tortoise's move type based on random number generated
	 * 
	 * Pre-conditions: integer, tCase, is the random integer generated in each round
	 * 
	 * Post-conditions: A string is returned, representing the move type based on random number
	 * 
	 */
	
    
    public static String tortoiseMoveType( int tCase)
    {
    	String tMove;

        switch (tCase)	// give movement type based on case number generated
        {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5: 
            	tMove = "Fast plod";
                break;
            case 6:
            case 7:
            case 8: 
            	tMove = "Small plod";
                break;
            case 9:
            case 10: 
            	tMove = "Slop";
                break;
            default: 
            	tMove = "NA";
                break;
        }
        
        return tMove;
    }
    
	/**
	 * This method hareMove() gives hare's move in position based on random number generated
	 * 
	 * Pre-conditions: integer, hCase, is the random integer generated in each round
	 * 
	 * Post-conditions: An integer is returned, representing the change in position based on random number
	 * 
	 */
	
	
    
    public static int hareMove( int hCase )
    {
    	int hMove;

        switch (hCase)	// give movement number based on case number generated
        {
            case 1:
            case 2:
            	hMove = 9;
            	break;
            case 3:
            case 4:
            case 5: 
            	hMove = 1;
                break;
            case 6:
            	hMove = -12;
            case 7:
            case 8: 
            	hMove = -2;
                break;
            case 9:
            case 10: 
            	hMove = 0;
                break;
            default: 
            	hMove = 0;
                break;
        }
        
        return hMove;
    }
    
	/**
	 * This method hareMoveType() gives hare's move type based on random number generated
	 * 
	 * Pre-conditions: integer, hCase, is the random integer generated in each round
	 * 
	 * Post-conditions: A string is returned, representing the move type based on random number
	 * 
	 */
    
    public static String hareMoveType( int hCase )
    {
    	String hMoveType;

        switch (hCase)	// give movement type based on case number generated
        {
            case 1:
            case 2:
            	hMoveType = "Big hop";
            	break;
            case 3:
            case 4:
            case 5: 
            	hMoveType = "Small hop";
                break;
            case 6:
            	hMoveType = "Big slip";
            case 7:
            case 8: 
            	hMoveType = "Small slip";
                break;
            case 9:
            case 10: 
            	hMoveType = "Fall asleep";
                break;
            default: 
            	hMoveType = "NA";
                break;
        }
        
        return hMoveType;
    }
	
	/**
	 * This method randomNum() generates a random integer between 1 and 10
	 * 
	 * Pre-conditions: N/A
	 * 
	 * Post-conditions: An integer, from 1 - 10, is returned, representing the random number generated
	 * 
	 */
    
	
	public static int randomNum()
	{
		
		return (int) ( 10 * Math.random() ) + 1;
		
	}
	
	
}
