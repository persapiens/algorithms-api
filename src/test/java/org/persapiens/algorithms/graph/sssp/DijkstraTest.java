package org.persapiens.algorithms.graph.sssp;

import org.persapiens.algorithms.graph.Graph;
import org.persapiens.algorithms.graph.Vertex;
import static org.assertj.core.api.Assertions.assertThat;
import static org.persapiens.algorithms.graph.Vertex.NIL;
import org.persapiens.algorithms.graph.search.GraphUtil;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
@Test
public class DijkstraTest {
	private Graph page659Graph () {
		Graph graph = new Graph();
		
		Vertex s = Vertex.builder().label("s").build();
		Vertex t = Vertex.builder().label("t").build();
		Vertex x = Vertex.builder().label("x").build();
		Vertex z = Vertex.builder().label("z").build();
		Vertex y = Vertex.builder().label("y").build();
		
		graph.add(s, GraphUtil.edges(s, new Vertex[]{t,y}, 10,5));
		graph.add(t, GraphUtil.edges(t, new Vertex[]{x,y}, 1,2));
		graph.add(x, GraphUtil.edges(x, new Vertex[]{z}, 4));
		graph.add(z, GraphUtil.edges(z, new Vertex[]{x,s}, 6,7));
		graph.add(y, GraphUtil.edges(y, new Vertex[]{t,x,z}, 3,9,2));
		
		return graph;
	}
	
	public void page632 () {
		Dijkstra dijkstra = new Dijkstra();

		Graph graph = page659Graph();
		Vertex s = graph.getVertexes()[0];
		
		Vertex[] sssp = dijkstra.create(graph, s);
		
		Vertex t = graph.getVertexes()[1];
		Vertex x = graph.getVertexes()[2];
		Vertex z = graph.getVertexes()[3];
		Vertex y = graph.getVertexes()[4];

		assertThat(sssp[0])
			.isEqualTo(s);
		assertThat(s.getParent())
			.isEqualTo(NIL);
		assertThat(sssp[1])
			.isEqualTo(y);
		assertThat(y.getParent())
			.isEqualTo(s);
		assertThat(sssp[2])
			.isEqualTo(z);
		assertThat(z.getParent())
			.isEqualTo(y);
		assertThat(sssp[3])
			.isEqualTo(t);
		assertThat(t.getParent())
			.isEqualTo(y);
		assertThat(sssp[4])
			.isEqualTo(x);
		assertThat(x.getParent())
			.isEqualTo(t);
		
		assertThat(sssp.length)
			.isEqualTo(5);
	}
}
