package org.persapiens.algorithms.dynamic.matrix;

/**
 *
 * @author marcelo fernandes
 */
public class MatrixChainOrder {
	public MatrixChainOrderResult measure(int[] p) {
		int n = p.length -1;
		int[][] m = new int[n][n];
		int[][] s = new int[n-1][n-1];
		for(int i = 0; i < n; i++) {
			m[i][i] = 0;
		}
		for (int l = 2; l <= n; l++) {
			for (int i = 1; i <= n-l+1; i++) {
				int j = i +l -1;
				m[i -1][j -1] = Integer.MAX_VALUE;
				for (int k = i; k <= j -1; k++) {
					int q = m[i -1][k -1] + m[k+1 -1][j -1] + p[i-1]*p[k]*p[j];
					if(q < m[i -1][j -1]) {
						m[i -1][j -1] = q;
						s[i -1][j -2] = k;
					}
				}
			}	
		}
		MatrixChainOrderResult result = new MatrixChainOrderResult();
		result.setM(m);
		result.setS(s);
		return result;
	}
    
	public String parens(int[][] s, int i, int j) {
		String result = "";
		if (i == j) {
			result += "A" + i;
		}
		else {
			result += "(";
			result += parens(s, i, s[i -1][j -2]);
			result += parens(s, s[i -1][j -2] +1, j);
			result += ")";
		}
		return result;
	}
}
