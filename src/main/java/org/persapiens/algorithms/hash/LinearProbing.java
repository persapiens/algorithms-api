package org.persapiens.algorithms.hash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author marcelo fernandes
 */
@AllArgsConstructor
@NoArgsConstructor
public class LinearProbing implements ProbingMethod {

	@Getter
	private int m;
	
	private HashMethod hash;
	
	@Override
	public int hash(int key, int i) {
		return (hash.hash(key) + i) % m;
	}

}
