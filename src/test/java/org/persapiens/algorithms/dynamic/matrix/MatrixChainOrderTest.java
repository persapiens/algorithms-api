package org.persapiens.algorithms.dynamic.matrix;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
public class MatrixChainOrderTest {
	@Test
	public void page376 () {
		MatrixChainOrder matrixChainOrder = new MatrixChainOrder();
		int[] p = {30,35,15,5,10,20,25};
		
		MatrixChainOrderResult measure = matrixChainOrder.measure(p);
		
		assertThat(measure.getM()[0])
			.isEqualTo(Arrays.asList(0,15750,7875,9375,11875,15125).toArray());
		assertThat(measure.getM()[1])
			.isEqualTo(Arrays.asList(0,0,2625,4375,7125,10500).toArray());
		assertThat(measure.getM()[2])
			.isEqualTo(Arrays.asList(0,0,0,750,2500,5375).toArray());
		assertThat(measure.getM()[3])
			.isEqualTo(Arrays.asList(0,0,0,0,1000,3500).toArray());
		assertThat(measure.getM()[4])
			.isEqualTo(Arrays.asList(0,0,0,0,0,5000).toArray());
		assertThat(measure.getM()[5])
			.isEqualTo(Arrays.asList(0,0,0,0,0,0).toArray());
		
		assertThat(measure.getS()[0])
			.isEqualTo(Arrays.asList(1,1,3,3,3).toArray());
		assertThat(measure.getS()[1])
			.isEqualTo(Arrays.asList(0,2,3,3,3).toArray());
		assertThat(measure.getS()[2])
			.isEqualTo(Arrays.asList(0,0,3,3,3).toArray());
		assertThat(measure.getS()[3])
			.isEqualTo(Arrays.asList(0,0,0,4,5).toArray());
		assertThat(measure.getS()[4])
			.isEqualTo(Arrays.asList(0,0,0,0,5).toArray());
		
		assertThat(matrixChainOrder.parens(measure.getS(), 2,5))
			.isEqualTo("((A2A3)(A4A5))");
		
		assertThat(matrixChainOrder.parens(measure.getS(), 1,6))
			.isEqualTo("((A1(A2A3))((A4A5)A6))");
	}
	
	@Test
	public void page378 () {
		MatrixChainOrder matrixChainOrder = new MatrixChainOrder();
		int[] p = {5,10,3,12,5,50,6};
		
		MatrixChainOrderResult measure = matrixChainOrder.measure(p);
		
		assertThat(matrixChainOrder.parens(measure.getS(), 1,6))
			.isEqualTo("((A1A2)((A3A4)(A5A6)))");
	}
}
