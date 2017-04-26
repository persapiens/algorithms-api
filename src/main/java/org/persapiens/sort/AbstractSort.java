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
public abstract class AbstractSort implements Sort {
	
	@Getter @Setter
	private boolean ascending = true;

	/**
	 * Troca os valores de dois elementos em um array.
	 */
	public <T extends Comparable> List<T> exchange(List<T> items, int first, int second) {
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
	<T extends Comparable> boolean compare(T first, T second) {
		boolean result;
		if (ascending) {
			result = first.compareTo(second) > 0;
		}
		else {
			result = second.compareTo(first) > 0;
		}
		return result;
	}

}
