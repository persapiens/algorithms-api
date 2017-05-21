/*
 * Copyright 2016-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.persapiens.algorithms.tree.view;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import org.persapiens.algorithms.tree.IntegerRedBlackTree;
import org.persapiens.algorithms.tree.IntegerRedBlackTreeNode;
import org.primefaces.model.DefaultOrganigramNode;
import org.primefaces.model.OrganigramNode;

/**
 * RBBinaryTreeMBean to show graphically.
 * @author Marcelo Fernandes
 */
@Getter
@Setter
@Named
@ViewScoped
public class IntegerRedBlackTreeMBean extends AbstractIntegerTreeMBean<IntegerRedBlackTree, IntegerRedBlackTreeNode> {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected IntegerRedBlackTree initTree() {
		IntegerRedBlackTree tree = new IntegerRedBlackTree();
		tree.insert(7);
		tree.insert(4);
		tree.insert(11);		
		tree.insert(3);
		tree.insert(6);		
		tree.insert(9);		
		tree.insert(18);
		tree.insert(2);
		tree.insert(14);
		tree.insert(19);
		tree.insert(12);
		tree.insert(17);
		tree.insert(22);
		tree.insert(20);
		
		return tree;
	}

	@Override
	protected OrganigramNode buildOrganigram(IntegerRedBlackTreeNode node, OrganigramNode organigramNodeParent) {
		OrganigramNode organigramNode = null;
		if (node != null && !node.equals(getTree().getNill()) ){
			organigramNode = new DefaultOrganigramNode(node.getColor().toString().toLowerCase(), node, organigramNodeParent);
			organigramNode.setCollapsible(true);
			organigramNode.setDroppable(false);
			organigramNode.setSelectable(true);
			organigramNode.setExpanded(true);
			organigramNode.setDraggable(false);

			buildOrganigram(node.getLeft(), organigramNode);
			OrganigramNode organigramNodeRight =  buildOrganigram(node.getRight(), organigramNode);
			
			if (node.getLeft() != null && (node.getRight() == null || node.getRight().equals(getTree().getNill())) ) {
				buildOrganigram(null, organigramNodeRight);
				buildOrganigram(null, organigramNodeRight);
			} 
		}
		else {
			organigramNode = new DefaultOrganigramNode("division", "", organigramNodeParent);
			organigramNode.setCollapsible(true);
			organigramNode.setDroppable(false);
			organigramNode.setSelectable(false);
			organigramNode.setExpanded(false);
			organigramNode.setDraggable(false);			
		}
		return organigramNode;
	}
}
