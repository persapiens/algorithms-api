package org.persapiens.algorithms.graph.apsp;

import org.persapiens.algorithms.graph.Matrix;

/**
 *
 * @author marcelo fernandes
 */
public abstract class AbstractAllPairsShortestPaths implements AllPairsShortestPaths {	
	
	protected Matrix extendShortestPaths(Matrix L, Matrix W) {
		int n = L.getRows();
		Matrix LL = new Matrix(L.getRows());
		for (int i=0; i < n; i++) {
			for (int j=0; j < n; j++) {
				LL.set(i, j, Integer.MAX_VALUE / 2);
				for (int k =0; k < n; k++) {
					LL.set(i, j, Integer.min(LL.get(i, j), L.get(i, k) + W.get(k, j)));
				}
			}
		}
		return LL;
	}
}
