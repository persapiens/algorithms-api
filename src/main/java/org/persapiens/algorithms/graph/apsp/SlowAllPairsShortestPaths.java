package org.persapiens.algorithms.graph.apsp;

import org.persapiens.algorithms.graph.Matrix;

/**
 *
 * @author marcelo fernandes
 */
public class SlowAllPairsShortestPaths extends AbstractAllPairsShortestPaths {	
	@Override
	public Matrix create(Matrix W) {
		int n = W.getRows();
		
		Matrix L = W;
		
		for (int m = 2; m <= n -1; m++) {
			L = extendShortestPaths(L, W);
		}
		
		return L;
	}
}
