package org.persapiens.algorithms.tree;

import java.util.List;
import lombok.Getter;
import static org.persapiens.algorithms.tree.RedBlackTreeNodeColor.BLACK;
import static org.persapiens.algorithms.tree.RedBlackTreeNodeColor.RED;

/**
 *
 * @author marcelo fernandes
 */
@Getter
public abstract class RedBlackTree <TN extends RedBlackTreeNode<TN, T>, T extends Comparable> extends BinaryTree <TN, T> {

	private TN nill;
	
	private TN createNill() {
		TN result = createTN(null);
		result.setColor(BLACK);
		return result;
	}
	
	public RedBlackTree() {
		super();
		
		nill = createNill();
		setRoot(nill);
	}

	public RedBlackTree(boolean iterativeSearch) {
		super(iterativeSearch);

		nill = createNill();
		setRoot(nill);
	}

	public void leftRotate(TN x) {
		TN y = x.getRight();								// set y
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
		TN y = x.getLeft();									// set y
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
		node.setColor(RED);
		insertFixup(node);
	}

	private TN insertFixupLeft(TN node) {
		TN y = node.getParent().getParent().getRight();
		if (y.getColor().isRed()) {
			node.getParent().setColor(BLACK);				// caso 1
			y.setColor(BLACK);								// caso 1
			node.getParent().getParent().setColor(RED);		// caso 1
			node = node.getParent().getParent();			// caso 1
		}
		else { 
			if (node.equals(node.getParent().getRight())) {
				node = node.getParent();					// caso 2
				leftRotate(node);							// caso 2
			}
			node.getParent().setColor(BLACK);				// caso 3
			node.getParent().getParent().setColor(RED);		// caso 3
			rightRotate(node.getParent().getParent());		// caso 3
		}
		return node;
	}
	
	private TN insertFixupRight(TN node) {
		TN y = node.getParent().getParent().getLeft();
		if (y.getColor().isRed()) {
			node.getParent().setColor(BLACK);				// caso 1
			y.setColor(BLACK);								// caso 1
			node.getParent().getParent().setColor(RED);		// caso 1
			node = node.getParent().getParent();			// caso 1
		}
		else { 
			if (node.equals(node.getParent().getLeft())) {
				node = node.getParent();					// caso 2
				rightRotate(node);							// caso 2
			}
			node.getParent().setColor(BLACK);				// caso 3
			node.getParent().getParent().setColor(RED);		// caso 3
			leftRotate(node.getParent().getParent());		// caso 3
		}				
		return node;		
	}
	
	private void insertFixup(TN node) {
		while(node.getParent().getColor().isRed()) {
			if (node.getParent().equals(node.getParent().getParent().getLeft())) {
				node = insertFixupLeft(node);
			}
			else {
				node = insertFixupRight(node);
			}
		}
		getRoot().setColor(BLACK);
	}

	@Override
	public void delete(TN node) {
		TN x;
		TN y = node;
		RedBlackTreeNodeColor yOriginalColor = y.getColor();
		if (node.getLeft().equals(nill)) {
			x = node.getRight();
			transplant(node, node.getRight());
		}
		else if (node.getRight().equals(nill)) {
			x = node.getLeft();
			transplant(node, node.getLeft());
		}
		else {
			y = minimum(node.getRight());
			yOriginalColor = y.getColor();
			x = y.getRight();
			if (y.getParent().equals(node)) {
				x.setParent(y);
			}
			else {
				transplant(y, y.getRight());
				y.setRight(node.getRight());
				y.getRight().setParent(y);
			}
			transplant(node, y);
			y.setLeft(node.getLeft());
			y.getLeft().setParent(y);
			y.setColor(node.getColor());
		}
		if (yOriginalColor.isBlack()) {
			deleteFixup(x);
		}
	}

