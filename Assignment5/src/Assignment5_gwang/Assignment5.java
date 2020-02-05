/**
 * Assignment5
 * 
 * This program can convert English to Morse code and Morse code to English
 * 
 * @author: Guan Yue Wang
 * 
 */


import java.util.Scanner;


public class Assignment5 
{
	public static void main ( String [] args )
	{
		//declare variables for user choice, originals, and results
		int choice = 0;
		String englishOriginal;
		String englishResult;
		String morseOriginal;
		String morseResult;
		
		
		Scanner input = new Scanner (System.in);
		
		while (choice !=3)	// loop till user enter 3 to quit
			
		{
			System.out.println("Please enter 1 -> convert English to Morse code, 2 -> convert Morse code to English, 3 -> quit: ");
			choice = input.nextInt();	// get uesr choice
			System.out.println();
			
			switch (choice)
		    {
	        case 1:     // Convert English to Morse code
	                    System.out.println( "Please enter English: " );
	                    
	                    input.nextLine();	// consume rest of the line after input.nextint()
	                 
	                    englishOriginal = input.nextLine(); // get the English sentence user wants to convert
	                    
	                    morseResult = englishToMorse (englishOriginal);	// convert user input using method and read result
	                    
	                    System.out.println( "\nThe converted Morse code is: " + morseResult + "\n" );	// output
	                    
	                    break;
	                    
	        case 2:     // Convert Morse code to English
                		System.out.println( "Please enter Morse code (each code separated by space and each word separated by '|'): " );
                		
	                    input.nextLine();	// consume rest of the line after input.nextint()
	                    
                		morseOriginal = input.nextLine();	// get the Morse code user wants to convert
                		
                		englishResult = morseToEnglish (morseOriginal);	// convert user input using method and read result
                		
                		System.out.println( "\nThe converted English is: " + englishResult +"\n");	//output
                		
	                    break;
	                    
	        case 3:     // End Program
	                    System.out.println( "Thanks for using this program!" );
	                    break;
	                    
	        default:    // Invalid User Input
	                    System.out.println( "Invalid input: please enter 1, 2, or 3" );           
		    }		
			
		}
		

	}		
	
	/****
	 * 	The method morseToEnglish() converts Morse code to English
	 *
	 *	Pre-Conditions: The String value, morseSentence, is the Morse code needs to be converted
	 *					each code separated by space and each word separated by '|'
	 *					e.x. A5
	 *                  
	 *	Post-Conditions: A string is returned, representing the converted English
	 *					e.x. .- .....
	 *
	 ****/
	
	
	public static String morseToEnglish ( String morseSentence)
	{	
		
		//build 2 array, one for English Letter and one for corresponding Morse code
		
		char [] englishLetter = 	{
									'A', 'B', 'C', 'D', 'E', 'F', 'G', 
									'H', 'I', 'J', 'K', 'L', 'M', 'N', 
									'O', 'P', 'Q', 'R', 'S', 'T', 'U', 
									'V', 'W', 'X', 'Y', 'Z', '1', '2', 
									'3', '4', '5', '6', '7', '8', '9', 
									'0'
									};

		String [] morseCode =	{ 
								".-" , "-..." , "-.-." , "-.." , "." ,
								"..-." , "--." , "...." , ".." , ".---" ,
								"-.-" , ".-.." , "--" , "-." , "---" ,
								".--." , "--.-" ,  ".-." , "..." , "-" ,
								"..-" , "...-" , ".--" , "-..-" , "-.--" , 
								"--..", ".----", "..---", "...--", "....-",
								".....", "-....", "--...", "---..", "----.",
								"-----"
								};
		
		String [] morseSegment = morseSentence.split(" ");	//create a new array to store splited Morse code segments
		String englishResult = "";	//declare string to store converted results
		
		for (int i = 0; i < morseSegment.length; i++)
		{	//loop through each splitted words in the array
			
			if (morseSegment[i].equals("|"))	//if the segment is "|"
				{
					englishResult += " ";	// convert it to space
				
				}
			
			else
			{
				for (int j = 0; j< morseCode.length; j++)
				{	// loop through morseCode array to find the one matching current morse code segment
					if (morseSegment[i].equals(morseCode[j]))	//if the matching one is found
						{
							englishResult += englishLetter[j];	//take the corresponding one in English letter array based on index
						}
				}	
			}
		}
		
		return englishResult;
	
	}
	
	/****
	 * 	The method englishToMorse() converts English to Morse code
	 *
	 *	Pre-Conditions: The String value, englishSentence, is the English sentence needs to be converted
	 *					e.x. .- .....
	 *                  
	 *	Post-Conditions: A string is returned, representing the converted Morse code
	 *					e.x. A5
	 *
	 ****/
	
	
	public static String englishToMorse ( String englishSentence)
	{	
		
		//build 2 array, one for English Letter and one for corresponding Morse code
		
		char [] englishLetter = 	{
									'A', 'B', 'C', 'D', 'E', 'F', 'G', 
									'H', 'I', 'J', 'K', 'L', 'M', 'N', 
									'O', 'P', 'Q', 'R', 'S', 'T', 'U', 
									'V', 'W', 'X', 'Y', 'Z', '1', '2', 
									'3', '4', '5', '6', '7', '8', '9', 
									'0'
									};

		String [] morseCode =	{ 
								".-" , "-..." , "-.-." , "-.." , "." ,
								"..-." , "--." , "...." , ".." , ".---" ,
								"-.-" , ".-.." , "--" , "-." , "---" ,
								".--." , "--.-" ,  ".-." , "..." , "-" ,
								"..-" , "...-" , ".--" , "-..-" , "-.--" , 
								"--..", ".----", "..---", "...--", "....-",
								".....", "-....", "--...", "---..", "----.",
								"-----"
								};
		
		englishSentence = englishSentence.toUpperCase();	//convert all letter to upper case for comparison later
		
		
		String morseResult = "";	//declare String to store result
		
		for ( int i = 0; i < englishSentence.length(); i++)
		{	// loop through all letters in the English sentence user input
			if (englishSentence.charAt(i) == ' ')
			{	// if it is a space, add "|" to result String
				morseResult += "|" +" ";
			}
			
			else
			{
				
				for (int j =0; j < englishLetter.length; j++)
				{	// take the current letter and compare with each one in the English Letter array
					
					if (englishSentence.charAt(i) == englishLetter[j]) // if the matching one is found
					{
						morseResult += morseCode[j] +" ";	// take the corresponding one in the morseCode based on index
					
					}
				}
			}
	
		}
		
		return morseResult;	
	}
	
}
