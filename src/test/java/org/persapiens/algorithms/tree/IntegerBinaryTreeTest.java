package org.persapiens.algorithms.tree;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
@Test
public class IntegerBinaryTreeTest  extends AbstractBinaryTreeTest <IntegerBinaryTree, IntegerTreeNode, Integer> {
	
	public void exampleACormenPage287 () {
		IntegerBinaryTree tree = createTree(true, 6, 5, 7, 2);
		
		IntegerTreeNode node5x = tree.insert(5);
		
		checkTreeNode(tree, 6, null, 5, 7);
		checkTreeNode(tree.search(5), tree.search(6), tree.search(2), node5x);		
		checkTreeNode(tree, 7, 6, null, 8);		
		checkTreeNode(tree, 2, 5, null, null);		
		checkTreeNode(node5x, tree.search(5), null, null);		

		assertThat(tree.sort())
			.isEqualTo(Arrays.asList(2,5,5,6,7));
	}
	
	public void exampleBCormenPage287 () {
		IntegerBinaryTree tree = createTree(false, 2, 5, 7, 6, 8);
		
		IntegerTreeNode node2 = tree.search(2);		
		IntegerTreeNode node5 = tree.search(5);
		IntegerTreeNode node7 = tree.search(7);		
		IntegerTreeNode node6 = tree.search(6);
		IntegerTreeNode node8 = tree.search(8);
		
		IntegerTreeNode node5x = tree.insert(5);		
		
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
		IntegerBinaryTree tree = createTree(true);
		testSearch(tree);
	}
	
	public void exampleCormenPage290RecursiveSearch () {
		IntegerBinaryTree tree = createTree(false);
		testSearch(tree);
	}
	
	private void testSearch(IntegerBinaryTree tree) {
		IntegerTreeNode node15 = tree.insert(15);		
		IntegerTreeNode node6 = tree.insert(6);
		IntegerTreeNode node18 = tree.insert(18);		
		IntegerTreeNode node3 = tree.insert(3);
		IntegerTreeNode node7 = tree.insert(7);		
		IntegerTreeNode node17 = tree.insert(17);		
		IntegerTreeNode node20 = tree.insert(20);		
		IntegerTreeNode node2 = tree.insert(2);
		IntegerTreeNode node4 = tree.insert(4);		
		IntegerTreeNode node13 = tree.insert(13);
		IntegerTreeNode node9 = tree.insert(9);		
		
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
		IntegerBinaryTree tree = createTree(true, 15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9);
		
		IntegerTreeNode node15 = tree.search(15);		
		IntegerTreeNode node17 = tree.search(17);		
		IntegerTreeNode node20 = tree.search(20);		
		IntegerTreeNode node2 = tree.search(2);
		IntegerTreeNode node13 = tree.search(13);
		
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
		IntegerBinaryTree tree = createTree(true, 12, 5, 18, 2, 9, 15, 19, 17, 13);
		
		IntegerTreeNode node15 = tree.search(15);		
		
		IntegerTreeNode node13 = tree.search(13);
		
		checkTreeNode(node13, node15, null, null);		
	}
	
	public void deleteCasoAFigura124() {
		IntegerBinaryTree tree = createTree(true, 12, 5, 18, 2, 9, 15, 19, 17);
		
		IntegerTreeNode node12 = tree.search(12);		
		IntegerTreeNode node18 = tree.search(18);		
		IntegerTreeNode node15 = tree.search(15);		
		IntegerTreeNode node19 = tree.search(19);		
		IntegerTreeNode node17 = tree.search(17);

		// caso a figure 12.4
		tree.delete(node15);		
		checkTreeNode(node17, node18, null, null);		
		checkTreeNode(node18, node12, node17, node19);		
	}
	
	public void deleteCasoBFigura124() {
		IntegerBinaryTree tree = createTree(true, 12, 5, 18, 2, 9, 15);
		
		IntegerTreeNode node12 = tree.search(12);		
		IntegerTreeNode node5 = tree.search(5);
		IntegerTreeNode node18 = tree.search(18);		
		IntegerTreeNode node15 = tree.search(15);		

		// caso b figure 12.4
		tree.delete(node18);	
		checkTreeNode(node12, null, node5, node15);
		checkTreeNode(node15, node12, null, null);		
	}
	
	public void deleteCasoCFigura124() {
		IntegerBinaryTree tree = createTree(true, 12, 5, 18, 19, 21);
		
		IntegerTreeNode node12 = tree.search(12);
		IntegerTreeNode node5 = tree.search(5);
		IntegerTreeNode node18 = tree.search(18);		
		IntegerTreeNode node19 = tree.search(19);		
		IntegerTreeNode node21 = tree.search(21);
		
		// caso c figure 12.4
		tree.delete(node12);
		checkTreeNode(node18, null, node5, node19);		
		checkTreeNode(node19, node18, null, node21);		
		checkTreeNode(node21, node19, null, null);		
		checkTreeNode(node5, node18, null, null);		
	}
	
	public void deleteCasoDFigura124() {
		IntegerBinaryTree tree = createTree(true, 8, 5, 18, 16, 14, 15);
		
		IntegerTreeNode node8 = tree.search(8);
		IntegerTreeNode node5 = tree.search(5);
		IntegerTreeNode node18 = tree.search(18);		
		IntegerTreeNode node16 = tree.search(16);
		IntegerTreeNode node14 = tree.search(14);		
		IntegerTreeNode node15 = tree.search(15);		
		
		// caso d figure 12.4
		tree.delete(node8);
		checkTreeNode(node14, null, node5, node18);		
		checkTreeNode(node5, node14, null, null);		
		checkTreeNode(node18, node14, node16, null);
		checkTreeNode(node16, node18, node15, null);
		checkTreeNode(node15, node16, null, null);
	}
	
	public void testInPrePostOrder() {
		IntegerBinaryTree tree = createTree(true, 15, 8, 18, 5, 14, 16, 20);
		System.out.println(tree.sort());
		System.out.println(tree.preorder());
		System.out.println(tree.postorder());		
	}
}
