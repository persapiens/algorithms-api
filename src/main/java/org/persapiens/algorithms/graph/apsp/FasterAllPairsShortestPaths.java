package org.persapiens.algorithms.graph.apsp;

import org.persapiens.algorithms.graph.Matrix;

/**
 *
 * @author marcelo fernandes
 */
public class FasterAllPairsShortestPaths extends AbstractAllPairsShortestPaths {	
	@Override
	public Matrix create(Matrix W) {
		int n = W.getRows();
		
		Matrix L = W;
		
		int m = 1;
		
		while (m < n -1) {
			L = extendShortestPaths(L, L);
			m = 2 * m;
		}
		
		return L;
	}
}
