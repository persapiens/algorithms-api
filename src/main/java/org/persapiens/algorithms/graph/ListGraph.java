package org.persapiens.algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author marcelo
 */
public class ListGraph {

	private VertexAndAdjacencyList[] vertexesAndAdjacencyList = new VertexAndAdjacencyList[0];

	public void add(Vertex vertex, Edge... edges) {
		VertexAndAdjacencyList[] newResult = new VertexAndAdjacencyList[vertexesAndAdjacencyList.length+1];
		System.arraycopy(this.vertexesAndAdjacencyList, 0, newResult, 0, this.vertexesAndAdjacencyList.length);
		newResult[newResult.length-1] = VertexAndAdjacencyList.builder()
			.vertex(vertex)
			.adjacencyList(edges)
			.build();
		vertexesAndAdjacencyList = newResult;
	}
	
	public Vertex[] getVertexes() {
		Vertex[] result = new Vertex[vertexesAndAdjacencyList.length];
		for (int index = 0; index < vertexesAndAdjacencyList.length; index++) {
			result[index] = vertexesAndAdjacencyList[index].getVertex();
		}
		return result;
	}
	
	public Edge[] getAdjacencyList(Vertex u) {
		return getAdjacencyList(indexOf(u));
	}
	
	public Edge[] getAdjacencyList(int index) {
		Edge[] result = null;
		if (index != -1) {
			result = vertexesAndAdjacencyList[index].getAdjacencyList();
		}
		return result;
	}

	private int indexOf(Vertex u) {
		int result = -1;
		for (int index = 0; index < vertexesAndAdjacencyList.length; index++) {
			if (vertexesAndAdjacencyList[index].getVertex().equals(u)) {
				result = index;
			}
		}
		return result;
	}

	public Edge[] getEdges(Vertex vertex) {
		Edge[] result;
		int index = indexOf(vertex);
		if (index != -1) {
			result = this.vertexesAndAdjacencyList[index].getAdjacencyList();
		}
		else {
			result = new Edge[0];
		}
		return result;
	}
	
	public Edge getEdge(Vertex u, Vertex v) {
		Edge result = null;
		Edge[] edges = getEdges(u);
		if (edges != null) {
			for (Edge edge : edges) {
				if (edge.getV().equals(v)) {
					result = edge;
					break;
				}
			}
		}
		return result;
	}
	
	public List<Edge> getEdges() {
		List<Edge> result = new ArrayList<>();
		for(VertexAndAdjacencyList vertexAndAdjacencyList : vertexesAndAdjacencyList) {
			result.addAll(Arrays.asList(vertexAndAdjacencyList.getAdjacencyList()));
		}
		return result;
	}
}
