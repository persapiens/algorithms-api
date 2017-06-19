package org.persapiens.algorithms.dynamic.cutrod;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
public abstract class AbstractExtendedCutRodTest {
	protected abstract ExtendedCutRod createExtendedCutRod();
	
	@Test
	public void page360 () {
		ExtendedCutRod cutRod = createExtendedCutRod();
		int[] prices = {1,5,8,9,10,17,17,20,24,30};
		
		ExtendedCutRodResult measure = cutRod.measure(prices, 10);
		
		assertThat(measure.getR())
			.isEqualTo(Arrays.asList(0,1,5,8,10,13,17,18,22,25,30).toArray());
		assertThat(measure.getS())
			.isEqualTo(Arrays.asList(0,1,2,3,2,2,6,1,2,3,10).toArray());
		
		cutRod.print(prices, 10);
		cutRod.print(prices, 7);
	}
}
