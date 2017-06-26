package org.persapiens.algorithms.graph.search;

import lombok.Getter;
import lombok.Setter;
import org.persapiens.algorithms.graph.Edge;
import org.persapiens.algorithms.graph.ListGraph;
import org.persapiens.algorithms.graph.Vertex;
import org.persapiens.algorithms.queue.Queue;
import static org.persapiens.algorithms.graph.ListGraph.INFINITY;
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
public class BreadthFirstSearch {

	public void search(ListGraph graph, Vertex initialVertex) {
		for (Vertex vertex : graph.getVertexes()) {
			if (!initialVertex.equals(vertex)) {
				vertex.setColor(WHITE);
				vertex.setD(INFINITY);
				vertex.setParent(NIL);
			}
			else {
				initialVertex.setColor(GRAY);
				initialVertex.setD(0);
				initialVertex.setParent(NIL);
			}
		}
		
		Queue<Vertex> queue = new Queue<>();
		queue.enqueue(initialVertex);
		while (!queue.isEmpty()) {
			Vertex u = queue.dequeue();
			
			for (Edge edge : graph.getAdjacencyList(u)) {
				Vertex v = edge.getV();
				if (v.getColor().equals(WHITE)) {
					v.setColor(GRAY);
					v.setD(u.getD() +1);
					v.setParent(u);
					queue.enqueue(v);
				}				
			}
			u.setColor(BLACK);
		}
	}
	
	public String path(ListGraph g, Vertex s, Vertex v) {
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
