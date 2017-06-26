package org.persapiens.algorithms.graph.apsp;

import org.persapiens.algorithms.graph.Matrix;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
public class PoweredFloydWarshallTest {	

	@Test
	public void page690 () {
		PoweredFloydWarshall poweredFloydWarshall = new PoweredFloydWarshall();

		Matrix graph = MatrixFactory.page690Graph();
		
		WeightsAndPaths weightsAndPaths = poweredFloydWarshall.create(graph);

		AllPairsShortestPathsAsserter.assertWeightsPage690(weightsAndPaths.getWeights());
		AllPairsShortestPathsAsserter.assertPathsPage690(weightsAndPaths.getPaths());
	}
}
