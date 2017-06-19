package org.persapiens.algorithms.dynamic.cutrod;

/**
 *
 * @author marcelo fernandes
 */
public class ExtendedBottomUpMemoizedCutRod implements ExtendedCutRod {
	@Override
	public ExtendedCutRodResult measure(int[] prices, int n) {
		int[] r = new int[n+1];
		int[] s = new int[n+1];
		r[0] = 0;
		s[0] = 0;
		for (int j = 1; j <= n; j++) {
			int q = Integer.MIN_VALUE;
			for (int i = 1; i <= j; i++) {
				if(q < prices[i-1] + r[j-i]) {
					q = prices[i-1] + r[j -i];
					s[j] = i;
				}
			}	
			r[j] = q;
		}
		ExtendedCutRodResult result = new ExtendedCutRodResult();
		result.setR(r);
		result.setS(s);
		return result;
	}
    
	@Override
	public void print(int[] prices, int n) {
		ExtendedCutRodResult result = measure(prices, n);
		while (n > 0) {
			System.out.println(result.getS()[n]);
			n = n - result.getS()[n];
		}
	}
}
