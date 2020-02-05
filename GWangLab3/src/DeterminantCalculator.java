import java.util.Arrays;

/**
 * This class constructs a determinant calculator to calculate determinant of a matrix
 * @author Guan Yue Wang
 * @version Neon.2 Release (4.6.2)
 * 2017-08-04
 */


public class DeterminantCalculator 
{
	private double det;
	private int i;
	private int m;
	private int n;
	private double value;
	private double data;
	
	/**
	 * Default constructor
	 */
	public DeterminantCalculator()
	{
		det = 0;
		i = 0;
	}
	
	
	/**
	 * calculate the determinant of the matrix
	 * @param 	array of double linked list that store the matrix
	 * @return  number represents the determinant of the matrix
	 */
	public double determinant (LinkedList[] matrixList) 
	{
				
		LinkedList[] minor;
		LinkedList list;

		det = 0;
		i = 0;
		
		list = matrixList[0]; // get the first row list
		
		for (int j = 0; j <  matrixList[0].listLength(); j++) 
		{	// loop through each element in row List
			if (list.listLength() == 1) 
			{// return the number if matrix only has one number
				return list.nodeValue(0);
			}
			else
			{	// use the formula to calculation the determinant recursively
				value = list.nodeValue(j);
				minor = this.minorMatrix(matrixList, j);
				det += Math.pow(-1, (i + j))*value*determinant(minor);
			}
		}

		return det;
	}
	
	
	/**
	 * Generate a minor of the matrix based on column index provided
	 * @param matrixList	array of double linked list that we need to get minor matrix from
	 * @param col	column index that need to be excluded for minor matrix
	 * @return	minor of the matrix with respect to the column index
	 */
	public LinkedList[] minorMatrix (LinkedList[]  matrixList, int col)
	{

		LinkedList	list;
		LinkedList	minorList;
		LinkedList[]	minor;
		
		n = matrixList[0].listLength();

		if (n == 1) 
		{// if there's only 1 element
			minor = matrixList;	
			return minor;
		}
		else
		{// if there are multiple elements
			
			minor = new LinkedList[n-1];
			m = 0;
			for (int i = 0; i < n; i++) 
			{
				list = matrixList[i];
				minorList = new LinkedList();
				
				if (i == 0)
				{
					continue;
				}
				
				for (int k = 0; k < list.listLength(); k++) 
				{
					
					if (k == col)
					{// ignore data in given column index
						continue;
					}
					
					data = list.nodeValue(k);
					minorList.add(data);
				}
				
				minor[m] = minorList;

				m++;
			}
		}
		return minor;
	}
	
	
	/**
	 * Return the matrix determinant calculation summary (matrix + determinant)
	 * @param matrixList	array of double linked list that store the matrix
	 * @return	a summary of the determinant calculation including matrix and determinant
	 */
	public String matrixSummary (LinkedList[] matrixList) 
	{
		int n = matrixList.length;
		int listSize;
		int nodeValue;
		LinkedList list;
		
		String summary = n+" by "+n+" Matrix:\r\n\r\n";
		
		for (int i = 0; i < n; i++) 
			{// loop through each row list
			
			 list = matrixList[i];
			 		
			 listSize = list.listLength();
			 
			 summary+="|";
			 		
			 for (int j = 0; j < listSize; j++) 
			 	{// loop through each column element
			 		if (j == 0)
			 		{
			 			summary += list.nodeValue(j);
			 		}
			 		else
			 		{
						 summary += "\t"+list.nodeValue(j);
			 		}

			 	}
			 	
			 summary+="|\r\n";	 
		}
		 summary +="\r\nDeterminant: " + this.determinant(matrixList)+"\r\n";
		
		return summary;
	}
	
}
