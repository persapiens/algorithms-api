package org.persapiens.algorithms.tree;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author marcelo fernandes
 */
@Getter
@Setter
public class RBTreeNode <TN extends RBTreeNode<TN, T>, T extends Comparable> extends TreeNode <TN, T> {

	private static final long serialVersionUID = 1L;

	private RBTreeNodeType type;

	public RBTreeNode() {
		super();
	}
	
	public RBTreeNode(T key) {
		super(key);
	}
	
	public RBTreeNode(RBTreeNodeType type, T key, TN left, TN right, TN parent) {
		super(key, left, right, parent);
		this.type = type;
	}

}
