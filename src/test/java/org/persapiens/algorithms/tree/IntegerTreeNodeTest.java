package org.persapiens.algorithms.tree;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
@Test
public class IntegerTreeNodeTest {
	public void testToString() {
		IntegerTreeNode node = new IntegerTreeNode(3);
		assertThat(node.toString())
			.isEqualTo("3");
	}
}
