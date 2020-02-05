import java.util.*;

/**
 *	This class implements insertion sort based on open source code
 * 	There are 5 sorting methods using 5 different sequence
 * 
 * 	@author Guan Yue Wang
 * 	@version Neon.2 Release (4.6.2)
 * 	2017-08-16
 * 
 *	Citation:
 *  Title: <Shell Sort>
 *  Author: <javacodex>
 *  Source: ShellSort.java
 *  Date: <2017.08.15>
 *  Availability: <http://www.javacodex.com/Sorting/Shell-Sort>
 *
 */
 
public class ShellSort
{
	
	public void sort1(double[] array) 
	{
	int inner, outer;
    double temp;
    int i=0;
    int h;

	int incre[] = {1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524};
	while (incre[i] < array.length) 
	{
		i++;
	}
	i-=2;

	while (i >= 0) 
	{
		h = incre[i];
		System.out.println("h: "+h);
		for (outer = h; outer < array.length; outer++) 
		{
			temp = array[outer];
			inner = outer;
 
			while (inner > h - 1 && array[inner - h] >= temp) 
			{
				array[inner] = array[inner - h];
				inner -= h;
			}
			array[inner] = temp;
		}
		i--;
		}
	}
	
	public void sort2(double[] array) 
	{
	int inner, outer;
    double temp;
    int i=0;
    int h;

	int incre[] = {1, 5, 17, 53, 149, 373, 1123, 3371, 10111, 30341};
	while (incre[i] < array.length) 
	{
		i++;
	}
	i-=2;

	while (i >= 0) 
	{
		h = incre[i];
		System.out.println("h: "+h);
		for (outer = h; outer < array.length; outer++) 
		{
			temp = array[outer];
			inner = outer;
 
			while (inner > h - 1 && array[inner - h] >= temp) 
			{
				array[inner] = array[inner - h];
				inner -= h;
			}
			array[inner] = temp;
		}
		i--;
		}
	}
	
	public void sort3(double[] array) 
	{
	int inner, outer;
    double temp;
    int i=0;
    int h;

	int incre[] = {1, 10, 30, 60, 120, 360, 1080, 3240, 9720, 29160};
	while (incre[i] < array.length) 
	{
		i++;
	}
	i-=2;

	while (i >= 0) 
	{
		h = incre[i];
		System.out.println("h: "+h);
		for (outer = h; outer < array.length; outer++) 
		{
			temp = array[outer];
			inner = outer;
 
			while (inner > h - 1 && array[inner - h] >= temp) 
			{
				array[inner] = array[inner - h];
				inner -= h;
			}
			array[inner] = temp;
		}
		i--;
		}
	}
	
	
	public void sort4(double[] array) 
	{
	int inner, outer;
    double temp;
    int i=0;
    int h;

	int incre[] = {1, 4, 10, 23, 57, 132, 301, 701, 1750, 3937, 8858, 19930}; //Marcin Ciura's Optimal sequence
	while (incre[i] < array.length) 
	{
		i++;
	}
	i-=2;

	while (i >= 0) 
	{
		h = incre[i];
		System.out.println("h: "+h);
		for (outer = h; outer < array.length; outer++) 
		{
			temp = array[outer];
			inner = outer;
 
			while (inner > h - 1 && array[inner - h] >= temp) 
			{
				array[inner] = array[inner - h];
				inner -= h;
			}
			array[inner] = temp;
		}
		i--;
		}
	}
	
	public void sort5(double[] array) 
	{
	int inner, outer;
    double temp;
    int i=0;
    int h;

	int incre[] = {1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383}; //Hibbard Sequence

	while (incre[i] < array.length) 
	{
		i++;
	}
	i-=2;

	while (i >= 0) 
	{
		h = incre[i];
		System.out.println("h: "+h);
		for (outer = h; outer < array.length; outer++) 
		{
			temp = array[outer];
			inner = outer;
 
			while (inner > h - 1 && array[inner - h] >= temp) 
			{
				array[inner] = array[inner - h];
				inner -= h;
			}
			array[inner] = temp;
		}
		i--;
		}
	}
	

}