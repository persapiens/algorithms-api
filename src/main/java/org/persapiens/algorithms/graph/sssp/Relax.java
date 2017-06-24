package org.persapiens.algorithms.graph.sssp;

import java.util.ArrayList;
import java.util.List;
import org.persapiens.algorithms.graph.Edge;
import org.persapiens.algorithms.graph.Vertex;

/**
 *
 * @author marcelo fernandes
 */
public class Relax {	
	private List<RelaxListener> listeners = new ArrayList<>();
	
	public void addListener(RelaxListener listener) {
		listeners.add(listener);
	}
	
	public void relax(Edge edge) {
		Vertex u = edge.getU();
		Vertex v = edge.getV();
		if (v.getD() > u.getD() + edge.getW()) {
			v.setD(u.getD() + edge.getW());
			v.setParent(u);
			
			fireListener(v);
		}
	}

	private void fireListener(Vertex v) {
		listeners.forEach((listener) -> {
			listener.relaxed(v);
		});
	}
}
