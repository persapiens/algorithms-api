package org.persapiens.algorithms.tree;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author marcelo fernandes
 */
@Getter
public abstract class BinaryTree <TN extends TreeNode<TN, T>, T extends Comparable> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Setter(AccessLevel.PROTECTED)
	private TN root;
	
	private boolean iterativeSearch;

	public BinaryTree() {
		this(true);
	}
	
	public BinaryTree(boolean iterativeSearch) {
		this.iterativeSearch = iterativeSearch;
	}
	
	public TN search(T value) {
		TN result;
		if (iterativeSearch) {
			result = iterativeSearch(root, value);
		}
		else {
			result = recursiveSearch(root, value);			
		}
		return result;
	}
	
	private TN iterativeSearch(TN x, T k) {
		while (x != null && !k.equals(x.getKey())) {
			if (k.compareTo(x.getKey()) < 0) {
				x = x.getLeft();
			}
			else {
				x = x.getRight();
			}
		}
		
		return x;
	}
	
	private TN recursiveSearch(TN x, T k) {
		TN result;
		
		if (x == null || k.equals(x.getKey())) {
			result = x;
		}
		else {
			if (k.compareTo(x.getKey()) < 0) {
				result = recursiveSearch(x.getLeft(), k);
			}
			else {
				result = recursiveSearch(x.getRight(), k);
			}
		}
		
		return result;
	}

	public List<T> sort() {
		return sort(root, new ArrayList<>());
	}

	// InorderTreeWalk
	private List<T> sort(TN x, List<T> result) {
		if (x != null) {
			result = sort(x.getLeft(), result);
			result.add(x.getKey());
			result = sort(x.getRight(), result);
		}
		
		return result;
	}
	
	public TN minimum() {
		return minimum(root);
	}
	
	private TN minimum(TN node) {
		TN result = node;
		while( result != null && result.getLeft() != null ) {
			result = result.getLeft();
		}
		return result;
	}
	
	public TN maximum() {
		return maximum(root);
	}
	
	private TN maximum(TN node) {
		TN result = node;
		while( result != null && result.getRight() != null ) {
			result = result.getRight();
		}
		return result;
	}
	
	public TN successor(TN node) {
		TN result = node;
		if ( result != null && result.getRight() != null ) {
			result = minimum(result.getRight());
		}
		else {		
			result = (result != null) ? result.getParent() : null;
			while( result != null && node.equals(result.getRight()) ) {
				node = result;
				result = result.getParent();
			}
		}
		return result;
	}
	
	public TN predecessor(TN node) {
		TN result = node;
		if ( result != null && result.getLeft() != null ) {
			result = maximum(result.getLeft());
		}
		else {		
			result = (result != null) ? result.getParent() : null;
			while( result != null && node.equals(result.getLeft()) ) {
				node = result;
				result = result.getParent();
			}
		}
		return result;
	}
	
	protected TN createTN(T key) {
		TN result = null;
		
		try {
			Class<TN> treeNodeClass = (Class<TN>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
			result = treeNodeClass.newInstance();
			result.setKey(key);
		} catch (InstantiationException | IllegalAccessException ex) {
			throw new RuntimeException(ex);
		}
		
		return result;
	}
	
	public TN insert(T key) {
		TN result = createTN(key);
		
		insert(result);
		
		return result;
	}
	
	protected void insert(TN node) {
		TN y = null;
		TN x = root;
		
		while(x != null) {
			y = x;
			if (node.getKey().compareTo(x.getKey()) < 0) {
				x = x.getLeft();
			}
			else {
				x = x.getRight();
			}
		}
		
		node.setParent(y);
		
		if (y == null) {
			root = node; // tree was empty
		}
		else if (node.getKey().compareTo(y.getKey()) < 0) {
			y.setLeft(node);
		}
		else {
			y.setRight(node);
		}
	}

	private void transplant(TN u, TN v) {
		if (u.getParent() == null) {
			this.root = v;
		}
		else if (u.equals(u.getParent().getLeft())) {
			u.getParent().setLeft(v);
		}
		else {
			u.getParent().setRight(v);
		}
		if (v != null) {
			v.setParent(u.getParent());
		}
	}
	
	public void delete(TN z) {
		if (z.getLeft() == null) {
			transplant(z, z.getRight());
		}
		else if (z.getRight() == null) {
			transplant(z, z.getLeft());
		}
		else {
			TN y =  minimum(z.getRight());
			if (!y.getParent().equals(z)) {
				transplant(y, y.getRight());
				y.setRight(z.getRight());
				y.getRight().setParent(y);
			}
			transplant(z, y);
			y.setLeft(z.getLeft());
			y.getLeft().setParent(y);
		}
	}
}
