package org.persapiens.algorithms.dynamic.cutrod;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
public abstract class AbstractCutRodTest {
	protected abstract CutRod createCutRod();
	
	@Test
	public void page360 () {
		CutRod cutRod = createCutRod();
		int[] prices = {1,5,8,9,10,17,17,20,24,30};
		
		assertThat(cutRod.measure(prices, 1))
			.isEqualTo(1);
		assertThat(cutRod.measure(prices, 2))
			.isEqualTo(5);
		assertThat(cutRod.measure(prices, 3))
			.isEqualTo(8);
		assertThat(cutRod.measure(prices, 4))
			.isEqualTo(10);
		assertThat(cutRod.measure(prices, 5))
			.isEqualTo(13);
		assertThat(cutRod.measure(prices, 6))
			.isEqualTo(17);
		assertThat(cutRod.measure(prices, 7))
			.isEqualTo(18);
		assertThat(cutRod.measure(prices, 8))
			.isEqualTo(22);
		assertThat(cutRod.measure(prices, 9))
			.isEqualTo(25);
		assertThat(cutRod.measure(prices, 10))
			.isEqualTo(30);
	}
}
