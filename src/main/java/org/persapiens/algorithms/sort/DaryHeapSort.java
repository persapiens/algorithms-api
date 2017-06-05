package org.persapiens.algorithms.sort;

import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 *
 * @author marcelo
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DaryHeapSort <T extends Comparable> extends AbstractSort <T> {	
	
	private int d;
	
    @Builder
    public DaryHeapSort(boolean ascending, int d) {
        super(ascending);
		
		this.d = d;
    }
    
	/**
	 * Calcula o indice do no pai.
	 */
	public int parent(int i) {
		return (i -1) / d;
	}
	
	/**
	 * Calcula o indice do filho k do indice de pai i.
	 */
	int child(int i, int k) {
		return i * d + k + 1;
	}
	
	/**
	 * comparando o no raiz com as folhas
	 * se houver necessidade de mudanca, repete-se a recursivamente na folha.
	 * @param items itens de array
	 * @param length tamanho do array a ser considerado
	 * @param i indice do no a ser calculado o heap
	 */
	public void heapify(List<T> items, int length, int i) {
		int largest = i;

		for (int counter = 0; counter < d; counter ++) {
			int child = child(i, counter);
			if (child < length) {
				if (compare(items.get(child), items.get(largest))) {
					largest = child;
				}
			}
			else {
				break;
			}
		}	
		
		if(largest != i) {
			items = exchange(items, i, largest);
			
			heapify(items, length, largest);
		}
	}
	
	/**
	 * Percorre os nos nao folhas para construir o heap.
	 */
	List<T> buildHeap(List<T> items) {
		// varrendo os nos que nao sao folhas
		for(int counter = (items.size() + d - 2) / d; counter >= 0; counter --) {
			heapify(items, items.size(), counter);
		}
		return items;
	}	
	
	@Override
	public List<T> sort(List<T> items) {
		// constroi o heap maximo
		items = buildHeap(items);
		
		for(int counter = items.size() - 1; counter >= 1; counter --) {
			// troca o primeiro elemento com o ultimo. o ultimo eh o maior elemento
			items = exchange(items, 0, counter);
			
			// recalcula o heapify para manter a propriedade max-heap ou min-heap
			heapify(items, counter, 0);
		}
		return items;
	}	
}
