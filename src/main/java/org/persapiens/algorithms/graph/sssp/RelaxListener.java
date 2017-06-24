package org.persapiens.algorithms.graph.sssp;

import org.persapiens.algorithms.graph.Vertex;

/**
 *
 * @author marcelo fernandes
 */
public interface RelaxListener {	
	void relaxed(Vertex vertex);
}
