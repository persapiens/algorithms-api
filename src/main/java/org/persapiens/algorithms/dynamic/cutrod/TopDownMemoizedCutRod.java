package org.persapiens.algorithms.dynamic.cutrod;

/**
 *
 * @author marcelo fernandes
 */
public class TopDownMemoizedCutRod implements CutRod {
	@Override
	public int measure(int[] prices, int n) {
		int[] r = new int[n+1];
		for (int i = 0; i <= n; i++) {
			r[i] = Integer.MIN_VALUE;
		}
		return memoizedAux(prices, n, r);
	}

	private int memoizedAux(int[] prices, int n, int[] r) {
		if (r[n] >= 0) {
			return r[n];
		}
		int result;
		if (n == 0) {
			result = 0;
		}
		else {
			result = Integer.MIN_VALUE;
			for (int i = 1; i <= n; i++) {
				result = Integer.max(result, prices[i-1] + memoizedAux(prices, n -i, r));
			}
		}
		r[n] = result;
		return result;
	}
    
}
