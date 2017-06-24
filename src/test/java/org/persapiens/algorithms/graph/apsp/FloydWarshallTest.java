package org.persapiens.algorithms.graph.apsp;

/**
 *
 * @author marcelo
 */
public class FloydWarshallTest extends AbstractAllPairsShortestPathsTest{	
	@Override
	protected AllPairsShortestPaths createAllPairsShortestPaths() {
		return new FloydWarshall();
	}
}
