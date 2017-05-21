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

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import org.persapiens.algorithms.tree.IntegerBinaryTree;
import org.persapiens.algorithms.tree.IntegerTreeNode;
import org.persapiens.algorithms.tree.TreeNode;
import org.primefaces.component.organigram.OrganigramHelper;
import org.primefaces.event.organigram.OrganigramNodeCollapseEvent;
import org.primefaces.event.organigram.OrganigramNodeExpandEvent;
import org.primefaces.event.organigram.OrganigramNodeSelectEvent;
import org.primefaces.model.DefaultOrganigramNode;
import org.primefaces.model.OrganigramNode;

/**
 * IntegerBinaryTreeMBean to show graphically.
 * @author Marcelo Fernandes
 */
@Getter
@Setter
@Named
@ViewScoped
public class IntegerBinaryTreeMBean implements Serializable {

	private static final long serialVersionUID = 1L;

    private OrganigramNode rootNode;
    private OrganigramNode selection;
 
    private int key = 0;

	private IntegerBinaryTree tree;
	
    @PostConstruct
    public void init() {
		tree = new IntegerBinaryTree();
		tree.insert(10);
		tree.insert(8);
		tree.insert(7);
		tree.insert(9);
		tree.insert(15);
		tree.insert(14);
		tree.insert(16);
		tree.insert(17);
		tree.insert(26);
		tree.insert(22);
		tree.insert(21);
		tree.insert(23);
		tree.insert(30);
		tree.insert(32);
		tree.insert(28);
		tree.insert(29);
		tree.insert(6);
		
		rootNode = buildOrganigram(tree.getRoot(), null);
		
        selection = rootNode;
	}
	
	protected OrganigramNode buildOrganigram(TreeNode node, OrganigramNode organigramNodeParent) {
		OrganigramNode organigramNode = null;
		if (node != null) {
			organigramNode = new DefaultOrganigramNode("employee", node, organigramNodeParent);
			organigramNode.setCollapsible(true);
			organigramNode.setDroppable(false);
			organigramNode.setSelectable(true);
			organigramNode.setExpanded(true);
			organigramNode.setDraggable(false);

			buildOrganigram(node.getLeft(), organigramNode);
			OrganigramNode organigramNodeRight =  buildOrganigram(node.getRight(), organigramNode);
			
			if (node.getLeft() != null && node.getRight() == null) {
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
	
	public void addKeyAction() {
		tree.insert(this.key);
		
		rootNode = buildOrganigram(tree.getRoot(), null);
		
        selection = rootNode;
	}
 
    public void deleteKeyAction() {
        // re-evaluate selection - might be a differenct object instance if viewstate serialization is enabled
        OrganigramNode currentSelection = OrganigramHelper.findTreeNode(rootNode, selection);
		
		IntegerTreeNode treeNode = (IntegerTreeNode) currentSelection.getData();
		tree.delete(treeNode);
		
		rootNode = buildOrganigram(tree.getRoot(), null);
		
        selection = rootNode;
    }
 
    public void nodeSelectListener(OrganigramNodeSelectEvent event) {
        FacesMessage message = new FacesMessage();
        message.setSummary("Node '" + event.getOrganigramNode().getData() + "' selected.");
        message.setSeverity(FacesMessage.SEVERITY_INFO);
 
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
 
    public void nodeCollapseListener(OrganigramNodeCollapseEvent event) {
        FacesMessage message = new FacesMessage();
        message.setSummary("Node '" + event.getOrganigramNode().getData() + "' collapsed.");
        message.setSeverity(FacesMessage.SEVERITY_INFO);
 
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
 
    public void nodeExpandListener(OrganigramNodeExpandEvent event) {
        FacesMessage message = new FacesMessage();
        message.setSummary("Node '" + event.getOrganigramNode().getData() + "' expanded.");
        message.setSeverity(FacesMessage.SEVERITY_INFO);
 
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
