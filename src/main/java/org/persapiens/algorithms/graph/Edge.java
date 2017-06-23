package org.persapiens.algorithms.graph;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author marcelo
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"u", "v"})
@Builder
public class Edge implements Comparable<Edge> {
	private Vertex u;
	
	private Vertex v;
	
	private int w;

	@Override
	public int compareTo(Edge o) {
		return this.w - o.w;
	}
	
}
