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
public class DivisionHashMethod implements HashMethod {

	private int m;
	
	@Override
	public int hash(int key) {
		return key % m;
	}

}
