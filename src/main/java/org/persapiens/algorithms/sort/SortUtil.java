package org.persapiens.algorithms.sort;

/**
 *
 * @author marcelo
 */
public class SortUtil {
	public static int power(int a, int b)
    {
		int power = 1;
		for(int c=0;c<b;c++)
		{
			power*=a;
		}
		return power;
	}
}
