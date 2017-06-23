package org.persapiens.algorithms.graph.search;

import org.persapiens.algorithms.graph.Vertex;
import org.persapiens.algorithms.graph.VertexAndWeight;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
@Test
public class GraphUtil {
	public static VertexAndWeight[] vertexAndWeightArray(Vertex... vertexes) {
		VertexAndWeight[] result = new VertexAndWeight[vertexes.length];
		for (int index = 0; index < vertexes.length; index ++) {
			result[index] = VertexAndWeight.builder()
				.vertex(vertexes[index])
				.w(0)
				.build();
		}
		return result;
	}
	
	public static VertexAndWeight[] vertexAndWeightArray(VertexAndWeight... vertexesAndWeight) {
		VertexAndWeight[] result = new VertexAndWeight[vertexesAndWeight.length];
		for (int index = 0; index < vertexesAndWeight.length; index ++) {
			VertexAndWeight vertexAndWeight = vertexesAndWeight[index];
			result[index] = VertexAndWeight.builder()
				.vertex(vertexAndWeight.getVertex())
				.w(vertexAndWeight.getW())
				.build();
		}
		return result;
	}
	
	public static VertexAndWeight vertexAndWeight(Vertex vertex, int w) {
		return VertexAndWeight.builder()
			.vertex(vertex)
			.w(w)
			.build();
	}
}
