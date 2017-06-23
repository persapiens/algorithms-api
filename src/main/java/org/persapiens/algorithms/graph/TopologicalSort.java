package org.persapiens.algorithms.graph;

import lombok.Getter;
import org.persapiens.algorithms.list.DoubleLinkedList;

/**
 *
 * @author marcelo fernandes
 */
@Getter
public class TopologicalSort implements DepthFirstSearchListener {

	private DoubleLinkedList<Vertex> list = new DoubleLinkedList<>();
	
	@Override
	public void finished(Vertex v) {
		list.insert(v);
	}
	
}
