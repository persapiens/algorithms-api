package org.persapiens.algorithms.tree;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;
import static org.persapiens.algorithms.tree.RedBlackTreeNodeColor.BLACK;
import static org.persapiens.algorithms.tree.RedBlackTreeNodeColor.RED;

/**
 *
 * @author marcelo
 */
@Test
public class IntegerRedBlackTreeTest extends AbstractBinaryTreeTest<IntegerRedBlackTree, IntegerRedBlackTreeNode, Integer> {

	protected void checkTreeNode(IntegerRedBlackTreeNode node, IntegerRedBlackTreeNode parent, 
			IntegerRedBlackTreeNode left, IntegerRedBlackTreeNode right, RedBlackTreeNodeColor color) {
		checkTreeNode(node, parent, left, right);
		
		assertThat(node.getColor())
				.isEqualTo(color);
	}
	
	private IntegerRedBlackTree example133CormenPage314() {
		return createTree(true, 7, 4, 11, 3, 6, 9, 18, 2, 14, 19, 12, 17, 22, 20);
	}
	
	public void example133CormenPage314LeftRotateRightRotate () {
		IntegerRedBlackTree tree = example133CormenPage314();
		
		IntegerRedBlackTreeNode node7 = tree.search(7);
		IntegerRedBlackTreeNode node4 = tree.search(4);
		IntegerRedBlackTreeNode node11= tree.search(11);		
		IntegerRedBlackTreeNode node9 = tree.search(9);		
		IntegerRedBlackTreeNode node18 =tree.search(18);
		IntegerRedBlackTreeNode node14 =tree.search(14);
		IntegerRedBlackTreeNode node19 = tree.search(19);
		IntegerRedBlackTreeNode node12 = tree.search(12);
		IntegerRedBlackTreeNode node17 = tree.search(17);
		IntegerRedBlackTreeNode node22 = tree.search(22);
		IntegerRedBlackTreeNode node20 = tree.search(20);
		
		tree.leftRotate(node11);
				
		checkTreeNode(node7, tree.getNill(), node4, node18, BLACK);
		checkTreeNode(node18, node7, node11, node20, RED);
		checkTreeNode(node20, node18, node19, node22, BLACK);		
		checkTreeNode(node11, node18, node9, node14, BLACK);		
		checkTreeNode(node9, node11, tree.getNill(), tree.getNill(), BLACK);
		checkTreeNode(node14, node11, node12, node17, BLACK);
		
		tree.rightRotate(node18);
		
		checkTreeNode(node7, tree.getNill(), node4, node11, BLACK);		
		checkTreeNode(node11, node7, node9, node18, BLACK);
		checkTreeNode(node18, node11, node14, node20, RED);
		checkTreeNode(node20, node18, node19, node22, BLACK);		
		checkTreeNode(node9, node11, tree.getNill(), tree.getNill(), BLACK);
		checkTreeNode(node14, node18, node12, node17, BLACK);
	}
	
	public void example133CormenPage314MinimumMaximum () {
		IntegerRedBlackTree tree = example133CormenPage314();
		
		checkTreeNode(tree.minimum(), tree.search(3), tree.getNill(), tree.getNill(), RED);
		checkTreeNode(tree.maximum(), tree.search(20), tree.getNill(), tree.getNill(), RED);
	}
	
	public void threeNodesDeleteRight() {
		IntegerRedBlackTree tree = createTree(true, 7, 4 ,11);
		
		IntegerRedBlackTreeNode node7 = tree.search(7);
		IntegerRedBlackTreeNode node4 = tree.search(4);
		IntegerRedBlackTreeNode node11= tree.search(11);		

		tree.delete(node11);
		
		checkTreeNode(node7, tree.getNill(), node4, tree.getNill(), BLACK);		
		checkTreeNode(node4, node7, tree.getNill(), tree.getNill(), RED);		
	}

	public void threeNodesDeleteLeft() {
		IntegerRedBlackTree tree = createTree(true, 7, 4, 11);
		
		IntegerRedBlackTreeNode node7 = tree.search(7);
		IntegerRedBlackTreeNode node4 = tree.search(4);
		IntegerRedBlackTreeNode node11= tree.search(11);		

		tree.delete(node4);
		
		checkTreeNode(node7, tree.getNill(), tree.getNill(), node11, BLACK);
		checkTreeNode(node11, node7, tree.getNill(), tree.getNill(), RED);		
	}

