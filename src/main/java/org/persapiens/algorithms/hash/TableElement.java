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
public class TableElement <D extends Comparable> {
	int key;
	
	D data;

	@Override
	public String toString() {
		return data.toString();
	}
    
}
