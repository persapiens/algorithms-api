package org.persapiens.algorithms.tree;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 *
 * @author marcelo fernandes
 */
@Builder
@Getter
@AllArgsConstructor
public class BinaryTree <T extends Comparable> {
	private TreeNode<T> root;
	
	private boolean iterativeSearch;
	
	public TreeNode<T> search(T value) {
		TreeNode<T> result;
		if (iterativeSearch) {
			result = iterativeSearch(root, value);
		}
		else {
			result = recursiveSearch(root, value);			
		}
		return result;
	}
	
	private TreeNode<T> iterativeSearch(TreeNode<T> x, T k) {
		while ((x != null) && !k.equals(x.getKey())) {
			if (k.compareTo(x.getKey()) < 0) {
				x = x.getLeft();
			}
			else {
				x = x.getRight();
			}
		}
		
		return x;
	}
	
	private TreeNode<T> recursiveSearch(TreeNode<T> x, T k) {
		TreeNode<T> result;
		
		if ((x == null) || k.equals(x.getKey())) {
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
	private List<T> sort(TreeNode<T> x, List<T> result) {
		if (x != null) {
			result = sort(x.getLeft(), result);
			result.add(x.getKey());
			result = sort(x.getRight(), result);
		}
		
		return result;
	}
	
	public TreeNode<T> minimum() {
		return minimum(root);
	}
	
	private TreeNode<T> minimum(TreeNode<T> node) {
		TreeNode<T> result = node;
		while( (result != null) && (result.getLeft() != null) ) {
			result = result.getLeft();
		}
		return result;
	}
	
	public TreeNode<T> maximum() {
		return maximum(root);
	}
	
	private TreeNode<T> maximum(TreeNode<T> node) {
		TreeNode<T> result = node;
		while( (result != null) && (result.getRight() != null) ) {
			result = result.getRight();
		}
		return result;
	}
	
	public TreeNode<T> successor(TreeNode<T> node) {
		TreeNode<T> result = node;
		if ( (result != null) && (result.getRight() != null) ) {
			result = minimum(result.getRight());
		}
		else {		
			result = (result != null) ? result.getParent() : null;
			while( (result != null) && (node.equals(result.getRight())) ) {
				node = result;
				result = result.getParent();
			}
		}
		return result;
	}
	
	public TreeNode<T> predecessor(TreeNode<T> node) {
		TreeNode<T> result = node;
		if ( (result != null) && (result.getLeft() != null) ) {
			result = maximum(result.getLeft());
		}
		else {		
			result = (result != null) ? result.getParent() : null;
			while( (result != null) && (node.equals(result.getLeft())) ) {
				node = result;
				result = result.getParent();
			}
		}
		return result;
	}
	
	public TreeNode<T> insert(T key) {
		TreeNode<T> result = TreeNode.<T>builder().key(key).build();
		
		insert(result);
		
		return result;
	}
	
	private void insert(TreeNode<T> node) {
		TreeNode<T> y = null;
		TreeNode<T> x = root;
		
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

	private void transplant(TreeNode<T> u, TreeNode<T> v) {
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
	
	public void delete(TreeNode<T> z) {
		if (z.getLeft() == null) {
			transplant(z, z.getRight());
		}
		else if (z.getRight() == null) {
			transplant(z, z.getLeft());
		}
		else {
			TreeNode<T> y =  minimum(z.getRight());
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
