package org.persapiens.algorithms.graph.mst;

import org.persapiens.algorithms.graph.ListGraph;
import org.persapiens.algorithms.graph.Vertex;
import org.persapiens.algorithms.graph.search.GraphUtil;

/**
 *
 * @author marcelo
 */
public class GraphFactory {
	public static ListGraph page635Graph () {
		ListGraph graph = new ListGraph();
		
		Vertex a = Vertex.builder().label("a").build();
		Vertex b = Vertex.builder().label("b").build();
		Vertex c = Vertex.builder().label("c").build();
		Vertex d = Vertex.builder().label("d").build();
		Vertex e = Vertex.builder().label("e").build();
		Vertex f = Vertex.builder().label("f").build();
		Vertex g = Vertex.builder().label("g").build();
		Vertex h = Vertex.builder().label("h").build();
		Vertex i = Vertex.builder().label("i").build();
		
		graph.add(a, GraphUtil.edges(a, new Vertex[]{b,h}, 4,8));
		graph.add(b, GraphUtil.edges(b, new Vertex[]{a,c,h}, 4,8,11)); 
		graph.add(c, GraphUtil.edges(c, new Vertex[]{b,d,f,i}, 8,7,4,2));
		graph.add(d, GraphUtil.edges(d, new Vertex[]{c,e,f}, 7,9,14));
		graph.add(e, GraphUtil.edges(e, new Vertex[]{d,f}, 9,10));
		graph.add(f, GraphUtil.edges(f, new Vertex[]{c,d,e,g}, 4,14,10,2));
		graph.add(g, GraphUtil.edges(g, new Vertex[]{f,h,i}, 2,1,6));
		graph.add(h, GraphUtil.edges(h, new Vertex[]{a,b,g,i}, 8,11,1,7));
		graph.add(i, GraphUtil.edges(i, new Vertex[]{}));
		
		return graph;
	}
}
