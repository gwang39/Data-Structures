/**
 * This class constructs a language parser to evaluate if language falls under each language category
 * L1= { w: w contains equal numbers of A's and B's (in any order) and no other characters}
 * L2 = { w: w is of the form AnBn, for some n >= 0 }
 * L3 = { w: w is of the form AnB2n, for some n >= 0 }
 * L4 = { w: w is of the form (AnBm)p, for some m,n,p >= 0 }
 * L5 = { w: w is of the form AnBmC(m+n), for some m,n >= 0 }
 * L6 = { w: w is of the form AnBmCpDCpBmAn (Reverse after D), for some m,n,p >= 0 }
 * @author Guan Yue Wang
 * @version Neon.2 Release (4.6.2)
 * 2017-06-28
 */


public class LanguageParser 
{
	private boolean l1Result, l2Result, l3Result, l4Result, l5Result,l6Result;
	private String language,languageOriginal;
	
	char temp;
	
	/**
	 * Default constructor
	 */
	public LanguageParser()
	{
		this.languageOriginal="";
		this.language="";
		// default result to true in case of empty String
		l1Result = true;
		l2Result = true;
		l3Result = true;
		l4Result = true;
		l5Result = true;
	}
	
	/**
	 * Language parser constructor that takes String to be evaluated
	 * @param language String to be evaluated by the class
	 */
	public LanguageParser(String language)
	{
		this.languageOriginal = language;
		this.language = language.toUpperCase();	// avoid case sensitive issue
		// default result to true in case of empty String
		l1Result = true;
		l2Result = true;
		l3Result = true;
		l4Result = true;
		l6Result = true;
	}
	
	/**
	 * Read and set the String that needs to be evaluated
	 * @param language String to be evaluated by the class
	 */
	
	public void readLanguage(String language)
	{

		this.languageOriginal = language;
		this.language = language.toUpperCase();
		// default result to true in case of empty String
		l1Result = true;
		l2Result = true;
		l3Result = true;
		l4Result = true;
		l5Result = true;
		l6Result = true;
	}
	
	/**
	 * Check if language fall under L1 language category
	 * L1= { w: w contains equal numbers of A's and B's (in any order) and no other characters}
	 * @return	true if language is under L1, false otherwise
	 */
	public boolean language1Test()
	{
	    Stack stackA = new Stack();
	    Stack stackB = new Stack();

        l1Result = true; // default result to true in case of empty String
        
        for(char temp : language.toCharArray())
        {//read each char in the String
        	if(temp == 'A')
            {//push A to stackA
            	stackA.push(temp);
            }
            else if(temp == 'B')
            {//push B to stackB
            	stackB.push(temp);
            }
            else
            {//early exit point if program encounters unrecognized letter
            	l1Result = false;
            	return l1Result;
            }
		}

        while(!stackA.isEmpty() && !stackB.isEmpty())
        {// pop both stackA and stackB at the same time till one is empty
        	stackA.pop();
        	stackB.pop();
        }
        
        if(!stackA.isEmpty() || !stackB.isEmpty())
        {// check if both stacks are empty
        	l1Result = false;	//false if condition is not met, language not under L1
        }
        
        return l1Result;
	}

	/**
	 * Check if language fall under L2 language category
	 * L2 = { w: w is of the form AnBn, for some n > 0 }
	 * @return	true if language is under L2, false otherwise
	 */
	
	public boolean language2Test()
	{
	    Stack stackA = new Stack();
	    Stack stackB = new Stack();

        l2Result = true; // default result to true in case of empty String
        
        for(char temp : language.toCharArray())
        {//read each char in the String
        	if(temp == 'A')
            {
        		if (stackB.isEmpty())
        		{// push A to StackA is there's no B letter taken yet
        			stackA.push(temp);
        		}
        		else
        		{// early exit point if there's A after B in the String
        			l2Result = false;
        			return l2Result;
        		}
            }
            else if(temp == 'B')
            {//push B to stackB
            	stackB.push(temp);
            }
            else
            {// early exit point if unrecognized letter encountered
            	l2Result = false;
            	return l2Result;
            }
		}

        while(!stackA.isEmpty() && !stackB.isEmpty())
        {// pop both stacks till one becomes empty
        	stackA.pop();
        	stackB.pop();
        }
        
        if(!stackA.isEmpty() || !stackB.isEmpty())
        {// check if both stacks are empty
        	l2Result = false;	//return false if condition not met, language not under L2
        }
        
        return l2Result;
	}
	
