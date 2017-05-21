package org.persapiens.algorithms.tree;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author marcelo fernandes
 */
@Getter
@Setter
public class TreeNode <TN extends TreeNode<TN, T>, T extends Comparable> implements Serializable {

	private static final long serialVersionUID = 1L;

	private T key;
	
	private TN left;
	
	private TN right;
	
	private TN parent;

	public TreeNode() {
	}
	
	public TreeNode(T key) {
		this.key = key;
	}
	
	public TreeNode(T key, TN left, TN right, TN parent) {
		this.key = key;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
	
	@Override
	public String toString() {
		String result = key.toString();
		//result += "l" + ((left != null) ? left.getKey().toString() : "");
		//result += "r" + ((right != null) ? right.getKey().toString() : "");
		//result += "p" + ((parent != null) ? parent.getKey().toString() : "");
		return result;
	}	
	
}
