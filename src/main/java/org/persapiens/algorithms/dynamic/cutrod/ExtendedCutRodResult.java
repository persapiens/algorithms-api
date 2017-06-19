package org.persapiens.algorithms.dynamic.cutrod;

/**
 *
 * @author marcelo fernandes
 */
public class ExtendedCutRodResult {
	private int[] r;
	private int[] s;

	public int[] getR() {
		int[] result = null;
		if (r != null) {
			result = new int[r.length];
			System.arraycopy(r, 0, result, 0, r.length);
		}
		return result;
	}

	public void setR(int[] r) {
		if (r != null) {
			this.r = new int[r.length];
			System.arraycopy(r, 0, this.r, 0, r.length);
		}
		else {
			this.r = null;
		}
	}

	public int[] getS() {
		int[] result = null;
		if (s != null) {
			result = new int[s.length];
			System.arraycopy(s, 0, result, 0, s.length);
		}
		return result;
	}

	public void setS(int[] s) {
		if (s != null) {
			this.s = new int[s.length];
			System.arraycopy(s, 0, this.s, 0, s.length);
		}
		else {
			this.s = null;
		}
	}
	
}
