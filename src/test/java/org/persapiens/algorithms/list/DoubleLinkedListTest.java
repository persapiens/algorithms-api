package org.persapiens.algorithms.list;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
@Test
public class DoubleLinkedListTest {
	public void empty () {
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
		
		assertThat(doubleLinkedList.isEmpty())
			.isTrue();
		
		doubleLinkedList.insert(10);
	}
	
	public void notEmpty () {
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
		
		doubleLinkedList.insert(10);

		assertThat(doubleLinkedList.isEmpty())
			.isFalse();
	}
	
	public void delete () {
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
		
		doubleLinkedList.insert(10);

		assertThat(doubleLinkedList.delete(10))
			.isTrue();
	}
	
	public void notDeleted () {
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
		
		assertThat(doubleLinkedList.delete(10))
			.isFalse();
	}
	
	public void delete1 () {
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
		
		doubleLinkedList.insert(1);
		doubleLinkedList.insert(2);

		boolean deleted = doubleLinkedList.delete(1);
		
		assertThat(deleted)
			.isTrue();
		assertThat(doubleLinkedList.search(1))
			.isNull();
		assertThat(doubleLinkedList.search(2))
			.isEqualTo(2);
	}
	
	public void delete2 () {
		DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
		
		doubleLinkedList.insert(1);
		doubleLinkedList.insert(2);

		boolean deleted = doubleLinkedList.delete(2);
		
		assertThat(deleted)
			.isTrue();
		assertThat(doubleLinkedList.search(1))
			.isEqualTo(1);
		assertThat(doubleLinkedList.search(2))
			.isNull();
	}
}
