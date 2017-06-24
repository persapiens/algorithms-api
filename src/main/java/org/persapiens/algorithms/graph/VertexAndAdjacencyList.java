package org.persapiens.algorithms.graph;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author marcelo
 */
@Getter
@Setter
@Builder
public class VertexAndAdjacencyList {
	private Vertex vertex;
	
	private Edge[] adjacencyList;
}
