package org.persapiens.algorithms.hash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author marcelo fernandes
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MultiplicationHashMethod implements HashMethod {

	private double A;
	private int m;
	
	@Override
	public int hash(int key) {
		double kA = key * A;
		return (int) (m * (kA % 1));
	}

}
