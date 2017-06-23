package org.persapiens.algorithms.graph.mst;

import org.persapiens.algorithms.graph.set.DisjointSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.persapiens.algorithms.graph.Edge;
import org.persapiens.algorithms.graph.Graph;
import org.persapiens.algorithms.graph.Vertex;
import org.persapiens.algorithms.sort.QuickSort;

/**
 *
 * @author marcelo fernandes
 */
@Getter
@Setter
public class KruskalMST {	
	public Set<Edge> create(Graph graph) {
		Set<Edge> result = new HashSet<>();
		
		DisjointSet<Vertex> disjointSet = new DisjointSet<>();
		for (Vertex v : graph.getVertexes()) {
			disjointSet.makeSet(v);
		}

		List<Edge> edges = new QuickSort<Edge>(true).sort(graph.getEdges());
			
		edges.forEach((edge) -> {
			Set<Vertex> uSet = disjointSet.findSet(edge.getU());
			Set<Vertex> vSet = disjointSet.findSet(edge.getV());
			if (!uSet.equals(vSet)) {
				result.add(edge);
				disjointSet.unionAll(edge.getU(), edge.getV());
			}
		});
		
		return result;
	}
}
