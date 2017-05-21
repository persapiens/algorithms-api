package org.persapiens.algorithms.tree;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author marcelo fernandes
 */
@Getter
@Setter
public class RedBlackTreeNode <TN extends RedBlackTreeNode<TN, T>, T extends Comparable> extends TreeNode <TN, T> {

	private static final long serialVersionUID = 1L;

	private RedBlackTreeNodeColor color;

	public RedBlackTreeNode() {
		super();
	}
	
	public RedBlackTreeNode(T key) {
		super(key);
	}
	
	public RedBlackTreeNode(RedBlackTreeNodeColor color, T key, TN left, TN right, TN parent) {
		super(key, left, right, parent);
		this.color = color;
	}

}
