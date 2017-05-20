package org.persapiens.queue;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
@Test
public class PriorityQueueTest {
	public void arrayWith12Elements () {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(true);
		priorityQueue.insert(0);
		priorityQueue.insert(1);
		priorityQueue.insert(2);		
		priorityQueue.insert(4);		
		priorityQueue.insert(5);		
		priorityQueue.insert(6);		
		priorityQueue.insert(7);		
		priorityQueue.insert(8);		
		priorityQueue.insert(9);		
		priorityQueue.insert(12);		
		priorityQueue.insert(13);		
		priorityQueue.insert(15);
		
		assertThat(priorityQueue.extractMax())
			.isEqualTo(15);
		
		assertThat(priorityQueue.maximum())
			.isEqualTo(13);
		
		assertThat(priorityQueue.extractMax())
			.isEqualTo(13);
		
		assertThat(priorityQueue.extractMax())
			.isEqualTo(12);
		
		assertThat(priorityQueue.extractMax())
			.isEqualTo(9);
		
		assertThat(priorityQueue.extractMax())
			.isEqualTo(8);
		
		assertThat(priorityQueue.extractMax())
			.isEqualTo(7);
		
		assertThat(priorityQueue.extractMax())
			.isEqualTo(6);
	}
}
