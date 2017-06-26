package org.persapiens.algorithms.graph.apsp;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.persapiens.algorithms.graph.Matrix;

/**
 *
 * @author marcelo fernandes
 */
@Getter
@Setter
@Builder
public class WeightsAndPaths {
	Matrix weights;
	
	Matrix paths;
	
	public int[] path(int i, int j) {
		return null;
	}
}
