package org.persapiens.algorithms.tree;

/**
 *
 * @author marcelo fernandes
 */
public class StringRedBlackTreeNode extends RedBlackTreeNode <StringRedBlackTreeNode, String> {
	public StringRedBlackTreeNode() {
		super();
	}

	public StringRedBlackTreeNode(String key) {
		super(key);
	}

	public StringRedBlackTreeNode(RedBlackTreeNodeColor type, String key, StringRedBlackTreeNode left, StringRedBlackTreeNode right, StringRedBlackTreeNode parent) {
		super(type, key, left, right, parent);
	}
}