	/**
	 * Check if language fall under L3 language category
	 * L3 = { w: w is of the form AnB2n, for some n > 0 }
	 * @return	true if language is under L3, false otherwise
	 */

	public boolean language3Test()
	{//read each char in the String
	    Stack stackA = new Stack();
	    Stack stackB = new Stack();

        l3Result = true; // default result to true in case of empty String
        
        for(char temp : language.toCharArray())
        {//read each char in the String
        	if(temp == 'A')
            {
        		if (stackB.isEmpty())
        		{// push A to StackA is there's no B letter taken yet
        			stackA.push(temp);
        		}
        		else
        		{// early exit point if there's A after B in the String
        			l3Result = false;
        			return l3Result;
        		}
            }
            else if(temp == 'B')
            {// push B to stackB
            	stackB.push(temp);
            }
            else
            {// early exit point if unrecognized letter encountered
            	l3Result = false;
            	return l3Result;
            }
		}

        while(!stackA.isEmpty() && !stackB.isEmpty())
        {// pop both stack till either one is empty
        	stackA.pop();
        	stackB.pop();

        	if (!stackB.isEmpty())
        	{// check if stackB can still pop one more B
        		stackB.pop();
        	}
        	else
        	{// there's no second B for the A in this round
        		stackB.push('B');	// push B back to stack so condition check in next block returns false
        		break;
        	}
        }
        
        if(!stackA.isEmpty() || !stackB.isEmpty())
        {//check if both stack is empty
        	l3Result = false;//return false if condition not met, language not under L3
        }
        
        return l3Result;
	}
	
	/**
	 * Check if language fall under L4 language category
	 * L4 = { w: w is of the form (AnBm)p, for some m,n,p > 0 }
	 * @return	true if language is under L4, false otherwise
	 */
	

	public boolean language4Test()
	{
		Stack stackApattern = new Stack();
		Stack stackBpattern = new Stack();
		Stack stackPattern = new Stack();
		Stack stackTemp = new Stack();

        Stack stackLanguage = new Stack();
        
        char cLanguage,cPattern;
        
        l4Result = true;
        
        //get pattern
        
        for(char temp : language.toCharArray())
        { // read each char in string
        	if(temp == 'A')
            {
        		if (stackBpattern.isEmpty())
        		{ // pushA to stackA and stackPattern is it's still in the first fragment
        			stackApattern.push(temp);
        			stackPattern.push(temp);
        		}
        		else
        		{ // break otherwise
        			break;
        		}
            }
            else if(temp == 'B')
            { // push B to stackB and stackPattern
            	stackBpattern.push(temp);
            	stackPattern.push(temp);
            }
            else
            { // early exit point when unrecognized char encountered
            	l4Result = false;
            	return l4Result;
            }
		}
        
       // Evaluation
        

        
        for(char temp : language.toCharArray())
        {// read each char and push into stack
        	
        	if(temp == 'A' || temp == 'B')
            {

        		stackLanguage.push(temp);
        	}
            else
            {// early exit point if unrecognized char encountered
            	l4Result = false;
            	return l4Result;
            }
        }   
        	
        	
	       while(!stackLanguage.isEmpty())
	        {// while stack contains all char is not empty
	    	   while (!stackPattern.isEmpty()&&!stackLanguage.isEmpty())
	    	   { // while pattern or current evaluating fragment is not empty
		    	   
	    		   if ( (cPattern = stackPattern.pop())==(cLanguage = stackLanguage.pop()))
	    		   {// pop letter in the fragment and pattern and compare
	    			   stackTemp.push(cPattern); //store popped char from pattern in a temp stack for later use
	    		   }
	               else
	               { //early exit point if any letter doesn't match
	               	l4Result = false;
	               	return l4Result;
	               }
	   	       
	    	   }
	    	   
	    	   while (!stackTemp.isEmpty())
	    	   { // push Stacktemp to stackPattern to generate correct pattern stack again
	    		   stackPattern.push(stackTemp.pop());
	    	   }

	        }
        
	       return l4Result;
	}
	
	
	/**
	 * Check if language fall under L5 language category
	 * L5 = { w: w is of the form AnBmC(m+n), for some m,n >= 0 }
	 * @return	true if language is under L5, false otherwise
	 */
	
