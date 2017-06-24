package org.persapiens.algorithms.graph.apsp;

import static org.assertj.core.api.Assertions.assertThat;
import org.persapiens.algorithms.graph.Matrix;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
public abstract class AbstractAllPairsShortestPathsTest {	

	protected abstract AllPairsShortestPaths createAllPairsShortestPaths();

	@Test
	public void page632 () {
		AllPairsShortestPaths allPairsShortestPaths = createAllPairsShortestPaths();

		Matrix graph = MatrixFactory.page690Graph();
		
		Matrix apsp = allPairsShortestPaths.create(graph);
	
		assertThat(apsp.get(0, 0))
			.isEqualTo(0);
		assertThat(apsp.get(1, 0))
			.isEqualTo(3);
		assertThat(apsp.get(2, 0))
			.isEqualTo(7);
		assertThat(apsp.get(3, 0))
			.isEqualTo(2);
		assertThat(apsp.get(4, 0))
			.isEqualTo(8);
		assertThat(apsp.get(0, 1))
			.isEqualTo(1);
		assertThat(apsp.get(1, 1))
			.isEqualTo(0);
		assertThat(apsp.get(2, 1))
			.isEqualTo(4);
		assertThat(apsp.get(3, 1))
			.isEqualTo(-1);
		assertThat(apsp.get(4, 1))
			.isEqualTo(5);
		assertThat(apsp.get(0, 2))
			.isEqualTo(-3);
		assertThat(apsp.get(1, 2))
			.isEqualTo(-4);
		assertThat(apsp.get(2, 2))
			.isEqualTo(0);
		assertThat(apsp.get(3, 2))
			.isEqualTo(-5);
		assertThat(apsp.get(4, 2))
			.isEqualTo(1);
		assertThat(apsp.get(0, 3))
			.isEqualTo(2);
		assertThat(apsp.get(1, 3))
			.isEqualTo(1);
		assertThat(apsp.get(2, 3))
			.isEqualTo(5);
		assertThat(apsp.get(3, 3))
			.isEqualTo(0);
		assertThat(apsp.get(4, 3))
			.isEqualTo(6);
		assertThat(apsp.get(0, 4))
			.isEqualTo(-4);
		assertThat(apsp.get(1, 4))
			.isEqualTo(-1);
		assertThat(apsp.get(2, 4))
			.isEqualTo(3);
		assertThat(apsp.get(3, 4))
			.isEqualTo(-2);
		assertThat(apsp.get(4, 4))
			.isEqualTo(0);
	}
}
