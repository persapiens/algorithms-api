package org.persapiens.tree;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
public class BinaryTreeTest {
	void checkTreeNode(TreeNode<Integer> node, TreeNode<Integer> parent
		, TreeNode<Integer> left, TreeNode<Integer> right) {
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
	
	@Test
	public void exampleACormenPage287 () {
		BinaryTree<Integer> tree = BinaryTree.<Integer>builder().build();
		
		TreeNode<Integer> node6 = tree.insert(6);
		TreeNode<Integer> node5 = tree.insert(5);
		TreeNode<Integer> node7 = tree.insert(7);		
		TreeNode<Integer> node2 = tree.insert(2);		
		TreeNode<Integer> node5x = tree.insert(5);		
		TreeNode<Integer> node8 = tree.insert(8);		
		
		checkTreeNode(node6, null, node5, node7);		
		checkTreeNode(node5, node6, node2, node5x);		
		checkTreeNode(node7, node6, null, node8);		
		checkTreeNode(node2, node5, null, null);		
		checkTreeNode(node5x, node5, null, null);		
		checkTreeNode(node8, node7, null, null);

		assertThat(tree.sort())
			.isEqualTo(Arrays.asList(2,5,5,6,7,8));
	}
	
	@Test
	public void exampleBCormenPage287 () {
		BinaryTree<Integer> tree = BinaryTree.<Integer>builder().build();
		
		TreeNode<Integer> node2 = tree.insert(2);		
		TreeNode<Integer> node5 = tree.insert(5);
		TreeNode<Integer> node7 = tree.insert(7);		
		TreeNode<Integer> node6 = tree.insert(6);
		TreeNode<Integer> node8 = tree.insert(8);		
		TreeNode<Integer> node5x = tree.insert(5);		
		
		checkTreeNode(node2, null, null, node5);		
		checkTreeNode(node5, node2, null, node7);
		checkTreeNode(node7, node5, node6, node8);		
		checkTreeNode(node6, node7, node5x, null);		
		checkTreeNode(node8, node7, null, null);		
		checkTreeNode(node5x, node6, null, null);

		assertThat(tree.sort())
			.isEqualTo(Arrays.asList(2,5,5,6,7,8));
	}
	
	@Test
	public void exampleCormenPage290InterativeSearch () {
		BinaryTree<Integer> tree = BinaryTree.<Integer>builder().iterativeSearch(true).build();
		
		TreeNode<Integer> node15 = tree.insert(15);		
		TreeNode<Integer> node6 = tree.insert(6);
		TreeNode<Integer> node18 = tree.insert(18);		
		TreeNode<Integer> node3 = tree.insert(3);
		TreeNode<Integer> node7 = tree.insert(7);		
		TreeNode<Integer> node17 = tree.insert(17);		
		TreeNode<Integer> node20 = tree.insert(20);		
		TreeNode<Integer> node2 = tree.insert(2);
		TreeNode<Integer> node4 = tree.insert(4);		
		TreeNode<Integer> node13 = tree.insert(13);
		TreeNode<Integer> node9 = tree.insert(9);		
		
		assertThat(tree.search(15))
			.isEqualTo(node15);
		assertThat(tree.search(6))
			.isEqualTo(node6);
		assertThat(tree.search(18))
			.isEqualTo(node18);
		assertThat(tree.search(3))
			.isEqualTo(node3);
		assertThat(tree.search(7))
			.isEqualTo(node7);
		assertThat(tree.search(17))
			.isEqualTo(node17);
		assertThat(tree.search(20))
			.isEqualTo(node20);
		assertThat(tree.search(2))
			.isEqualTo(node2);
		assertThat(tree.search(4))
			.isEqualTo(node4);
		assertThat(tree.search(13))
			.isEqualTo(node13);
		assertThat(tree.search(9))
			.isEqualTo(node9);
	}
	
	@Test
	public void exampleCormenPage290RecursiveSearch () {
		BinaryTree<Integer> tree = BinaryTree.<Integer>builder().iterativeSearch(false).build();
		
		TreeNode<Integer> node15 = tree.insert(15);		
		TreeNode<Integer> node6 = tree.insert(6);
		TreeNode<Integer> node18 = tree.insert(18);		
		TreeNode<Integer> node3 = tree.insert(3);
		TreeNode<Integer> node7 = tree.insert(7);		
		TreeNode<Integer> node17 = tree.insert(17);		
		TreeNode<Integer> node20 = tree.insert(20);		
		TreeNode<Integer> node2 = tree.insert(2);
		TreeNode<Integer> node4 = tree.insert(4);		
		TreeNode<Integer> node13 = tree.insert(13);
		TreeNode<Integer> node9 = tree.insert(9);		
		
		assertThat(tree.search(15))
			.isEqualTo(node15);
		assertThat(tree.search(6))
			.isEqualTo(node6);
		assertThat(tree.search(18))
			.isEqualTo(node18);
		assertThat(tree.search(3))
			.isEqualTo(node3);
		assertThat(tree.search(7))
			.isEqualTo(node7);
		assertThat(tree.search(17))
			.isEqualTo(node17);
		assertThat(tree.search(20))
			.isEqualTo(node20);
		assertThat(tree.search(2))
			.isEqualTo(node2);
		assertThat(tree.search(4))
			.isEqualTo(node4);
		assertThat(tree.search(13))
			.isEqualTo(node13);
		assertThat(tree.search(9))
			.isEqualTo(node9);
	}
}
