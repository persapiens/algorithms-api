package org.persapiens.algorithms.graph.apsp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.persapiens.algorithms.graph.apsp.Matrix.NIL;
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
		
		DAndPi weightsAndPaths = poweredFloydWarshall.create(graph);

		AllPairsShortestPathsAsserter.assertWeightsPage690(weightsAndPaths.getD());
		assertPathsPage690(poweredFloydWarshall, weightsAndPaths.getPi());
	}

	public static void assertPathsPage690 (PoweredFloydWarshall poweredFloydWarshall, Matrix Pi) {
		assertPathsPage690Row0(poweredFloydWarshall, Pi);
		assertPathsPage690Row1(poweredFloydWarshall, Pi);
		assertPathsPage690Row2(poweredFloydWarshall, Pi);
		assertPathsPage690Row3(poweredFloydWarshall, Pi);
		assertPathsPage690Row4(poweredFloydWarshall, Pi);
	}

	private static void assertPathsPage690Row0 (PoweredFloydWarshall poweredFloydWarshall, Matrix Pi) {
		assertThat(Pi.get(0, 0))
			.isEqualTo(NIL);
		assertThat(poweredFloydWarshall.path(Pi, 0, 0))
			.isEqualTo("0");
		assertThat(Pi.get(0, 1))
			.isEqualTo(2);
		assertThat(poweredFloydWarshall.path(Pi, 0, 1))
			.isEqualTo("0 4 3 2 1");
		assertThat(Pi.get(0, 2))
			.isEqualTo(3);
		assertThat(poweredFloydWarshall.path(Pi, 0, 2))
			.isEqualTo("0 4 3 2");
		assertThat(Pi.get(0, 3))
			.isEqualTo(4);
		assertThat(poweredFloydWarshall.path(Pi, 0, 3))
			.isEqualTo("0 4 3");
		assertThat(Pi.get(0, 4))
			.isEqualTo(0);
		assertThat(poweredFloydWarshall.path(Pi, 0, 4))
			.isEqualTo("0 4");
	}
	
	private static void assertPathsPage690Row1 (PoweredFloydWarshall poweredFloydWarshall, Matrix Pi) {	
		assertThat(Pi.get(1, 0))
			.isEqualTo(3);
		assertThat(poweredFloydWarshall.path(Pi, 1, 0))
			.isEqualTo("1 3 0");
		assertThat(Pi.get(1, 1))
			.isEqualTo(NIL);
		assertThat(poweredFloydWarshall.path(Pi, 1, 1))
			.isEqualTo("1");
		assertThat(Pi.get(1, 2))
			.isEqualTo(3);
		assertThat(poweredFloydWarshall.path(Pi, 1, 2))
			.isEqualTo("1 3 2");
		assertThat(Pi.get(1, 3))
			.isEqualTo(1);
		assertThat(poweredFloydWarshall.path(Pi, 1, 3))
			.isEqualTo("1 3");
		assertThat(Pi.get(1, 4))
			.isEqualTo(0);
		assertThat(poweredFloydWarshall.path(Pi, 1, 4))
			.isEqualTo("1 3 0 4");
	}
	
	private static void assertPathsPage690Row2 (PoweredFloydWarshall poweredFloydWarshall, Matrix Pi) {	
		assertThat(Pi.get(2, 0))
			.isEqualTo(3);
		assertThat(poweredFloydWarshall.path(Pi, 2, 0))
			.isEqualTo("2 1 3 0");
		assertThat(Pi.get(2, 1))
			.isEqualTo(2);
		assertThat(poweredFloydWarshall.path(Pi, 2, 1))
			.isEqualTo("2 1");
		assertThat(Pi.get(2, 2))
			.isEqualTo(NIL);
		assertThat(poweredFloydWarshall.path(Pi, 2, 2))
			.isEqualTo("2");
		assertThat(Pi.get(2, 3))
			.isEqualTo(1);
		assertThat(poweredFloydWarshall.path(Pi, 2, 3))
			.isEqualTo("2 1 3");
		assertThat(Pi.get(2, 4))
			.isEqualTo(0);
		assertThat(poweredFloydWarshall.path(Pi, 2, 4))
			.isEqualTo("2 1 3 0 4");
	}
	
	private static void assertPathsPage690Row3 (PoweredFloydWarshall poweredFloydWarshall, Matrix Pi) {	
		assertThat(Pi.get(3, 0))
			.isEqualTo(3);
		assertThat(poweredFloydWarshall.path(Pi, 3, 0))
			.isEqualTo("3 0");
		assertThat(Pi.get(3, 1))
			.isEqualTo(2);
		assertThat(poweredFloydWarshall.path(Pi, 3, 1))
			.isEqualTo("3 2 1");
		assertThat(Pi.get(3, 2))
			.isEqualTo(3);
		assertThat(poweredFloydWarshall.path(Pi, 3, 2))
			.isEqualTo("3 2");
		assertThat(Pi.get(3, 3))
			.isEqualTo(NIL);
		assertThat(poweredFloydWarshall.path(Pi, 3, 3))
			.isEqualTo("3");
		assertThat(Pi.get(3, 4))
			.isEqualTo(0);
		assertThat(poweredFloydWarshall.path(Pi, 3, 4))
			.isEqualTo("3 0 4");
	}
	
	private static void assertPathsPage690Row4 (PoweredFloydWarshall poweredFloydWarshall, Matrix Pi) {	
		assertThat(Pi.get(4, 0))
			.isEqualTo(3);
		assertThat(poweredFloydWarshall.path(Pi, 4, 0))
			.isEqualTo("4 3 0");
		assertThat(Pi.get(4, 1))
			.isEqualTo(2);
		assertThat(poweredFloydWarshall.path(Pi, 4, 1))
			.isEqualTo("4 3 2 1");
		assertThat(Pi.get(4, 2))
			.isEqualTo(3);
		assertThat(poweredFloydWarshall.path(Pi, 4, 2))
			.isEqualTo("4 3 2");
		assertThat(Pi.get(4, 3))
			.isEqualTo(4);
		assertThat(poweredFloydWarshall.path(Pi, 4, 3))
			.isEqualTo("4 3");
		assertThat(Pi.get(4, 4))
			.isEqualTo(NIL);
		assertThat(poweredFloydWarshall.path(Pi, 4, 4))
			.isEqualTo("4");
	}
}
