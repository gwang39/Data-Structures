/**
 * This class constructs a determinant calculator to calculate determinant of a matrix
 * @author Guan Yue Wang
 * @version Neon.2 Release (4.6.2)
 * 2017-07-17
 */

public class DeterminantCalculator
{

	double M[][];
	double m[][];
	int N;
	
	
	/**
	 * Default constructor
	 */
	
	public DeterminantCalculator()
	{
		this.M=null;
		this.N=0;
		
	}
	
	/**
	 * Determinant Calculator that takes matrix and size n
	 * @param matrix 	2D array that stores matrix
	 * @param size		number n of the n by n matrix
	 */
	
	public DeterminantCalculator(double M[][],int n)
	{
		this.M=M;
		this.N=n;
	}
	
	
	/**
	 * Take matrix and size to calculate the determinant
	 * @param M		2D array that stores matrix
	 * @param N		number n of the n by n matrix
	 * @return		determinant of the input matrix
	 */
	
	public double determinant(double M[][],int N)
	{

		double det;

		if(N == 1)
		{	// return the number if matrix only has one number
			det = M[0][0];
		}

		else
		{	// use the formula to calculation the determinant recursively
			det=0;
			for(int j1=0;j1<N;j1++)
			{// loop through one row
				m = new double[N-1][]; //store minor matrix
				for(int k=0;k<(N-1);k++)
				{
					m[k] = new double[N-1];
				}
				
				for(int i=1;i<N;i++)
				{// loop to store minor matrix
					int j2=0;
					for(int j=0;j<N;j++)
					{
						if(j == j1)
							continue;
						m[i-1][j2] = M[i][j];
						j2++;
					}
				}
				det += Math.pow(-1.0,1.0+j1+1.0)* M[0][j1] * determinant(m,N-1);
			}
		}

		return det;
	}
	
	/**
	 * Return the original matrix in a formatted String
	 * @return		String represents the matrix
	 */
	
	public String matrixString()
	{
		String matrixString = "";

		for (int i = 0; i<M.length; i++)
		{
			matrixString += "|";
			
		    for (int j = 0; j<M[i].length; j++)
		    {
		    	 matrixString +=  Double.toString(M[j][i]);
		    	 
			    	if (j != M[i].length-1)
			    	{
			    		matrixString +="\t";
			    	}
		    } 
		    
		    matrixString += "|";
		    matrixString += "\r\n";
		}
		//\r\n
		return matrixString;	
	}
	
	/**
	 * Return the matrix determinant calculation summary
	 * @param M		2D array that stores matrix
	 * @param N		number n of the n by n matrix
	 * @return		String represents the matrix determinant calculation summary
	 */
	
	public String matrixSummary(double M[][],int N)
	{
		return N+" by "+N+" Matrix:\r\n\r\n" + this.matrixString() + "\r\nDeterminant:\t" + this.determinant(M,N) + "\r\n";
	}


}