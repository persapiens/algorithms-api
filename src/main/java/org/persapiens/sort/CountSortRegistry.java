package org.persapiens.sort;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author marcelo
 */
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "value")
@ToString
public class CountSortRegistry <T> implements Comparable<Integer> {	
	
	private int key;
	
	private T value;

	@Override
	public int compareTo(Integer o) {
		return Integer.compare(key, o);
	}
}
