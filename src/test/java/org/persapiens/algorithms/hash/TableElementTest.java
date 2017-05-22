package org.persapiens.algorithms.hash;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
@Test
public class TableElementTest {
	public void oneTableElement () {
		TableElement<Integer> element = new TableElement<>(0, 100);
		
		assertThat(element.getKey())
			.isEqualTo(0);
		assertThat(element.getData())
			.isEqualTo(100);
		assertThat(element.toString())
			.isEqualTo("100");
	}
}
