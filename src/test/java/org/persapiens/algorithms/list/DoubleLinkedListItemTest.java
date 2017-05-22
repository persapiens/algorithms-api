package org.persapiens.algorithms.list;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
@Test
public class DoubleLinkedListItemTest {
	public void oneDoubleLinkedListItem () {
		DoubleLinkedListItem<Integer> element = new DoubleLinkedListItem<>(100);
		
		assertThat(element.getKey())
			.isEqualTo(100);
		assertThat(element.toString())
			.isEqualTo("100");
	}
}
