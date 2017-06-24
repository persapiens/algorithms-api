package org.persapiens.algorithms.graph.apsp;

/**
 *
 * @author marcelo
 */
public class SlowAllPairsShortestPathsTest extends AbstractAllPairsShortestPathsTest {	
	@Override
	protected AllPairsShortestPaths createAllPairsShortestPaths() {
		return new SlowAllPairsShortestPaths();
	}
}
