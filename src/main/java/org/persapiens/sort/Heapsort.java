package org.persapiens.sort;

import java.util.List;
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
	
	/**
	 * comparando o no raiz com as folhas
	 * se houver necessidade de mudanca, repete-se a recursivamente na folha.
	 * @param items itens de array
	 * @param length tamanho do array a ser considerado
	 * @param i indice do no a ser calculado o heap
	 */
	public <T extends Comparable> void heapify(List<T> items, int length, int i) {
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
	<T extends Comparable> List<T> buildHeap(List<T> items) {
		// varrendo os nos que nao sao folhas
		for(int counter = (items.size() / 2) - 1; counter >= 0; counter --) {
			heapify(items, items.size(), counter);
		}
		return items;
	}	
	
	@Override
	public <T extends Comparable> List<T> sort(List<T> items) {
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
