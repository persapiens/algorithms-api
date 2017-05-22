package org.persapiens.algorithms.tree;

import java.lang.reflect.ParameterizedType;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author marcelo
 */
public abstract class AbstractBinaryTreeTest < TREE extends BinaryTree<TN, T>, TN extends TreeNode<TN, T>, T extends Comparable> {
	protected void checkTreeNode(TN node, TN parent
		, TN left, TN right) {
		if (parent == null) {
			assertThat(node.getParent())
				.isNull();
		}
		else {
			assertThat(node.getParent())
				.isEqualTo(parent);
		}
		if (left == null) {
			assertThat(node.getLeft())
				.isNull();
		}
		else {
			assertThat(node.getLeft())
				.isEqualTo(left);
		}
		if (right == null) {
			assertThat(node.getRight())
				.isNull();
		}
		else {
			assertThat(node.getRight())
				.isEqualTo(right);
		}
	}

	private TREE createTree(boolean interativeSearch) {
		TREE result = null;
		
		try {
			Class<TREE> treeClass = (Class<TREE>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
			result = treeClass.newInstance();
			result.setIterativeSearch(interativeSearch);
		} catch (InstantiationException | IllegalAccessException ex) {
			throw new RuntimeException(ex);
		}
				
		return result;
	}
	
	public TREE createTree(boolean interativeSearch, T... keys) {
		TREE tree = createTree(interativeSearch);

		for (T key : keys) {
			tree.insert(key);
		}
		
		return tree;
	}
}
