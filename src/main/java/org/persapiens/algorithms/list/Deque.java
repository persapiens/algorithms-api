package org.persapiens.algorithms.list;

import lombok.Getter;

/**
 *
 * @author marcelo fernandes
 */
public class Deque <D extends Object> {
	private D[] items;

	private int head;
	private int tail;
	
	@Getter
	private int size;
	
	public Deque(int capacity) {
		this.items = (D[]) new Object[capacity];
		this.head = 0;
		this.tail = 0;
		this.size = 0;
	}
	
	public void insertHead(D k) {
		if (!isFull()) {
			items[head] = k;
			head = (head + 1) % items.length;
			size++;
		}
	}
	
	public void insertTail(D k) {
		if (!isFull()) {
			tail = tail - 1;
			if (tail < 0) {
				tail = items.length - 1;
			}
			size++;
			items[tail] = k;
		}
	}

	public D removeHead() {
		D result = null;
		if (!isEmpty()) {
			head = head - 1;
			if (head < 0) {
				head = items.length - 1;
			}
			result = items[head];
			size--;
		}
		return result;
	}
	
	public D removeTail() {
		D result = null;
		if (!isEmpty()) {
			result = items[tail];
			tail = (tail + 1) % items.length;
			size--;
		}
		return result;		
	}

	public D getHead() {
		D result = null;
		if (!isEmpty()) {
			result = items[(head - 1) < 0 ? items.length - 1: head -1];
		}
		return result;
	}

	public D getTail() {
		D result = null;
		if (!isEmpty()) {
			result = items[tail];
		}
		return result;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == items.length;
	}
}
