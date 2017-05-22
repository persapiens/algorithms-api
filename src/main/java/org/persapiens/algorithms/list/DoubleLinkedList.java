package org.persapiens.algorithms.list;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author marcelo fernandes
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoubleLinkedList <D extends Object> {
	DoubleLinkedListItem<D> head;

	public D search(D k) {
		D result = null;
		DoubleLinkedListItem<D> searchItem = searchItem(k);
		if (searchItem != null) {
			result = searchItem.getKey();
		}
		return result;
	}
	
	private DoubleLinkedListItem<D> searchItem(D k) {
		DoubleLinkedListItem<D> result = head;
		while (result != null && !result.getKey().equals(k)) {
			result = result.getNext();
		}
		return result;
	}
    
	public DoubleLinkedListItem<D> insert(D x) {
		DoubleLinkedListItem<D> result = new DoubleLinkedListItem<>(x);
		
		insertItem(result);
		
		return result;
	}
	
	private void insertItem(DoubleLinkedListItem<D> x) {
		x.next = head;
		if (head != null) {
			head.setPrev(x);
		}
		head = x;
		x.setPrev(null);
	}
    
	public boolean delete(D x) {
		DoubleLinkedListItem<D> item = searchItem(x);
		
		boolean result = item != null;
		
		if (result) {
			deleteItem(item);
		}
		
		return result;
	}
	
	private void deleteItem(DoubleLinkedListItem<D> x) {
		if (x.getPrev() != null) {
			x.getPrev().setNext(x.getNext());
		}
		else {
			head = x.getNext();
		}
		if (x.getNext() != null) {
			x.getNext().setPrev(x.getPrev());
		}
	}
	
	public boolean isEmpty() {
		return head == null;
	}
}
