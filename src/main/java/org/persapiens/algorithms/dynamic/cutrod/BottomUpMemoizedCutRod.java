package org.persapiens.algorithms.dynamic.cutrod;

/**
 *
 * @author marcelo fernandes
 */
public class BottomUpMemoizedCutRod implements CutRod {
	@Override
	public int measure(int[] prices, int n) {
		int[] r = new int[n+1];
		r[0] = 0;
		for (int j = 1; j <= n; j++) {
			int q = Integer.MIN_VALUE;
			for (int i = 1; i <= j; i++) {
				q = Integer.max(q, prices[i-1] + r[j -i]);
			}	
			r[j] = q;
		}
		return r[n];
	}
    
}
