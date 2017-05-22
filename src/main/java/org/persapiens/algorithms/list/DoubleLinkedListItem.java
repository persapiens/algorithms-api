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
public class DoubleLinkedListItem <D extends Object> {
	DoubleLinkedListItem<D> prev;
	
	DoubleLinkedListItem<D> next;
	
	D key;

	public DoubleLinkedListItem(D key) {
		this.key = key;
	}
	
	@Override
	public String toString() {
		return key.toString();
	}
    
}