	public void threeNodesDeleteRoot() {
		IntegerRedBlackTree tree = createTree(true, 7, 4, 11);
		
		IntegerRedBlackTreeNode node7 = tree.search(7);
		IntegerRedBlackTreeNode node4 = tree.search(4);
		IntegerRedBlackTreeNode node11= tree.search(11);		

		tree.delete(node7);
		
		checkTreeNode(node11, tree.getNill(), node4, tree.getNill(), BLACK);
		checkTreeNode(node4, node11, tree.getNill(), tree.getNill(), RED);		
	}
	
	public void example133CormenPage314Delete3() {
		IntegerRedBlackTree tree = example133CormenPage314();
		
		IntegerRedBlackTreeNode node6 = tree.search(6);
		IntegerRedBlackTreeNode node2 = tree.search(2);
		IntegerRedBlackTreeNode node3 = tree.search(3);
		IntegerRedBlackTreeNode node4 = tree.search(4);		
		IntegerRedBlackTreeNode node7 = tree.search(7);

		tree.delete(node3);
		
		checkTreeNode(node4, node7, node2, node6, BLACK);
		checkTreeNode(node2, node4, tree.getNill(), tree.getNill(), BLACK);		
		checkTreeNode(node6, node4, tree.getNill(), tree.getNill(), BLACK);		
	}
	
	public void example133CormenPage314Delete6() {
		IntegerRedBlackTree tree = example133CormenPage314();
		
		IntegerRedBlackTreeNode node6 = tree.search(6);
		IntegerRedBlackTreeNode node2 = tree.search(2);
		IntegerRedBlackTreeNode node3 = tree.search(3);
		IntegerRedBlackTreeNode node4 = tree.search(4);		
		IntegerRedBlackTreeNode node7 = tree.search(7);
		IntegerRedBlackTreeNode node11= tree.search(11);		

		tree.delete(node6);
		
		checkTreeNode(node7, tree.getNill(), node3, node11, BLACK);
		checkTreeNode(node3, node7, node2, node4, BLACK);		
		checkTreeNode(node2, node3, tree.getNill(), tree.getNill(), BLACK);		
		checkTreeNode(node4, node3, tree.getNill(), tree.getNill(), BLACK);		
	}
	
	public void example133CormenPage314Delete9() {
		IntegerRedBlackTree tree = example133CormenPage314();
		
		IntegerRedBlackTreeNode node7 = tree.search(7);
		IntegerRedBlackTreeNode node11= tree.search(11);		
		IntegerRedBlackTreeNode node9 = tree.search(9);
		IntegerRedBlackTreeNode node18 = tree.search(18);
		IntegerRedBlackTreeNode node14 = tree.search(14);
		IntegerRedBlackTreeNode node20 = tree.search(20);
		IntegerRedBlackTreeNode node17 = tree.search(17);
		IntegerRedBlackTreeNode node19 = tree.search(19);
		IntegerRedBlackTreeNode node22 = tree.search(22);

		tree.delete(node9);
		
		checkTreeNode(node18, node7, node14, node20, BLACK);
		checkTreeNode(node14, node18, node11, node17, RED);		
		checkTreeNode(node20, node18, node19, node22, BLACK);		
		checkTreeNode(node19, node20, tree.getNill(), tree.getNill(), RED);		
		checkTreeNode(node22, node20, tree.getNill(), tree.getNill(), RED);		
	}
	
	public void example133CormenPage314Delete18() {
		IntegerRedBlackTree tree = example133CormenPage314();
		
		IntegerRedBlackTreeNode node17 = tree.search(17);
		IntegerRedBlackTreeNode node19 = tree.search(19);
		IntegerRedBlackTreeNode node22 = tree.search(22);
		IntegerRedBlackTreeNode node12= tree.search(12);		
		IntegerRedBlackTreeNode node7 = tree.search(7);
		IntegerRedBlackTreeNode node11= tree.search(11);		
		IntegerRedBlackTreeNode node9 = tree.search(9);
		IntegerRedBlackTreeNode node18 = tree.search(18);
		IntegerRedBlackTreeNode node14 = tree.search(14);
		IntegerRedBlackTreeNode node20 = tree.search(20);

		tree.delete(node18);
		
		checkTreeNode(node11, node7, node9, node19, BLACK);
		checkTreeNode(node9, node11, tree.getNill(), tree.getNill(), BLACK);		
		checkTreeNode(node19, node11, node14, node20, RED);		
		checkTreeNode(node14, node19, node12, node17, BLACK);		
		checkTreeNode(node20, node19, tree.getNill(), node22, BLACK);		
	}
	
