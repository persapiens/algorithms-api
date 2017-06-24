package org.persapiens.algorithms.graph.mst;

import org.persapiens.algorithms.graph.ListGraph;
import org.persapiens.algorithms.graph.Vertex;
import static org.assertj.core.api.Assertions.assertThat;
import static org.persapiens.algorithms.graph.Vertex.NIL;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
@Test
public class PrimMSTTest {
	public void page635 () {
		PrimMST prim = new PrimMST();

		ListGraph graph = GraphFactory.page635Graph();
		Vertex a = graph.getVertexes()[0];
		
		prim.create(graph, a);
		
		Vertex b = graph.getVertexes()[1];
		Vertex c = graph.getVertexes()[2];
		Vertex d = graph.getVertexes()[3];
		Vertex e = graph.getVertexes()[4];
		Vertex f = graph.getVertexes()[5];
		Vertex g = graph.getVertexes()[6];
		Vertex h = graph.getVertexes()[7];
		Vertex i = graph.getVertexes()[8];

		assertThat(a.getParent())
			.isEqualTo(NIL);		
		assertThat(b.getParent())
			.isEqualTo(a);		
		assertThat(c.getParent())
			.isEqualTo(f);		
		assertThat(d.getParent())
			.isEqualTo(c);		
		assertThat(e.getParent())
			.isEqualTo(d);		
		assertThat(f.getParent())
			.isEqualTo(g);		
		assertThat(g.getParent())
			.isEqualTo(h);		
		assertThat(h.getParent())
			.isEqualTo(a);		
		assertThat(i.getParent())
			.isEqualTo(c);		
	}
}
