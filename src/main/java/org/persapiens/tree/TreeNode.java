package org.persapiens.tree;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
}
