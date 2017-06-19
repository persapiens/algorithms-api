package org.persapiens.algorithms.dynamic.cutrod;

/**
 *
 * @author marcelo fernandes
 */
public class TopDownRecursiveCutRod implements CutRod {
	@Override
	public int measure(int[] prices, int n) {
		int result = 0;
		
		if (n != 0) {
			int q = Integer.MIN_VALUE;
			
			for (int i = 1; i <= n; i++) {
				q = Integer.max(q, prices[i-1] + measure(prices, n -i));
			}
			
			result = q;
		}
		
		return result;
	}
    
}
