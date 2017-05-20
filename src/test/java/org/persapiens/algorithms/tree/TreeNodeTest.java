package org.persapiens.algorithms.tree;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
@Test
public class TreeNodeTest {
	public void testToString() {
		TreeNode<Integer> node = TreeNode.<Integer>builder().key(3).build();
		assertThat(node.toString())
			.isEqualTo("3");
	}
}
