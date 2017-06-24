package org.persapiens.algorithms.graph.search;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.persapiens.algorithms.graph.Edge;
import org.persapiens.algorithms.graph.Graph;
import org.persapiens.algorithms.graph.Vertex;
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

	private List<DepthFirstSearchListener> listeners = new ArrayList<>();
	
	public void addListener(DepthFirstSearchListener listener) {
		listeners.add(listener);
	}
	
	private void fireListener(Vertex v) {
		listeners.forEach((listener) -> {
			listener.finished(v);
		});
	}
	
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
		for (Edge edge : graph.getAdjacencyList(u)) {
			Vertex v = edge.getV();
			if (v.getColor().equals(WHITE)) {
				v.setParent(u);
				time = visit(graph, v, time);
			}
		}
		u.setColor(BLACK);
		time ++;
		u.setF(time);

		fireListener(u);
		
		return time;
	}
}
