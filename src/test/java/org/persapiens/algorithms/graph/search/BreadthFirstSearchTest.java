package org.persapiens.algorithms.graph.search;

import org.persapiens.algorithms.graph.Graph;
import org.persapiens.algorithms.graph.Vertex;
import org.persapiens.algorithms.graph.VertexColor;
import static org.assertj.core.api.Assertions.assertThat;
import static org.persapiens.algorithms.graph.Vertex.NIL;
import static org.persapiens.algorithms.graph.VertexColor.BLACK;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
@Test
public class BreadthFirstSearchTest {
	public void page596 () {
		BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();

		Graph graph = new Graph();
		
		Vertex r = Vertex.builder().label("r").build();
		Vertex s = Vertex.builder().label("s").build();
		Vertex t = Vertex.builder().label("t").build();
		Vertex u = Vertex.builder().label("u").build();
		Vertex v = Vertex.builder().label("v").build();
		Vertex w = Vertex.builder().label("w").build();
		Vertex x = Vertex.builder().label("x").build();
		Vertex y = Vertex.builder().label("y").build();
		graph.add(r, GraphUtil.edges(r,s,v));
		graph.add(s, GraphUtil.edges(s,r,w));
		graph.add(t, GraphUtil.edges(t,u,w,x));
		graph.add(u, GraphUtil.edges(u,t,x,y));
		graph.add(v, GraphUtil.edges(v,r));
		graph.add(w, GraphUtil.edges(w,s,t,x));
		graph.add(x, GraphUtil.edges(x,t,u,w,y));
		graph.add(y, GraphUtil.edges(y,u,x));
		
		breadthFirstSearch.search(graph, s);

		checkVertex(r, BLACK, 1, s);
		checkVertex(s, BLACK, 0, NIL);
		checkVertex(t, BLACK, 2, w);
		checkVertex(u, BLACK, 3, t);
		checkVertex(v, BLACK, 2, r);
		checkVertex(w, BLACK, 1, s);
		checkVertex(x, BLACK, 2, w);
		checkVertex(y, BLACK, 3, x);
		
		assertThat(breadthFirstSearch.path(graph, s, y))
			.isEqualTo("swxy");
	}
	
	private void checkVertex(Vertex v, VertexColor color, int d, Vertex parent) {
		assertThat(v.getColor())
			.isEqualTo(color);		
		assertThat(v.getD())
			.isEqualTo(d);		
		assertThat(v.getParent())
			.isEqualTo(parent);		
	}
}
