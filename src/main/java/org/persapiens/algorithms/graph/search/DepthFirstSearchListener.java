package org.persapiens.algorithms.graph.search;

import org.persapiens.algorithms.graph.Vertex;

/**
 *
 * @author marcelo fernandes
 */
public interface DepthFirstSearchListener {
	void finished(Vertex v);
}
