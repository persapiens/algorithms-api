package org.persapiens.algorithms.graph.apsp;

/**
 *
 * @author marcelo
 */
public class FasterAllPairsShortestPathsTest extends AbstractAllPairsShortestPathsTest {	
	@Override
	protected AllPairsShortestPaths createAllPairsShortestPaths() {
		return new FasterAllPairsShortestPaths();
	}
}
