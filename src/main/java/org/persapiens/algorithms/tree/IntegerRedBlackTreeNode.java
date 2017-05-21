package org.persapiens.algorithms.tree;

/**
 *
 * @author marcelo fernandes
 */
public class IntegerRedBlackTreeNode extends RedBlackTreeNode <IntegerRedBlackTreeNode, Integer> {
	public IntegerRedBlackTreeNode() {
		super();
	}

	public IntegerRedBlackTreeNode(Integer key) {
		super(key);
	}

	public IntegerRedBlackTreeNode(RedBlackTreeNodeColor type, Integer key, IntegerRedBlackTreeNode left, IntegerRedBlackTreeNode right, IntegerRedBlackTreeNode parent) {
		super(type, key, left, right, parent);
	}
}
