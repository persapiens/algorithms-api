package org.persapiens.algorithms.graph.mst;

import java.util.Set;
import org.persapiens.algorithms.graph.search.*;
import org.persapiens.algorithms.graph.Graph;
import org.persapiens.algorithms.graph.Vertex;
import static org.assertj.core.api.Assertions.assertThat;
import org.persapiens.algorithms.graph.Edge;
import org.persapiens.algorithms.graph.VertexAndWeight;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
@Test
public class KruskalMSTTest {
	public void page632 () {
		KruskalMST kruskal = new KruskalMST();

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
			GraphUtil.vertexAndWeight(c, 8),
			GraphUtil.vertexAndWeight(h, 11)));
		graph.add(c, GraphUtil.vertexAndWeightArray(
			GraphUtil.vertexAndWeight(d, 7),
			GraphUtil.vertexAndWeight(f, 4),
			GraphUtil.vertexAndWeight(i, 2)));
		graph.add(d, GraphUtil.vertexAndWeightArray(
			GraphUtil.vertexAndWeight(e, 9),
			GraphUtil.vertexAndWeight(f, 14)));
		graph.add(e, GraphUtil.vertexAndWeightArray(
			GraphUtil.vertexAndWeight(f, 10)));
		graph.add(f, GraphUtil.vertexAndWeightArray(
			GraphUtil.vertexAndWeight(g, 2)));
		graph.add(g, GraphUtil.vertexAndWeightArray(
			GraphUtil.vertexAndWeight(h, 1),
			GraphUtil.vertexAndWeight(i, 6)));
		graph.add(h, GraphUtil.vertexAndWeightArray(
			GraphUtil.vertexAndWeight(i, 7)));
		graph.add(i, new VertexAndWeight[] {});
		
		Set<Edge> mst = kruskal.create(graph);

		assertThat(mst)
			.containsAll(graph.getEdges(a));
		assertThat(mst)
			.containsAll(graph.getEdges(c));
		assertThat(mst)
			.contains(graph.getEdges(d).get(0));
		assertThat(mst)
			.containsAll(graph.getEdges(f));
		assertThat(mst)
			.contains(graph.getEdges(g).get(0));
		
		assertThat(mst.size())
			.isEqualTo(8);
	}
}
