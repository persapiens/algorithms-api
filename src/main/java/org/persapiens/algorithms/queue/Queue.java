package org.persapiens.algorithms.queue;

import static org.persapiens.algorithms.queue.QueueItem.NIL;

/**
 *
 * @author marcelo fernandes
 */
public class Queue <T> {
	private QueueItem<T> head = NIL;
	private QueueItem<T> tail = NIL;
	
	public void enqueue (T key) {
		QueueItem<T> newItem = QueueItem.<T>builder()
			.value(key)
			.next(NIL)
			.prev(NIL)
			.build();
		
		if (head == NIL) {
			head = newItem;
			tail = newItem;
		}
		else {
			tail.setNext(newItem);
			newItem.setPrev(tail);
			if (head.equals(tail)) {
				head.setNext(newItem);
			}
			tail = newItem;
		}
	}
	
	public T dequeue() {
		T result = null;
		if (!head.equals(NIL)) {
			result = head.getValue();
			if (head.equals(tail)) {
				tail = tail.getNext();
			}
			head = head.getNext();
			head.setPrev(NIL);
		}
		return result;
	}

	public boolean isEmpty() {
		return head.equals(NIL);
	}
}
