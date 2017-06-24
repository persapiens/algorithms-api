package org.persapiens.algorithms.graph.mst;

import org.persapiens.algorithms.graph.Graph;
import org.persapiens.algorithms.graph.Vertex;
import org.persapiens.algorithms.graph.VertexAndWeight;
import org.persapiens.algorithms.graph.search.GraphUtil;

/**
 *
 * @author marcelo
 */
public class GraphFactory {
	public static Graph page635 () {
		Graph graph = new Graph();
		
		Vertex a = Vertex.builder().label("a").build();
		Vertex b = Vertex.builder().label("b").build();
		Vertex c = Vertex.builder().label("c").build();
		Vertex d = Vertex.builder().label("d").build();
		Vertex e = Vertex.builder().label("e").build();
		Vertex f = Vertex.builder().label("f").build();
		Vertex g = Vertex.builder().label("g").build();
		Vertex h = Vertex.builder().label("h").build();
		Vertex i = Vertex.builder().label("i").build();
		
		graph.add(a, GraphUtil.vertexAndWeightArray(
			GraphUtil.vertexAndWeight(b,4),
			GraphUtil.vertexAndWeight(h, 8)));
		graph.add(b, GraphUtil.vertexAndWeightArray(
			GraphUtil.vertexAndWeight(a, 4),
			GraphUtil.vertexAndWeight(c, 8),
			GraphUtil.vertexAndWeight(h, 11)));
		graph.add(c, GraphUtil.vertexAndWeightArray(
			GraphUtil.vertexAndWeight(b, 8),
			GraphUtil.vertexAndWeight(d, 7),
			GraphUtil.vertexAndWeight(f, 4),
			GraphUtil.vertexAndWeight(i, 2)));
		graph.add(d, GraphUtil.vertexAndWeightArray(
			GraphUtil.vertexAndWeight(c, 7),
			GraphUtil.vertexAndWeight(e, 9),
			GraphUtil.vertexAndWeight(f, 14)));
		graph.add(e, GraphUtil.vertexAndWeightArray(
			GraphUtil.vertexAndWeight(d, 9),
			GraphUtil.vertexAndWeight(f, 10)));
		graph.add(f, GraphUtil.vertexAndWeightArray(
			GraphUtil.vertexAndWeight(c, 4),
			GraphUtil.vertexAndWeight(d, 14),
			GraphUtil.vertexAndWeight(e, 10),
			GraphUtil.vertexAndWeight(g, 2)));
		graph.add(g, GraphUtil.vertexAndWeightArray(
			GraphUtil.vertexAndWeight(f, 2),
			GraphUtil.vertexAndWeight(h, 1),
			GraphUtil.vertexAndWeight(i, 6)));
		graph.add(h, GraphUtil.vertexAndWeightArray(
			GraphUtil.vertexAndWeight(a, 8),
			GraphUtil.vertexAndWeight(b, 11),
			GraphUtil.vertexAndWeight(g, 1),			
			GraphUtil.vertexAndWeight(i, 7)));
		graph.add(i, new VertexAndWeight[] {});
		
		return graph;
	}
}
