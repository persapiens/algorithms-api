package org.persapiens.algorithms.tree;

import lombok.Getter;

/**
 *
 * @author marcelo fernandes
 */
@Getter
public abstract class RBBinaryTree <TN extends RBTreeNode<TN, T>, T extends Comparable> extends BinaryTree <TN, T> {

	private TN nill;
	
	public RBBinaryTree() {
		super();
		
		nill = createTN(null);
	}

	public RBBinaryTree(boolean iterativeSearch) {
		super(iterativeSearch);
		
		nill = createTN(null);
	}

	public void leftRotate(TN x) {
		TN y = x.getRight();                       // set y
		x.setRight(y.getLeft());                            // turn y's left subtree into x's right subtree
		if (!y.getLeft().equals(nill)) {
			y.getLeft().setParent(x);
		}
		y.setParent(x.getParent());                         // link x's parent to y
		if (x.getParent().equals(nill)) {
			this.setRoot(y);
		}
		else if (x.equals(x.getParent().getLeft())) {
			x.getParent().setLeft(y);
		}
		else {
			x.getParent().setRight(y);
		}
		y.setLeft(x);                                       // put x on y's left
		x.setParent(y);
	}

	public void rightRotate(TN x) {
		TN y = x.getLeft();                       // set y
		x.setLeft(y.getRight());                            // turn y's right subtree into x's left subtree
		if (!y.getRight().equals(nill)) {
			y.getRight().setParent(x);
		}
		y.setParent(x.getParent());                         // link x's parent to y
		if (x.getParent().equals(nill)) {
			this.setRoot(y);
		}
		else if (x.equals(x.getParent().getRight())) {
			x.getParent().setRight(y);
		}
		else {
			x.getParent().setLeft(y);
		}
		y.setRight(x);                                       // put x on y's right
		x.setParent(y);
	}
	
	public void transplant(TN u, TN v) {
		if (u.getParent().equals(nill)) {
			this.setRoot(v);
		}
		else if (u.equals(u.getParent().getLeft())) {
			u.getParent().setLeft(v);
		}
		else {
			u.getParent().setRight(v);
		}
		v.setParent(u.getParent());
	}

	@Override
	protected void insert(TN node) {
		super.insert(node);
	}
	
}
