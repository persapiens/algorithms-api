package org.persapiens.queue;

import java.util.ArrayList;
import java.util.List;
import org.persapiens.sort.Heapsort;

/**
 *
 * @author marcelo fernandes
 */
public class PriorityQueue <T extends Comparable> {
	private List<T> items = new ArrayList<>();
	private int heapSize = 0;

	public void setItems(List<T> items) {
		this.items = new ArrayList(items);
		this.heapSize = items.size();
	}
	
	private Heapsort heapsort = Heapsort.builder().ascending(true).build();
	
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
		heapsort.heapify(items, heapSize, 0);
		
		return max;
	}
	
	public void increaseKey(int i, T key) {
		if (key.compareTo(items.get(i)) < 0) {
			throw new IllegalArgumentException("New key " + key + " is smaller than current key " + items.get(i));
		}
		
		items.set(i, key);
		
		while ((i > 0) && (items.get(heapsort.parent(i)).compareTo(items.get(i)) < 0)) {
			heapsort.exchange(items, i, heapsort.parent(i));
			i = heapsort.parent(i);
		}
	}
	
	public void insert (T key) {
		heapSize ++;
		items.set(heapSize-1, null);
		increaseKey(heapSize-1, key);
	}
}
