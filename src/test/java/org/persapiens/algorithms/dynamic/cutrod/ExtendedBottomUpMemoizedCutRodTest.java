package org.persapiens.algorithms.dynamic.cutrod;

import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
@Test
public class ExtendedBottomUpMemoizedCutRodTest extends AbstractExtendedCutRodTest {

	@Override
	protected ExtendedCutRod createExtendedCutRod() {
		return new ExtendedBottomUpMemoizedCutRod();
	}
}
