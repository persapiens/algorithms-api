package org.persapiens.algorithms.hash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author marcelo fernandes
 */
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoubleHashingProbing implements ProbingMethod {
	
	@Getter
	private int m;
	
	private HashMethod h1;

	private HashMethod h2;
	
	@Override
	public int hash(int key, int i) {
		return (h1.hash(key) + i*h2.hash(key)) % m;
	}

}
