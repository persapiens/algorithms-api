package org.persapiens.algorithms.graph;

/**
 *
 * @author marcelo
 */
public class MatrixUtil {

	public static Matrix initialize(Matrix w) {
		for (int i = 0; i < w.getRows(); i++) {
			for (int j = 0; j < w.getRows(); j++) {
				if (i == j) {
					w.set(i,j, 0);
				}
				else {
					w.set(i,j, Integer.MAX_VALUE / 2);
				}
			}
		}
		return w;
	}
}
