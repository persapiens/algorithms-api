package org.persapiens.sort;

import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 *
 * @author marcelo
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QuickSort <T extends Comparable> extends AbstractSort<T> {	
	
    @Builder
    public QuickSort(boolean ascending) {
        super(ascending);
    }    
	
	/**
	 * Realizando o particionamento, retornando o pivo
	 */
	int partition(List<T> items, int p, int r) {
		T x = items.get(r);
		int i = p -1;
		for (int j = p; j <= r -1; j++) {
			if (!compare(items.get(j), x)) {
				i++;
				items = exchange(items, i, j);
			}
		}
		items = exchange(items, i+1, r);
		return i + 1;
	}
	
	List<T> quickSort(List<T> items, int p, int r) {	
		if (p < r) {
			int q = partition(items, p, r);
			items = quickSort(items, p, q - 1);
			items = quickSort(items, q + 1, r);
		}
		return items;
	}
	
	@Override
	public List<T> sort(List<T> items) {
		return quickSort(items, 0, items.size()-1);
	}	
}
