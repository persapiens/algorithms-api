package org.persapiens.algorithms.graph;

import lombok.Getter;
import lombok.Setter;
import static org.persapiens.algorithms.graph.Vertex.NIL;
import static org.persapiens.algorithms.graph.VertexColor.BLACK;
import static org.persapiens.algorithms.graph.VertexColor.GRAY;
import org.persapiens.algorithms.queue.Queue;
import static org.persapiens.algorithms.graph.VertexColor.WHITE;

/**
 *
 * @author marcelo fernandes
 */
@Getter
@Setter
public class BreadthFirstSearch {

	public void search(Graph graph, Vertex initialVertex) {
		for (Vertex vertex : graph.getVertexes()) {
			if (!initialVertex.equals(vertex)) {
				vertex.setColor(WHITE);
				vertex.setD(Integer.MAX_VALUE);
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
			
			for (Vertex v : graph.getAdjacencyList(u)) {
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
