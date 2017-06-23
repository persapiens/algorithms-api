package org.persapiens.algorithms.graph;

import lombok.Getter;
import lombok.Setter;
import static org.persapiens.algorithms.graph.Vertex.NIL;
import static org.persapiens.algorithms.graph.VertexColor.BLACK;
import static org.persapiens.algorithms.graph.VertexColor.GRAY;
import static org.persapiens.algorithms.graph.VertexColor.WHITE;

/**
 *
 * @author marcelo fernandes
 */
@Getter
@Setter
public class DepthFirstSearch {

	public void search(Graph graph) {
		for (Vertex u : graph.getVertexes()) {
			u.setColor(WHITE);
			u.setParent(NIL);
		}

		int time = 0;
			
		for (Vertex u : graph.getVertexes()) {
			if (u.getColor().equals(WHITE)) {
				time = visit(graph, u, time);
			}				
		}
	}

	private int visit(Graph graph, Vertex u, int time) {
		time ++;
		u.setD(time);
		u.setColor(GRAY);
		for (Vertex v : graph.getAdjacencyList(u)) {
			if (v.getColor().equals(WHITE)) {
				v.setParent(u);
				time = visit(graph, v, time);
			}
		}
		u.setColor(BLACK);
		time ++;
		u.setF(time);
		return time;
	}
	
	public String path(Graph g, Vertex s, Vertex v) {
		String result = "";
		if (v.equals(s)) {
			result = s.getLabel();
		}
		else if (v.getParent().equals(NIL)) {
			result = "no path from " + s.getLabel() + " to " + v.getLabel() + " exists!";
		}
		else {
			result += path(g, s, v.getParent());
			result += v.getLabel();
		}
		
		return result;
	}
}
