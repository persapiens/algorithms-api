package org.persapiens.algorithms.tree;

/**
 *
 * @author marcelo fernandes
 */
public class StringTreeNode extends TreeNode <StringTreeNode, String> {
	public StringTreeNode() {
		super();
	}

	public StringTreeNode(String key) {
		super(key);
	}

	public StringTreeNode(String key, StringTreeNode left, StringTreeNode right, StringTreeNode parent) {
		super(key, left, right, parent);
	}
}
