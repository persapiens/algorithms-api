package org.persapiens.algorithms.dynamic.cutrod;

import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
@Test
public class BottomUpMemoizedCutRodTest extends AbstractCutRodTest {

	@Override
	protected CutRod createCutRod() {
		return new BottomUpMemoizedCutRod();
	}
}
