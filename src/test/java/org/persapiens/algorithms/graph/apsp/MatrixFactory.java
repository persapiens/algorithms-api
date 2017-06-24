package org.persapiens.algorithms.graph.apsp;

import org.persapiens.algorithms.graph.Matrix;
import org.persapiens.algorithms.graph.MatrixUtil;

/**
 *
 * @author marcelo
 */
public class MatrixFactory {
	public static Matrix page690Graph () {
		Matrix matrix = new Matrix(5);
		
		matrix = MatrixUtil.initialize(matrix);		
		
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
