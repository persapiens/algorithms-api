package org.persapiens.algorithms.tree;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
@Test
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
	
	public void exampleCormenPage290InterativeSearch () {
		BinaryTree<Integer> tree = BinaryTree.<Integer>builder().iterativeSearch(true).build();
		testSearch(tree);
	}
	
	public void exampleCormenPage290RecursiveSearch () {
		BinaryTree<Integer> tree = BinaryTree.<Integer>builder().iterativeSearch(false).build();
		testSearch(tree);
	}
	
	private void testSearch(BinaryTree<Integer> tree) {
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
	
	public void successorPredecessorMinimumMaximum() {
		BinaryTree<Integer> tree = BinaryTree.<Integer>builder().build();
		
		TreeNode<Integer> node15 = tree.insert(15);		
		tree.insert(6);
		tree.insert(18);		
		tree.insert(3);
		tree.insert(7);		
		TreeNode<Integer> node17 = tree.insert(17);		
		TreeNode<Integer> node20 = tree.insert(20);		
		TreeNode<Integer> node2 = tree.insert(2);
		tree.insert(4);		
		TreeNode<Integer> node13 = tree.insert(13);
		tree.insert(9);		
		
		assertThat(tree.successor(node15))
			.isEqualTo(node17);
		assertThat(tree.successor(node13))
			.isEqualTo(node15);
		
		assertThat(tree.predecessor(node17))
			.isEqualTo(node15);
		assertThat(tree.predecessor(node15))
			.isEqualTo(node13);
		
		assertThat(tree.minimum())
			.isEqualTo(node2);
		assertThat(tree.maximum())
			.isEqualTo(node20);
	}
	
	public void insert() {
		BinaryTree<Integer> tree = BinaryTree.<Integer>builder().build();
		
		tree.insert(12);		
		tree.insert(5);
		tree.insert(18);		
		tree.insert(2);
		tree.insert(9);		
		TreeNode<Integer> node15 = tree.insert(15);		
		tree.insert(19);		
		tree.insert(17);
		
		TreeNode<Integer> node13 = tree.insert(13);
		
		checkTreeNode(node13, node15, null, null);		
	}
	
	public void deleteCasoAFigura124() {
		BinaryTree<Integer> tree = BinaryTree.<Integer>builder().build();
		
		TreeNode<Integer> node12 = tree.insert(12);		
		tree.insert(5);
		TreeNode<Integer> node18 = tree.insert(18);		
		tree.insert(2);
		tree.insert(9);		
		TreeNode<Integer> node15 = tree.insert(15);		
		TreeNode<Integer> node19 = tree.insert(19);		
		TreeNode<Integer> node17 = tree.insert(17);

		// caso a figure 12.4
		tree.delete(node15);		
		checkTreeNode(node17, node18, null, null);		
		checkTreeNode(node18, node12, node17, node19);		
	}
	
	public void deleteCasoBFigura124() {
		BinaryTree<Integer> tree = BinaryTree.<Integer>builder().build();
		
		TreeNode<Integer> node12 = tree.insert(12);		
		TreeNode<Integer> node5 = tree.insert(5);
		TreeNode<Integer> node18 = tree.insert(18);		
		tree.insert(2);
		tree.insert(9);		
		TreeNode<Integer> node15 = tree.insert(15);		

		// caso b figure 12.4
		tree.delete(node18);	
		checkTreeNode(node12, null, node5, node15);
		checkTreeNode(node15, node12, null, null);		
	}
	
	public void deleteCasoCFigura124() {
		BinaryTree<Integer> tree = BinaryTree.<Integer>builder().build();
		
		TreeNode<Integer> node12 = tree.insert(12);		
		TreeNode<Integer> node5 = tree.insert(5);
		TreeNode<Integer> node18 = tree.insert(18);		
		TreeNode<Integer> node19 = tree.insert(19);		
		TreeNode<Integer> node21 = tree.insert(21);
		
		// caso c figure 12.4
		tree.delete(node12);
		checkTreeNode(node18, null, node5, node19);		
		checkTreeNode(node19, node18, null, node21);		
		checkTreeNode(node21, node19, null, null);		
		checkTreeNode(node5, node18, null, null);		
	}
	
	public void deleteCasoDFigura124() {
		BinaryTree<Integer> tree = BinaryTree.<Integer>builder().build();
		
		TreeNode<Integer> node8 = tree.insert(8);
		TreeNode<Integer> node5 = tree.insert(5);
		TreeNode<Integer> node18 = tree.insert(18);		
		TreeNode<Integer> node16 = tree.insert(16);
		TreeNode<Integer> node14 = tree.insert(14);		
		TreeNode<Integer> node15 = tree.insert(15);		
		
		// caso d figure 12.4
		tree.delete(node8);
		checkTreeNode(node14, null, node5, node18);		
		checkTreeNode(node5, node14, null, null);		
		checkTreeNode(node18, node14, node16, null);
		checkTreeNode(node16, node18, node15, null);
		checkTreeNode(node15, node16, null, null);
	}
}
