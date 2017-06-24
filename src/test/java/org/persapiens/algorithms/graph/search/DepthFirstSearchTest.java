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
public class DepthFirstSearchTest {
	public void page605 () {
		DepthFirstSearch depthFirstSearch = new DepthFirstSearch();

		Graph graph = new Graph();
		
		Vertex u = Vertex.builder().label("u").build();
		Vertex v = Vertex.builder().label("v").build();
		Vertex w = Vertex.builder().label("w").build();
		Vertex x = Vertex.builder().label("x").build();
		Vertex y = Vertex.builder().label("y").build();
		Vertex z = Vertex.builder().label("z").build();
		graph.add(u, GraphUtil.edges(u,v,x));
		graph.add(v, GraphUtil.edges(v,y));
		graph.add(w, GraphUtil.edges(w,y,z));
		graph.add(x, GraphUtil.edges(x,v));
		graph.add(y, GraphUtil.edges(y,x));
		graph.add(z, GraphUtil.edges(z,z));
		
		depthFirstSearch.search(graph);

		checkVertex(u, BLACK, 1, 8, NIL);
		checkVertex(v, BLACK, 2, 7, u);
		checkVertex(w, BLACK, 9, 12, NIL);
		checkVertex(x, BLACK, 4, 5, y);
		checkVertex(y, BLACK, 3, 6, v);
		checkVertex(z, BLACK, 10, 11, w);
	}
	
	private void checkVertex(Vertex v, VertexColor color, int d, int f, Vertex parent) {
		assertThat(v.getColor())
			.isEqualTo(color);		
		assertThat(v.getD())
			.isEqualTo(d);		
		assertThat(v.getF())
			.isEqualTo(f);		
		assertThat(v.getParent())
			.isEqualTo(parent);		
	}
}