	public void example133CormenPage314Delete18e19e20() {
		IntegerRedBlackTree tree = example133CormenPage314();
		
		IntegerRedBlackTreeNode node17 = tree.search(17);
		IntegerRedBlackTreeNode node22 = tree.search(22);
		IntegerRedBlackTreeNode node12= tree.search(12);		
		IntegerRedBlackTreeNode node7 = tree.search(7);
		IntegerRedBlackTreeNode node11= tree.search(11);		
		IntegerRedBlackTreeNode node9 = tree.search(9);
		IntegerRedBlackTreeNode node14 = tree.search(14);

		tree.delete(tree.search(18));
		tree.delete(tree.search(19));
		tree.delete(tree.search(20));
		
		checkTreeNode(node11, node7, node9, node14, BLACK);
		checkTreeNode(node9, node11, tree.getNill(), tree.getNill(), BLACK);		
		checkTreeNode(node14, node11, node12, node22, RED);		
		checkTreeNode(node22, node14, node17, tree.getNill(), BLACK);		
		checkTreeNode(node17, node22, tree.getNill(), tree.getNill(), RED);		
	}
	
	private IntegerRedBlackTree example134CormenPage317() {
		return createTree(true, 11, 2, 14, 1, 7, 15, 5, 8);
	}
	
	public void example134CormenPage317CaseA() {
		IntegerRedBlackTree tree = example134CormenPage317();
		
		IntegerRedBlackTreeNode node4 = tree.insert(4);
		
		IntegerRedBlackTreeNode node5 = tree.search(5);
		IntegerRedBlackTreeNode node2 = tree.search(2);
		IntegerRedBlackTreeNode node7 = tree.search(7);		
		IntegerRedBlackTreeNode node11= tree.search(11);		
		IntegerRedBlackTreeNode node1 = tree.search(1);
		IntegerRedBlackTreeNode node8 = tree.search(8);		
		IntegerRedBlackTreeNode node14 = tree.search(14);		
		
		checkTreeNode(node7, tree.getNill(), node2, node11, BLACK);
		checkTreeNode(node2, node7, node1, node5, RED);		
		checkTreeNode(node11, node7, node8, node14, RED);		
		checkTreeNode(node5, node2, node4, tree.getNill(), BLACK);		
		checkTreeNode(node4, node5, tree.getNill(), tree.getNill(), RED);
	}
	
	private IntegerRedBlackTree example134CormenPage317Invertido() {
		return createTree(true, 11, 2, 20, 1, 15, 25, 14, 16);
	}
	
	public void example134CormenPage317CaseAInvertido() {
		IntegerRedBlackTree tree = example134CormenPage317Invertido();
		
		IntegerRedBlackTreeNode node17 = tree.insert(17);
		
		IntegerRedBlackTreeNode node15 = tree.search(15);
		IntegerRedBlackTreeNode node2 = tree.search(2);
		IntegerRedBlackTreeNode node20 = tree.search(20);
		IntegerRedBlackTreeNode node11= tree.search(11);		
		IntegerRedBlackTreeNode node16 = tree.search(16);
		IntegerRedBlackTreeNode node25 = tree.search(25);		
		IntegerRedBlackTreeNode node14 = tree.search(14);		
		
		checkTreeNode(node15, tree.getNill(), node11, node20, BLACK);		
		checkTreeNode(node20, node15, node16, node25, RED);		
		checkTreeNode(node16, node20, tree.getNill(), node17, BLACK);		
		checkTreeNode(node17, node16, tree.getNill(), tree.getNill(), RED);
		checkTreeNode(node11, node15, node2, node14, RED);
	}
}
