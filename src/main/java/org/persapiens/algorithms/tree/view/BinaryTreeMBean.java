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
import org.persapiens.algorithms.tree.BinaryTree;
import org.persapiens.algorithms.tree.TreeNode;
import org.primefaces.component.organigram.OrganigramHelper;
import org.primefaces.event.organigram.OrganigramNodeCollapseEvent;
import org.primefaces.event.organigram.OrganigramNodeExpandEvent;
import org.primefaces.event.organigram.OrganigramNodeSelectEvent;
import org.primefaces.model.DefaultOrganigramNode;
import org.primefaces.model.OrganigramNode;

/**
 * BinaryTreeMBean to show graphically.
 * @author Marcelo Fernandes
 */
@Getter
@Setter
@Named
@ViewScoped
public class BinaryTreeMBean implements Serializable {

	private static final long serialVersionUID = 1L;
    private OrganigramNode rootNode;
    private OrganigramNode selection;
 
    private int key = 0;
 
    private String employeeName;

	private BinaryTree<Integer> binaryTree;
	
    @PostConstruct
    public void init() {
		binaryTree = BinaryTree.<Integer>builder().iterativeSearch(true).build();
		binaryTree.insert(10);
		binaryTree.insert(8);
		binaryTree.insert(7);
		binaryTree.insert(9);
		binaryTree.insert(15);
		binaryTree.insert(14);
		binaryTree.insert(16);
		binaryTree.insert(17);
		binaryTree.insert(26);
		binaryTree.insert(22);
		binaryTree.insert(21);
		binaryTree.insert(23);
		binaryTree.insert(30);
		binaryTree.insert(32);
		binaryTree.insert(28);
		binaryTree.insert(29);
		binaryTree.insert(6);
		
		rootNode = buildOrganigram(binaryTree.getRoot(), null);
		
        selection = rootNode;
	}
	
	protected OrganigramNode buildOrganigram(TreeNode<Integer> node, OrganigramNode organigramNodeParent) {
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
			
			if ((node.getLeft() != null) && (node.getRight() == null)) {
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
		TreeNode<Integer> insertedNode = binaryTree.insert(this.key);
		
		rootNode = buildOrganigram(binaryTree.getRoot(), null);
		
        selection = rootNode;
	}
 
    public void deleteKeyAction() {
        // re-evaluate selection - might be a differenct object instance if viewstate serialization is enabled
        OrganigramNode currentSelection = OrganigramHelper.findTreeNode(rootNode, selection);
		
		TreeNode<Integer> treeNode = (TreeNode<Integer>) currentSelection.getData();
		binaryTree.delete(treeNode);
		
		rootNode = buildOrganigram(binaryTree.getRoot(), null);
		
        selection = rootNode;
    }

	/*
    @PostConstruct
    public void init() {
        selection = new DefaultOrganigramNode(null, "Ridvan Agar", null);
 
        rootNode = new DefaultOrganigramNode("root", "CommerceBay GmbH", null);
        rootNode.setCollapsible(false);
        rootNode.setDroppable(true);
 
 
        OrganigramNode softwareDevelopment = addDivision(rootNode, "Software Development", "Ridvan Agar");
 
        OrganigramNode teamJavaEE = addDivision(softwareDevelopment, "Team JavaEE");
        addDivision(teamJavaEE, "JSF", "Thomas Andraschko");
        addDivision(teamJavaEE, "Backend", "Marie Louise");
 
        OrganigramNode teamMobile = addDivision(softwareDevelopment, "Team Mobile");
        addDivision(teamMobile, "Android", "Andy Ruby");
        addDivision(teamMobile, "iOS", "Stevan Jobs");
 
        addDivision(rootNode, "Managed Services", "Thorsten Schultze", "Sandra Becker");
 
        OrganigramNode marketing = addDivision(rootNode, "Marketing");
        addDivision(marketing, "Social Media", "Ali Mente", "Susanne Muster");
        addDivision(marketing, "Press", "Manfred Mustermann", "Hans Peter");
 
        addDivision(rootNode, "Management", "Hassan El Manfalouty");
    }
 
    protected OrganigramNode addDivision(OrganigramNode parent, String name, String... employees) {
        OrganigramNode divisionNode = new DefaultOrganigramNode("division", name, parent);
        divisionNode.setDroppable(true);
        divisionNode.setDraggable(true);
        divisionNode.setSelectable(true);
 
        if (employees != null) {
            for (String employee : employees) {
                OrganigramNode employeeNode = new DefaultOrganigramNode("employee", employee, divisionNode);
                employeeNode.setDraggable(true);
                employeeNode.setSelectable(true);
            }
        }
 
        return divisionNode;
    }
	*/
 
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
 
    public void addEmployee() {
        // re-evaluate selection - might be a differenct object instance if viewstate serialization is enabled
        OrganigramNode currentSelection = OrganigramHelper.findTreeNode(rootNode, selection);
 
        OrganigramNode employee = new DefaultOrganigramNode("employee", employeeName, currentSelection);
        employee.setDraggable(true);
        employee.setSelectable(true);
    }
 
    private void setMessage(String msg, FacesMessage.Severity severity) {
        FacesMessage message = new FacesMessage();
        message.setSummary(msg);
        message.setSeverity(severity);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
