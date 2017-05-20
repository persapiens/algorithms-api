package org.persapiens.algorithms.sort;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author marcelo
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CountSort <T extends CountSortRegistry<V>, V> extends AbstractSort <T> {	
	
	@Getter
	private int k;
	
    @Builder
    public CountSort(boolean ascending, int k) {
        super(ascending);
		this.k = k;
    }    
	
	@Override
	public List<T> sort(List<T> items) {
		// criando o resultado com valores iniciais a zero
		List<T> result = new ArrayList<>(items.size());
		for(int i = 0; i < items.size(); i++) {
			result.add(null);
		}
		
		// criando a lista C com valores zero
		int[] C = new int[k+1];
		for(int i = 0; i <= k; i++) {
			C[i] = 0;
		}
		
		// C[i] contera quantas vezes cada numero i aparece
		for(int i = 0; i < items.size(); i++) {
			C[items.get(i).getKey()] = C[items.get(i).getKey()] + 1;
		}
		
		if (isAscending()) {
			// C[i] contera o numero de elementos menor ou igual a i
			for(int i = 1; i <= k; i++) {
				C[i] = C[i] + C[i -1];
			}
		}
		else {
			// C[i] contera o numero de elementos maiores ou igual a i
			for(int i = k-1; i >= 0; i--) {
				C[i] = C[i] + C[i +1];
			}
		}
		
		for(int i = items.size()-1; i >= 0; i--) {
			result.set(C[items.get(i).getKey()]-1, items.get(i));
			C[items.get(i).getKey()] = C[items.get(i).getKey()] -1;
		}
		
		return result;
	}
}
