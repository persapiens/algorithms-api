package org.persapiens.algorithms.graph.apsp;

/**
 *
 * @author marcelo fernandes
 */
public class FloydWarshall implements AllPairsShortestPaths {	
	
	@Override
	public Matrix create(Matrix W) {
		int n = W.getRows();
		
		Matrix D = W;
		
		for (int k = 0; k < n; k++) {
			Matrix DLessOne = D;
			D = new Matrix(n);
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					D.set(i, j, Integer.min(DLessOne.get(i, j),
											DLessOne.get(i, k) + DLessOne.get(k, j)));
				}
			}
		}
		
		return D;
	}
}