	public boolean language5Test()
	{
	    Stack stackA = new Stack();
	    Stack stackB = new Stack();
	    Stack stackC = new Stack();

        l5Result = true; // default to true for empty string
        
        for(char temp : language.toCharArray())
        {// read each char in the string
        	if(temp == 'A')
            { // push A to stackA
            	stackA.push(temp);
            }
            else if(temp == 'B')
            { // push B to stackB
            	stackB.push(temp);
            }
            else if(temp == 'C')
            { // push C to stackC
            	stackC.push(temp);
            }
            else
            { // early exit point if unrecognized char is encountered
            	l5Result = false;
            	return l5Result;
            }
		}

        while(!stackC.isEmpty() && (!stackA.isEmpty() || !stackB.isEmpty()))
        {// pop stack till stack C is empty and either stack A/B is empty
        	stackC.pop();
        	
        	if (!stackA.isEmpty())
        	{// pop stackA till it's empty
        		stackA.pop();
        	}
        	else if (!stackB.isEmpty())
        	{// pop stackB till one's empty
        		stackB.pop();
        	}
        	else
        	{// push c back to stack as there's no A or B to be popped with this round's C
        		stackC.push('C');
        	}
        	
        }
        
        if(!stackA.isEmpty() || !stackB.isEmpty()|| !stackC.isEmpty())
        { //check if all stack is empty
        	l5Result = false; //return false if condition not met, language not under L3
        }
        
        return l5Result;
	}
	
	/**
	 * Check if language fall under L6 language category
	 * L6 = { w: w is of the form AnBmCpDCpBmAn (Reverse after D), for some m,n,p >= 0 }
	 * @return	true if language is under L6, false otherwise
	 */
	
	public boolean language6Test()
	{
		Stack stackD = new Stack();
	    Stack stackRight = new Stack();
	    Stack stackLeftReverse = new Stack();
	    
        l6Result = false; //default result to false for empty string (no D)
        
        for(char temp : language.toCharArray())
        { // read each char in the String
        	if(temp == 'A')
            { // push A to one stack
            	stackRight.push(temp);
            }
            else if(temp == 'B')
            { // push B to one stack
            	stackRight.push(temp);
            }
            else if(temp == 'C')
            { // push C to one stack
            	stackRight.push(temp);
            }
            else if(temp == 'D')
            { // letter D is encountered
            	stackD.push(temp);
            	if (stackLeftReverse.isEmpty())
            	{ // check if the other stack is ready to take reverse of the stack
            		while (!stackRight.isEmpty())
            		{ // push one stack to another stack to generate it's reverse
            			stackLeftReverse.push(stackRight.pop());
            		}
            	}
   
            	else
            	{ // early exit point for multiple D encountered
            		l6Result = false;
            		return l6Result;
            	}
            }
            else
            {
            	l6Result = false;
            	return l6Result;
            }
		}
        

        if (stackLeftReverse.isEmpty() && stackRight.isEmpty()&&!stackD.isEmpty())
        {// check for special case - String only contains one or multuple D
        	
        	l6Result = true;
        }
        else
        {// if not special case, evaluate stacks
            while(!stackLeftReverse.isEmpty() && !stackRight.isEmpty())
            {// pop both stacks till one is empty
            	
            	if (stackLeftReverse.pop() == stackRight.pop())
            	{// check if the reverse of left has the same element as right char by char
            		l6Result = true;
            	}

            	else
            	{// return false if any char doesn't meet the condition
            		l6Result = false;
            		break;
            	}
            	
            }
        }


        return l6Result;
	}
	
	/**
	 * Get language test L1-L6's rest results
	 * @return	String states test results summary for L1-L6
	 */
	
	public String getTestResults()
	{

		return (languageOriginal + "\r\nEvaluation Results:"
				+ "\r\nLanguage1 [A#=B#]:\t" + this.language1Test()
				+ "\r\nLanguage2 [AnBn]:\t" + this.language2Test()
				+ "\r\nLanguage3 [AnB2n]:\t" + this.language3Test()
				+ "\r\nLanguage4 [(AnBm)p]:\t" + this.language4Test()
				+ "\r\nLanguage5 [AnBmC(n+m)]:\t" + this.language5Test()
				+ "\r\nLanguage6 [ABCdCBA]:\t" + this.language6Test() +"\r\n");

	}
	
	/**
	 * Display the test results for L1-L6
	 */
	
	public void printTestResults()
	
	{
		System.out.println(this.getTestResults());

	}
	
}
