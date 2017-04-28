package org.persapiens.sort;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author marcelo
 */
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractSort <T extends Comparable> implements Sort <T>{
	
	@Getter @Setter
	private boolean ascending = true;

	/**
	 * Troca os valores de dois elementos em um array.
	 */
	public List<T> exchange(List<T> items, int first, int second) {
		T buffer = items.get(first);
		items.set(first, items.get(second));
		items.set(second, buffer);
		return items;
	}

	/**
	 * Compara dois valores.
	 * Se for ascendente, cria um maxHeap.
	 * Caso seja descentente, cria um minHeap.
	 */
	boolean compare(T first, T second) {
		boolean result;
		if (first == null) {
			result = true;
		}
		else if (second == null) {
			 result = false;
		} 
		else if (ascending) {
			result = first.compareTo(second) > 0;
		}
		else {
			result = second.compareTo(first) > 0;
		}
		return result;
	}

}
