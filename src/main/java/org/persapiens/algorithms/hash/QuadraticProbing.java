package org.persapiens.algorithms.hash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author marcelo fernandes
 */
@AllArgsConstructor
@NoArgsConstructor
public class QuadraticProbing implements ProbingMethod {
	
	@Getter
	private int m;
	
	private HashMethod hash;

	private int c1;
	
	private int c2;
	
	@Override
	public int hash(int key, int i) {
		return (hash.hash(key) + c1*i + c2*i*i) % m;
	}

}
