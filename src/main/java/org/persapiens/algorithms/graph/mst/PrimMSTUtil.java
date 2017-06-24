package org.persapiens.algorithms.graph.mst;

import org.persapiens.algorithms.graph.Vertex;
import org.persapiens.algorithms.queue.PriorityQueue;

/**
 *
 * @author marcelo fernandes
 */
public class PrimMSTUtil {	
	public static PriorityQueue<Vertex> createPriorityQueue(Vertex[] vertexes) {
		PriorityQueue<Vertex> result = new PriorityQueue<>(true);
		for(Vertex u: vertexes) {
			result.insert(u);
		}
		return result;
	}
}
