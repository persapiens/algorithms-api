package org.persapiens.algorithms.graph.apsp;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author marcelo fernandes
 */
@Getter
@Setter
@Builder
public class DAndPi {
	Matrix d;
	
	Matrix pi;
}
