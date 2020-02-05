import java.util.*;

/**
 *	This class implements array based heap sort based on open source code
 * 
 * 	@author Guan Yue Wang
 * 	@version Neon.2 Release (4.6.2)
 * 	2017-08-16
 * 
 *	Citation:
 *  Title: <Heap Sort>
 *  Author: <javacodex>
 *  Source: HeapSort.java
 *  Date: <2017.08.15>
 *  Availability: <http://www.javacodex.com/Sorting/Heap-Sort>
 *
 */

 
public class HeapSort 
{
 
	private static double[] a;
	private static int n;
	private static int left;
	private static int right;
	private static int largest;
 
 
	public void buildheap(double []a) 
	{
		n = a.length-1;
		for(int i=n/2; i>=0; i--)
		{
			maxheap(a,i);
		}
	}
 
	public void maxheap(double[] a, int i)
	{ 
		left = 2*i;
		right = 2*i+1;
 
		if(left <= n && a[left] > a[i]){
			largest=left;
		} else {
			largest=i;
		}
 
		if(right <= n && a[right] > a[largest]) {
			largest=right;
		}
		if(largest!=i) {
			exchange(i, largest);
			maxheap(a, largest);
		}
	}
	
	public void exchange(int i, int j) {
		double t = a[i];
		a[i] = a[j];
		a[j] = t; 
	}
 
	public void sort(double[] myarray) {
		a = myarray;
		buildheap(a);
		for(int i=n; i>0; i--)
		{
			exchange(0, i);
			n=n-1;
			maxheap(a, 0);
		}
	}
}