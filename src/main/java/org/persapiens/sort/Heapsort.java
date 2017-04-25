package org.persapiens.sort;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author marcelo
 */
@Builder
public class Heapsort implements Sort {	
	
	@Getter @Setter
	private boolean ascending = true;
	
	/**
	 * Calcula o indice do no pai.
	 */
	int parent(int i) {
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
	 * Troca os valores de dois elementos em um array.
	 */
	int[] exchange(int[] items, int first, int second) {
		int buffer = items[first];
		items[first] = items[second];
		items[second] = buffer;
		return items;
	}

	/**
	 * Compara dois valores.
	 * Se for ascendente, cria um maxHeap.
	 * Caso seja descentente, cria um minHeap.
	 */
	boolean compare(int first, int second) {
		boolean result;
		if (ascending) {
			result = first > second;
		}
		else {
			result = first < second;
		}
		return result;
	}
	
	/**
	 * comparando o no raiz com as folhas
	 * se houver necessidade de mudanca, repete-se a recursivamente na folha.
	 */
	void heapify(int[] items, int length, int i) {
		int l = left(i);
		int r = right(i);
		
		int largest;
		
		if ((l < length) && (compare(items[l] , items[i]))) {
			largest = l;
		}
		else largest = i;
		
		if ((r < length) && (compare(items[r] , items[largest]))) {
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
	int[] buildHeap(int[] items) {
		// varrendo os nos que nao sao folhas
		for(int counter = (items.length / 2) - 1; counter >= 0; counter --) {
			heapify(items, items.length, counter);
		}
		return items;
	}	
	
	@Override
	public int[] sort(int[] items) {
		// constroi o heap maximo
		items = buildHeap(items);
		
		for(int counter = items.length - 1; counter >= 1; counter --) {
			// troca o primeiro elemento com o ultimo. o ultimo eh o maior elemento
			items = exchange(items, 0, counter);
			
			// recalcula o heapify para manter a propriedade max-heap ou min-heap
			heapify(items, counter, 0);
		}
		return items;
	}	
}
