package org.persapiens.algorithms.tree;

/**
 *
 * @author marcelo fernandes
 */
public class IntegerTreeNode extends TreeNode <IntegerTreeNode, Integer> {
	public IntegerTreeNode() {
		super();
	}

	public IntegerTreeNode(Integer key) {
		super(key);
	}

	public IntegerTreeNode(Integer key, IntegerTreeNode left, IntegerTreeNode right, IntegerTreeNode parent) {
		super(key, left, right, parent);
	}
}
