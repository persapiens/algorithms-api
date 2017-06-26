package org.persapiens.algorithms.graph.apsp;

import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
public abstract class AbstractAllPairsShortestPathsTest {	

	protected abstract AllPairsShortestPaths createAllPairsShortestPaths();

	@Test
	public void page690 () {
		AllPairsShortestPaths allPairsShortestPaths = createAllPairsShortestPaths();

		Matrix graph = MatrixFactory.page690Graph();
		
		Matrix apsp = allPairsShortestPaths.create(graph);
	
		AllPairsShortestPathsAsserter.assertWeightsPage690(apsp);
	}
}
