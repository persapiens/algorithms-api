package org.persapiens.algorithms.tree;

import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
@Test
public class IntegerRBBinaryTreeTest extends AbstractBinaryTreeTest {
	public void example133CormenPage314 () {
		IntegerRBBinaryTree tree = new IntegerRBBinaryTree();
		
		IntegerRBTreeNode node7 = tree.insert(7);
		IntegerRBTreeNode node4 = tree.insert(4);
		IntegerRBTreeNode node11= tree.insert(11);		
		tree.insert(3);
		tree.insert(6);		
		IntegerRBTreeNode node9 = tree.insert(9);		
		IntegerRBTreeNode node18 =tree.insert(18);
		tree.insert(2);
		IntegerRBTreeNode node14 =tree.insert(14);
		IntegerRBTreeNode node19 = tree.insert(19);
		IntegerRBTreeNode node12 = tree.insert(12);
		IntegerRBTreeNode node17 = tree.insert(17);
		IntegerRBTreeNode node22 = tree.insert(22);
		tree.insert(20);
		
		tree.leftRotate(node11);
		
		checkTreeNode(node7, null, node4, node18);		
		checkTreeNode(node18, node7, node11, node19);
		checkTreeNode(node19, node18, null, node22);		
		checkTreeNode(node11, node18, node9, node14);		
		checkTreeNode(node9, node11, null, null);		
		checkTreeNode(node14, node11, node12, node17);
		
		tree.rightRotate(node18);
		
		checkTreeNode(node7, null, node4, node11);		
		checkTreeNode(node11, node7, node9, node18);		
		checkTreeNode(node18, node11, node14, node19);
		checkTreeNode(node19, node18, null, node22);		
		checkTreeNode(node9, node11, null, null);		
		checkTreeNode(node14, node18, node12, node17);
	}
}
