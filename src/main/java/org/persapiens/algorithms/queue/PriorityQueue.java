package org.persapiens.algorithms.queue;

import java.util.ArrayList;
import java.util.List;
import org.persapiens.algorithms.sort.HeapSort;

/**
 *
 * @author marcelo fernandes
 */
public class PriorityQueue <T extends Comparable> {
	private List<T> items = new ArrayList<>();
	private int heapSize = 0;
	private HeapSort heapSort;

	public PriorityQueue(boolean ascending) {
		this.heapSort = HeapSort.builder().ascending(!ascending).build();	
	}
	
	public T maximum() {
		return items.get(0);
	}
	
	public T extract() {
		if (items.isEmpty()) {
			throw new RuntimeException("Queue empty - heap underflow!");
		}
		
		T max = items.get(0);
		items.set(0, items.get(heapSize -1));
		heapSize --;
		heapSort.heapify(items, heapSize, 0);
		
		return max;
	}
	
	private void updateKey(int i, T key) {
		if (heapSort.compare(key, items.get(i))) {
			throw new IllegalArgumentException("New key " + key + " is smaller than current key " + items.get(i));
		}
		
		items.set(i, key);
		
		while (i > 0 && heapSort.compare(items.get(i), items.get(heapSort.parent(i)))) {
			heapSort.exchange(items, i, heapSort.parent(i));
			i = heapSort.parent(i);
		}
	}

	public void updateKey(T key) {
		int index = indexOf(key);
		if (index != -1) {
			updateKey(index, key);
		}
		else {
			throw new IllegalArgumentException("key " + key + " not included!");
		}
	}
	
	public void insert (T key) {
		heapSize ++;
		items.add(heapSize-1, null);
		updateKey(heapSize-1, key);
	}
	
	public void delete(int i) {
		if (heapSort.compare(items.get(i), items.get(this.heapSize -1))) {
			updateKey(i, items.get(this.heapSize -1));
			this.heapSize -= 1;
		}
		else {
			items.set(i, items.get(this.heapSize - 1));
			this.heapSize -= 1;
			heapSort.heapify(items, this.heapSize, i);
		}
	}
	
	public boolean isEmpty() {
		return this.heapSize == 0;
	}
	
	public boolean contains(T item) {
		return this.items.subList(0, heapSize).contains(item);
	}

	private int indexOf(T item) {
		return this.items.subList(0, heapSize).indexOf(item);
	}
}