	private TN deleteFixupLeft(TN x) {
		TN w = x.getParent().getRight();
		if (w.getColor().isRed()) {
			w.setColor(BLACK);										// caso 1
			x.getParent().setColor(RED);							// caso 1
			leftRotate(x.getParent());								// caso 1
			w = x.getParent().getRight();							// caso 1
		}
		if (w.getLeft().getColor().isBlack() && w.getRight().getColor().isBlack()) {
			w.setColor(RED);										// caso 2
			x = x.getParent();										// caso 2
		}
		else { 
			if (w.getRight().getColor().isBlack()) {
				w.getLeft().setColor(BLACK);						// caso 3
				w.setColor(RED);									// caso 3
				rightRotate(w);										// caso 3
				w = x.getParent().getRight();						// caso 3
			}
			w.setColor(x.getParent().getColor());					// caso 4
			x.getParent().setColor(BLACK);							// caso 4
			w.getRight().setColor(BLACK);							// caso 4
			leftRotate(x.getParent());								// caso 4
			x = getRoot();											// caso 4
		}
		return x;
	}
	
	private TN deleteFixupRight(TN x) {
		TN w = x.getParent().getLeft();
		if (w.getColor().isRed()) {
			w.setColor(BLACK);										// caso 1
			x.getParent().setColor(RED);							// caso 1
			rightRotate(x.getParent());								// caso 1
			w = x.getParent().getLeft();							// caso 1
		}
		if (w.getLeft().getColor().isBlack() && w.getRight().getColor().isBlack()) {
			w.setColor(RED);										// caso 2
			x = x.getParent();										// caso 2
		}
		else { 
			if (w.getLeft().getColor().isBlack()) {
				w.getRight().setColor(BLACK);						// caso 3
				w.setColor(RED);									// caso 3
				leftRotate(w);										// caso 3
				w = x.getParent().getLeft();						// caso 3
			}
			w.setColor(x.getParent().getColor());					// caso 4
			x.getParent().setColor(BLACK);							// caso 4
			w.getLeft().setColor(BLACK);							// caso 4
			rightRotate(x.getParent());								// caso 4
			x = getRoot();											// caso 4
		}				
		return x;
	}
	
	private void deleteFixup(TN x) {
		while (!x.equals(getRoot()) && x.getColor().isBlack()) {
			if (x.equals(x.getParent().getLeft())) {
				x = deleteFixupLeft(x);
			}
			else {
				x = deleteFixupRight(x);
			}
		}
		x.setColor(BLACK);
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
	public TN minimum(TN node) {
		TN result = node;
		while( !result.getLeft().equals(nill) ) {
			result = result.getLeft();
		}
		return result;
	}

	@Override
	public TN maximum(TN node) {
		TN result = node;
		while( !result.getRight().equals(nill) ) {
			result = result.getRight();
		}
		return result;
	}

	public boolean isEmpty() {
		return this.getRoot().equals(this.nill);
	}

	public int getBlackHeight(TN node) {
		TN initialNode = node;
		int result = 0;
		while (!node.equals(this.nill))
		{
			if (!node.equals(initialNode) && node.getColor().equals(BLACK)) {
				result ++;
			}
			node = node.getLeft();
		}
		return result;
	}

	@Override
	protected List<T> sort(TN x, List<T> result) {
		if (!x.equals(this.nill)) {
			result = sort(x.getLeft(), result);
			result.add(x.getKey());
			result = sort(x.getRight(), result);
		}
		
		return result;
	}
	
	@Override
	protected List<TN> preorder(TN x, List<TN> result) {
		if (!x.equals(this.nill)) {
			result.add(x);
			result = preorder(x.getLeft(), result);
			result = preorder(x.getRight(), result);
		}
		
		return result;
	}

	@Override
	protected List<TN> postorder(TN x, List<TN> result) {
		if (!x.equals(this.nill)) {
			result = postorder(x.getLeft(), result);
			result = postorder(x.getRight(), result);
			result.add(x);
		}
		
		return result;
	}
	
}
