package org.persapiens.algorithms.graph.sssp;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.persapiens.algorithms.graph.Vertex;
import org.persapiens.algorithms.queue.PriorityQueue;

/**
 *
 * @author marcelo fernandes
 */
@Getter
@Setter
@Builder
public class VertexPriorityQueueUpdater implements RelaxListener {	
	
	private PriorityQueue<Vertex> Q;
	
	@Override
	public void relaxed(Vertex vertex) {
		Q.updateKey(vertex);
	}
}
