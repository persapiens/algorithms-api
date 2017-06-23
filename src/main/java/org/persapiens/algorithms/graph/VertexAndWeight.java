package org.persapiens.algorithms.graph;

import lombok.Builder;
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
@Builder
public class VertexAndWeight {
	private Vertex vertex;
	
	private int w;
}
