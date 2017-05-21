package org.persapiens.algorithms.tree;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author marcelo
 */
public abstract class AbstractBinaryTreeTest {
	protected void checkTreeNode(TreeNode node, TreeNode parent
		, TreeNode left, TreeNode right) {
		if (parent == null) {
			assertThat(node.getParent())
				.isNull();
		}
		else {
			assertThat(node.getParent())
				.isEqualTo(parent);
		}
		if (left == null) {
			assertThat(node.getLeft())
				.isNull();
		}
		else {
			assertThat(node.getLeft())
				.isEqualTo(left);
		}
		if (right == null) {
			assertThat(node.getRight())
				.isNull();
		}
		else {
			assertThat(node.getRight())
				.isEqualTo(right);
		}
	}
}
