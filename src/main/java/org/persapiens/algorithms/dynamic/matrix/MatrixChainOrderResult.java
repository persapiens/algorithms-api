package org.persapiens.algorithms.dynamic.matrix;

/**
 *
 * @author marcelo fernandes
 */
public class MatrixChainOrderResult {
	private int[][] m;
	private int[][] s;

	public int[][] getM() {
		int[][] result = null;
		if (m != null) {
			result = new int[m.length][];
			for (int i = 0; i < m.length; i++) {
				result[i] = new int[m[i].length];
				System.arraycopy(m[i], 0, result[i], 0, m[i].length);
			}
		}
		return result;
	}

	public void setM(int[][] m) {
		if (m != null) {
			this.m = new int[m.length][];
			for (int i = 0; i < m.length; i++) {
				this.m[i] = new int[m[i].length];
				System.arraycopy(m[i], 0, this.m[i], 0, m[i].length);
			}
		}
		else {
			this.m = null;
		}
	}

	public int[][] getS() {
		int[][] result = null;
		if (s != null) {
			result = new int[s.length][];
			for (int i = 0; i < s.length; i++) {
				result[i] = new int[s[i].length];
				System.arraycopy(s[i], 0, result[i], 0, s[i].length);
			}
		}
		return result;
	}

	public void setS(int[][] s) {
		if (s != null) {
			this.s = new int[s.length][];
			for (int i = 0; i < s.length; i++) {
				this.s[i] = new int[s[i].length];
				System.arraycopy(s[i], 0, this.s[i], 0, s[i].length);
			}
		}
		else {
			this.s = null;
		}
	}
	
}
