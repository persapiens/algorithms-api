package org.persapiens.algorithms.tree;

/**
 *
 * @author marcelo fernandes
 */
public class IntegerRBTreeNode extends RBTreeNode <IntegerRBTreeNode, Integer> {
	public IntegerRBTreeNode() {
		super();
	}

	public IntegerRBTreeNode(Integer key) {
		super(key);
	}

	public IntegerRBTreeNode(RBTreeNodeType type, Integer key, IntegerRBTreeNode left, IntegerRBTreeNode right, IntegerRBTreeNode parent) {
		super(type, key, left, right, parent);
	}
}
