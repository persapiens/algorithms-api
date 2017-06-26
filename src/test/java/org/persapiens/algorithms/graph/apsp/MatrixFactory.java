package org.persapiens.algorithms.graph.apsp;

import static org.persapiens.algorithms.graph.apsp.Matrix.INFINITY;

/**
 *
 * @author marcelo
 */
public class MatrixFactory {

	private static Matrix initialize(Matrix w) {
		for (int i = 0; i < w.getRows(); i++) {
			for (int j = 0; j < w.getRows(); j++) {
				if (i == j) {
					w.set(i,j, 0);
				}
				else {
					w.set(i,j, INFINITY);
				}
			}
		}
		return w;
	}
	
	public static Matrix page690Graph () {
		Matrix matrix = new Matrix(5);
		
		matrix = initialize(matrix);		
		
		matrix.set(0,1, 3);
		matrix.set(0,2, 8);
		matrix.set(0,4, -4);
		matrix.set(1,3, 1);
		matrix.set(1,4, 7);
		matrix.set(2,1, 4);
		matrix.set(3,0, 2);
		matrix.set(3,2, -5);
		matrix.set(4,3, 6);
		
		return matrix;
	}
}
