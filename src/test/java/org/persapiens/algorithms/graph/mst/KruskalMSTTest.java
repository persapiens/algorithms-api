package org.persapiens.algorithms.graph.mst;

import java.util.Set;
import org.persapiens.algorithms.graph.Graph;
import org.persapiens.algorithms.graph.Vertex;
import static org.assertj.core.api.Assertions.assertThat;
import org.persapiens.algorithms.graph.Edge;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
@Test
public class KruskalMSTTest {
	public void page632 () {
		KruskalMST kruskal = new KruskalMST();

		Graph graph = GraphFactory.page635();
		
		Set<Edge> mst = kruskal.create(graph);
		
		Vertex a = graph.getVertexes()[0];
		Vertex b = graph.getVertexes()[1];
		Vertex c = graph.getVertexes()[2];
		Vertex d = graph.getVertexes()[3];
		Vertex e = graph.getVertexes()[4];
		Vertex f = graph.getVertexes()[5];
		Vertex g = graph.getVertexes()[6];
		Vertex h = graph.getVertexes()[7];
		Vertex i = graph.getVertexes()[8];

		assertThat(mst)
			.contains(graph.getEdge(a,b));
		assertThat(mst)
			.contains(graph.getEdge(a,h));
		assertThat(mst)
			.contains(graph.getEdge(c,f));
		assertThat(mst)
			.contains(graph.getEdge(c,i));
		assertThat(mst)
			.contains(graph.getEdge(d,c));
		assertThat(mst)
			.contains(graph.getEdge(d,e));
		assertThat(mst)
			.contains(graph.getEdge(f,g));
		assertThat(mst)
			.contains(graph.getEdge(g,h));
		
		assertThat(mst.size())
			.isEqualTo(8);
	}
}
