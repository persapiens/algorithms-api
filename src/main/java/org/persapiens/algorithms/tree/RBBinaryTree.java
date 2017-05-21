package org.persapiens.algorithms.tree;

import lombok.Getter;

/**
 *
 * @author marcelo fernandes
 */
@Getter
public abstract class RBBinaryTree <TN extends RBTreeNode<TN, T>, T extends Comparable> extends BinaryTree <TN, T> {

	private TN nill;
	
	private TN createNill() {
		TN result = createTN(null);
		result.setColor(RBTreeNodeColor.BLACK);
		return result;
	}
	
	public RBBinaryTree() {
		super();
		
		nill = createNill();
		nill.setColor(RBTreeNodeColor.BLACK);
		setRoot(nill);
	}

	public RBBinaryTree(boolean iterativeSearch) {
		super(iterativeSearch);

		nill = createNill();
		setRoot(nill);
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

	@Override
	protected void insert(TN node) {
		TN y = nill;
		TN x = getRoot();
		while (!x.equals(nill)) {
			y = x;
			if (node.getKey().compareTo(x.getKey()) < 0) {
				x = x.getLeft();
			}
			else {
				x = x.getRight();
			}
		}
		node.setParent(y);
		if (y.equals(nill)) {
			setRoot(node);
		}
		else if (node.getKey().compareTo(y.getKey()) < 0) {
			y.setLeft(node);
		}
		else {
			y.setRight(node);
		}
		node.setLeft(nill);
		node.setRight(nill);
		node.setColor(RBTreeNodeColor.RED);
		insertFixup(node);
	}

	private void insertFixup(TN node) {
		while(node.getParent().getColor().equals(RBTreeNodeColor.RED)) {
			if (node.getParent().equals(node.getParent().getParent().getLeft())) {
				TN y = node.getParent().getParent().getRight();
				if (y.getColor().equals(RBTreeNodeColor.RED)) {
					node.getParent().setColor(RBTreeNodeColor.BLACK);
					y.setColor(RBTreeNodeColor.BLACK);
					node.getParent().getParent().setColor(RBTreeNodeColor.RED);
					node = node.getParent().getParent();
				}
				else { 
					if (node.equals(node.getParent().getRight())) {
						node = node.getParent();
						leftRotate(node);
					}
					node.getParent().setColor(RBTreeNodeColor.BLACK);
					node.getParent().getParent().setColor(RBTreeNodeColor.RED);
					rightRotate(node.getParent().getParent());
				}
			}
			else {
				TN y = node.getParent().getParent().getLeft();
				if (y.getColor().equals(RBTreeNodeColor.RED)) {
					node.getParent().setColor(RBTreeNodeColor.BLACK);
					y.setColor(RBTreeNodeColor.BLACK);
					node.getParent().getParent().setColor(RBTreeNodeColor.RED);
					node = node.getParent().getParent();
				}
				else { 
					if (node.equals(node.getParent().getLeft())) {
						node = node.getParent();
						rightRotate(node);
					}
					node.getParent().setColor(RBTreeNodeColor.BLACK);
					node.getParent().getParent().setColor(RBTreeNodeColor.RED);
					leftRotate(node.getParent().getParent());
				}				
			}
		}
		getRoot().setColor(RBTreeNodeColor.BLACK);
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
	
}
