package org.persapiens.algorithms.tree;

import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
@Test
public class IntegerRBBinaryTreeTest extends AbstractBinaryTreeTest {
	public void example133CormenPage314 () {
		IntegerRedBlackTree tree = new IntegerRedBlackTree();
		
		IntegerRedBlackTreeNode node7 = tree.insert(7);
		IntegerRedBlackTreeNode node4 = tree.insert(4);
		IntegerRedBlackTreeNode node11= tree.insert(11);		
		tree.insert(3);
		tree.insert(6);		
		IntegerRedBlackTreeNode node9 = tree.insert(9);		
		IntegerRedBlackTreeNode node18 =tree.insert(18);
		tree.insert(2);
		IntegerRedBlackTreeNode node14 =tree.insert(14);
		IntegerRedBlackTreeNode node19 = tree.insert(19);
		IntegerRedBlackTreeNode node12 = tree.insert(12);
		IntegerRedBlackTreeNode node17 = tree.insert(17);
		IntegerRedBlackTreeNode node22 = tree.insert(22);
		IntegerRedBlackTreeNode node20 = tree.insert(20);
		
		tree.leftRotate(node11);
				
		checkTreeNode(node7, tree.getNill(), node4, node18);		
		checkTreeNode(node18, node7, node11, node20);
		checkTreeNode(node20, node18, node19, node22);		
		checkTreeNode(node11, node18, node9, node14);		
		checkTreeNode(node9, node11, tree.getNill(), tree.getNill());		
		checkTreeNode(node14, node11, node12, node17);
		
		tree.rightRotate(node18);
		
		checkTreeNode(node7, tree.getNill(), node4, node11);		
		checkTreeNode(node11, node7, node9, node18);		
		checkTreeNode(node18, node11, node14, node20);
		checkTreeNode(node20, node18, node19, node22);		
		checkTreeNode(node9, node11, tree.getNill(), tree.getNill());		
		checkTreeNode(node14, node18, node12, node17);
	}
}
