package org.persapiens.algorithms.graph.apsp;

import static org.persapiens.algorithms.graph.apsp.Matrix.INFINITY;
import static org.persapiens.algorithms.graph.apsp.Matrix.NIL;

/**
 *
 * @author marcelo fernandes
 */
public class PoweredFloydWarshall {	
	
	private Integer pi(int i, int j, Matrix W) {
		Integer result = null;
		Integer w = W.get(i, j);
		if (i == j || w.equals(INFINITY)) {
			result = NIL;
		}
		else if (i != j && w < INFINITY) {
			result = i;
		}
		return result;
	}
	
	public DAndPi create(Matrix W) {
		int n = W.getRows();
		
		Matrix D = W;
		Matrix Pi = new Matrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Pi.set(i, j, pi(i, j, D));
			}
		}
		
		for (int k = 0; k < n; k++) {
			Matrix DLessOne = D;
			D = new Matrix(n);
			Matrix piLessOne = Pi;
			Pi = new Matrix(n);
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					D.set(i, j, Integer.min(DLessOne.get(i, j),
											DLessOne.get(i, k) + DLessOne.get(k, j)));
					Pi.set(i, j, DLessOne.get(i, j) <= DLessOne.get(i, k) + DLessOne.get(k, j)
						? piLessOne.get(i, j) : piLessOne.get(k, j));
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (D.get(i, i) < 0) {
				throw new IllegalArgumentException("graph contains a negative cycle!");
			}
		}		
		
		return DAndPi.builder()
			.d(D)
			.pi(Pi)
			.build();
	}
	
	public String path(Matrix Pi, int i, int j) {
		String result;
		
		if (i == j) {
			result = Integer.toString(i);
		} 
		else if (Pi.get(i, j).equals(NIL)) {
			throw new IllegalArgumentException("no path from " + i + " to " + j + "exists!");
		}
		else {
			result = path(Pi, i, Pi.get(i, j));
			result = result + " " + j;
		}
		return result;
	}
}
