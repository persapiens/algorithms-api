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
public class BellmanFordTest {
	
	private Graph page652Graph () {
		Graph graph = new Graph();
		
		Vertex s = Vertex.builder().label("s").build();
		Vertex t = Vertex.builder().label("t").build();
		Vertex x = Vertex.builder().label("x").build();
		Vertex z = Vertex.builder().label("z").build();
		Vertex y = Vertex.builder().label("y").build();
		
		graph.add(t, GraphUtil.edges(t, new Vertex[]{x,y,z}, 5,8,4));
		graph.add(x, GraphUtil.edges(x, new Vertex[]{t}, 2));
		graph.add(y, GraphUtil.edges(y, new Vertex[]{x,z}, 3,9));
		graph.add(z, GraphUtil.edges(z, new Vertex[]{x,s}, 7,2));
		graph.add(s, GraphUtil.edges(s, new Vertex[]{t,y}, 6,7));
		
		return graph;
	}
	
	public void page652 () {
		BellmanFord bellmanFord = new BellmanFord();

		Graph graph = page652Graph();
		Vertex s = graph.getVertexes()[4];
		
		boolean created = bellmanFord.create(graph, s);
		
		Vertex t = graph.getVertexes()[0];
		Vertex x = graph.getVertexes()[1];
		Vertex z = graph.getVertexes()[3];
		Vertex y = graph.getVertexes()[2];

		/* comentando o resultado do livro
		assertThat(s.getD())
			.isEqualTo(0);
		assertThat(s.getParent())
			.isEqualTo(NIL);
		assertThat(t.getD())
			.isEqualTo(2);
		assertThat(t.getParent())
			.isEqualTo(x);
		assertThat(x.getD())
			.isEqualTo(4);
		assertThat(x.getParent())
			.isEqualTo(y);
		assertThat(z.getD())
			.isEqualTo(2);
		assertThat(z.getParent())
			.isEqualTo(t);
		assertThat(y.getD())
			.isEqualTo(7);
		assertThat(y.getParent())
			.isEqualTo(s);
			*/
		
		assertThat(s.getD())
			.isEqualTo(0);
		assertThat(s.getParent())
			.isEqualTo(NIL);
		assertThat(t.getD())
			.isEqualTo(6);
		assertThat(t.getParent())
			.isEqualTo(s);
		assertThat(x.getD())
			.isEqualTo(10);
		assertThat(x.getParent())
			.isEqualTo(y);
		assertThat(z.getD())
			.isEqualTo(10);
		assertThat(z.getParent())
			.isEqualTo(t);
		assertThat(y.getD())
			.isEqualTo(7);
		assertThat(y.getParent())
			.isEqualTo(s);
		
		assertThat(created)
			.isTrue();
	}
}
