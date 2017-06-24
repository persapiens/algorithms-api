package org.persapiens.algorithms.graph;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author marcelo
 */
@Getter
@Setter
public class Graph {

	private List<VertexAndAdjacencyList> vertexesAndAdjacencyList = new ArrayList<>();

	public void add(Vertex vertex, VertexAndWeight[] adjacencyList) {
		vertexesAndAdjacencyList.add(VertexAndAdjacencyList.builder()
			.vertex(vertex)
			.adjacencyList(adjacencyList)
			.build());
	}
	
	public Vertex[] getVertexes() {
		Vertex[] result = new Vertex[vertexesAndAdjacencyList.size()];
		for (int index = 0; index < vertexesAndAdjacencyList.size(); index++) {
			result[index] = vertexesAndAdjacencyList.get(index).getVertex();
		}
		return result;
	}
	
	public VertexAndWeight[] getAdjacencyList(Vertex u) {
		return getAdjacencyList(indexOf(u));
	}
	
	public VertexAndWeight[] getAdjacencyList(int index) {
		VertexAndWeight[] result = null;
		if (index != -1) {
			result = vertexesAndAdjacencyList.get(index).getAdjacencyList();
		}
		return result;
	}

	private int indexOf(Vertex u) {
		int result = -1;
		for (int index = 0; index < vertexesAndAdjacencyList.size(); index++) {
			if (vertexesAndAdjacencyList.get(index).getVertex().equals(u)) {
				result = index;
			}
		}
		return result;
	}

	public List<Edge> getEdges(Vertex vertex) {
		List<Edge> result;
		int index = indexOf(vertex);
		if (index != -1) {
			result = getEdges(this.vertexesAndAdjacencyList.get(index));
		}
		else {
			result = new ArrayList<>();
		}
		return result;
	}
	
	public Edge getEdge(Vertex u, Vertex v) {
		Edge result = null;
		List<Edge> edges = getEdges(u);
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
	
	private List<Edge> getEdges(VertexAndAdjacencyList vertexAndAdjacencyList) {
		List<Edge> result = new ArrayList<>();
		for (VertexAndWeight vertexAndWeight : vertexAndAdjacencyList.getAdjacencyList()) {
			result.add(Edge.builder()
				.u(vertexAndAdjacencyList.getVertex())
				.v(vertexAndWeight.getVertex())
				.w(vertexAndWeight.getW())
				.build());
		}
		return result;
	}
	
	public List<Edge> getEdges() {
		List<Edge> result = new ArrayList<>();
		vertexesAndAdjacencyList.forEach((vertexAndAdjacencyList) -> {
			result.addAll(getEdges(vertexAndAdjacencyList));
		});
		return result;
	}
}
