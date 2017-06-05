package org.persapiens.algorithms.list;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
@Test
public class DequeTest {
	public void empty () {
		Deque<Integer> deque = new Deque<Integer>(1);
		
		assertThat(deque.isEmpty())
			.isTrue();		
		assertThat(deque.isFull())
			.isFalse();		
	}
	
	public void full () {
		Deque<Integer> deque = new Deque<Integer>(1);

		deque.insertHead(1);
		
		assertThat(deque.isEmpty())
			.isFalse();
		assertThat(deque.isFull())
			.isTrue();
	}
	
	public void insert () {
		Deque<Integer> deque = new Deque<Integer>(3);
		
		deque.insertHead(1);
		deque.insertHead(2);
		deque.insertHead(3);

		assertThat(deque.isFull())
			.isTrue();
	}
	
	public void insertTail () {
		Deque<Integer> deque = new Deque<Integer>(3);
		
		deque.insertTail(1);
		deque.insertTail(2);
		deque.insertTail(3);
		
		assertThat(deque.removeTail())
			.isEqualTo(3);
	}
	
	public void insertHeadTail () {
		Deque<Integer> deque = new Deque<Integer>(3);
		
		deque.insertHead(1);
		deque.removeTail();
		deque.insertTail(3);
		
		assertThat(deque.removeTail())
			.isEqualTo(3);
	}
	
}
