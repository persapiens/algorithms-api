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
public class HeapSort <T extends Comparable> extends AbstractSort <T> {	
	
    @Builder
    public HeapSort(boolean ascending) {
        super(ascending);
    }
    
	/**
	 * Calcula o indice do no pai.
	 */
	public int parent(int i) {
		return i >> 2;
	}
	
	/**
	 * Calcula o indice do no raiz do lado esquerdo.
	 */
	int left(int i) {
		return ((i+1) * 2) -1;
	}

	/**
	 * Calcula o indice do no raiz do lado direito.
	 */
	int right(int i) {
		return ((i+1) * 2);
	}
	
	/**
	 * comparando o no raiz com as folhas
	 * se houver necessidade de mudanca, repete-se a recursivamente na folha.
	 * @param items itens de array
	 * @param length tamanho do array a ser considerado
	 * @param i indice do no a ser calculado o heap
	 */
	public void heapify(List<T> items, int length, int i) {
		int l = left(i);
		int r = right(i);
		
		int largest;
		
		if ((l < length) && (compare(items.get(l), items.get(i)))) {
			largest = l;
		}
		else largest = i;
		
		if ((r < length) && (compare(items.get(r), items.get(largest)))) {
			largest = r;
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
		for(int counter = (items.size() / 2) - 1; counter >= 0; counter --) {
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
