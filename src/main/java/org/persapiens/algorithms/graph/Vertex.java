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
@ToString(of = {"label", "color", "d", "f"})
@EqualsAndHashCode(of="label")
@Builder
public class Vertex implements Comparable<Vertex>{
	private VertexColor color;
	
	private String label;
	
	private int d;
	
	private int f;
	
	private Vertex parent;
	
	public static final Vertex NIL = Vertex.builder().build();

	@Override
	public int compareTo(Vertex o) {
		return this.d - o.d;
	}
}
