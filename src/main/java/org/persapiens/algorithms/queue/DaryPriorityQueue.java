package org.persapiens.algorithms.queue;

import java.util.ArrayList;
import java.util.List;
import org.persapiens.algorithms.sort.DaryHeapSort;

/**
 *
 * @author marcelo fernandes
 */
public class DaryPriorityQueue <T extends Comparable> {
	private List<T> items = new ArrayList<>();
	private int heapSize = 0;
	private DaryHeapSort daryHeapSort;

	public DaryPriorityQueue(boolean ascending, int d) {
		this.daryHeapSort = DaryHeapSort.builder()
			.ascending(ascending)
			.d(d)
			.build();	
	}
	
	public T maximum() {
		return items.get(0);
	}
	
	public T extractMax() {
		if (items.isEmpty()) {
			throw new RuntimeException("Queue empty - heap underflow!");
		}
		
		T max = items.get(0);
		items.set(0, items.get(heapSize -1));
		heapSize --;
		daryHeapSort.heapify(items, heapSize, 0);
		
		return max;
	}
	
	void increaseKey(int i, T key) {
		if (daryHeapSort.compare(key, items.get(i))) {
			throw new IllegalArgumentException("New key " + key + " is smaller than current key " + items.get(i));
		}
		
		items.set(i, key);
		
		while (i > 0 && daryHeapSort.compare(items.get(i), items.get(daryHeapSort.parent(i)))) {
			daryHeapSort.exchange(items, i, daryHeapSort.parent(i));
			i = daryHeapSort.parent(i);
		}
	}
	
	public void insert (T key) {
		heapSize ++;
		items.add(heapSize-1, null);
		increaseKey(heapSize-1, key);
	}
}
