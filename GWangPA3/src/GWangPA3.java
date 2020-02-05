import java.util.*;

/**
 * This program checks if s is an interleaving of x and y
 * @author Guan Yue Wang
 * @version Neon.2 Release (4.6.2)
 * 2017-12-06
 */


public class GWangPA3 
{
	int checkCount = 0;

	public static void main(String[] args) 
	{
		
		String s,x,y,xPrime,yPrime;
		
		Scanner input = new Scanner(System.in);
		
		//User Input
		
		System.out.println("\nThis program checks if s is an interleaving of x and y.");
		
		System.out.println("\nPlease enter s: ");
		
		s= input.next();

		
		System.out.println("\nPlease enter x: ");
		
		x = input.next();
		
		xPrime = getPrimeString(x,s.length());	// get repeated x' so its length equals to s
		
		System.out.println("\nPlease enter y: ");
		
		y = input.next();
		
		yPrime = getPrimeString(y,s.length());	// get repeated y' so its length equals to s
		
		System.out.println("\ns, x, y: "+s+" "+x+" "+y);
		
		if (isInterleaveAllCases(xPrime,yPrime,s) == true)
		{// if satisfied case if found
			System.out.println("\n"+ s +" is an interleaving of " + x + " and " + y);
			System.out.println("\nCases checked for each combination: " + checkCount(xPrime,yPrime) );
		}
		else
		{
			System.out.println("\n"+ s +" is NOT an interleaving of " + x + " and " + y);
		}
			
		
	}
	
	 /**
	  * This method repeats string x till certain length
	  * @param x		string to be repeated
	  * @param length	expected length after repeating string
	  * @return			repeated string at expected length
	  */
	 public static String getPrimeString (String x, int length)
	 {
		 while (x.length()<length)
		 {
			 x+=x;
		 }
		 return x.substring(0, length);
	 }

	 
	 /**
	  * This method checks if s is an interleaving of x and y using dynamic programming
	  * @param x	string x in the validation if s is an interleaving of x and y
	  * @param y	string y in the validation if s is an interleaving of x and y
	  * @param s	string s in the validation if s is an interleaving of x and y
	  * @return		true if s is an interleaving of x and y
	  */
	 public static boolean isInterleave(String x, String y, String s) 
	 {
		 int checkCount =0;
		 
		 boolean T[][] = new boolean[x.length() + 1][y.length() + 1];
		 
		 for (int i = 0; i <= x.length(); i++) 
		 {
			 for (int j = 0; j <= y.length(); j++) 
			 {
				 if (i == 0 && j == 0) 
				 {
					 T[i][j] = true;
				 } 
				 
				 else if (i == 0) 
				 {
					 T[i][j] = T[i][j - 1] && y.charAt(j - 1) == s.charAt(i + j - 1);
				 } 
				 
				 else if (j == 0) 
				 {
					 T[i][j] = T[i - 1][j] && x.charAt(i - 1) == s.charAt(i + j - 1);
				 } 
				 
				 else 
				 {
					 T[i][j] = (T[i - 1][j] && x.charAt(i - 1) == s.charAt(i + j - 1)) || (T[i][j - 1] && y.charAt(j - 1) == s.charAt(i + j - 1));
				 }
			 }
		 }
		 return T[x.length()][y.length()];
	}
	 
	 
	 /**
	  * This method runs isInterleave method against all combinations of substrings of x and y
	  * @param x	string x in the validation if s is an interleaving of x and y
	  * @param y	string y in the validation if s is an interleaving of x and y
	  * @param s	string s in the validation if s is an interleaving of x and y
	  * @return		true if s is an interleaving of x and y for any combinations of substrings of x and y
	  */
	 public static boolean isInterleaveAllCases(String x, String y, String s) 
	 {
		 int n = s.length();
		 
		 for (int i = 0; i <= n; i++)
		 { 
			 if (isInterleave(x.substring(0,i),y.substring(0,n-i),s) == true)
			 {
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 /**
	  * This method counts check happened for each isInterleave validation
	  * @param x	string x in the validation if s is an interleaving of x and y
	  * @param y	string x in the validation if s is an interleaving of x and y
	  * @return		count of checks for each isInterleave validation
	  */
	 public static int checkCount(String x, String y) 
	 {
		 int checkCount = 0;

			 for (int i = 0; i <= x.length(); i++) 
			 {
				 for (int j = 0; j <= y.length(); j++) 
				 {
					checkCount++;
				 }
			 }
		 return checkCount;
	 }
	    
}




	 
	 
	 

	            	 
