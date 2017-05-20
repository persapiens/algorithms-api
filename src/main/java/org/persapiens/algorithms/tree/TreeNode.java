package org.persapiens.algorithms.tree;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author marcelo fernandes
 */
@Getter
@Setter
@Builder
public class TreeNode <T extends Comparable> {
	private T key;
	
	private TreeNode left;
	
	private TreeNode right;
	
	private TreeNode parent;

	@Override
	public String toString() {
		String result = key.toString();
		result += "l" + ((left != null) ? left.getKey().toString() : "");
		//result += "r" + ((right != null) ? right.getKey().toString() : "");
		//result += "p" + ((parent != null) ? parent.getKey().toString() : "");
		return result;
	}
	
	
}
