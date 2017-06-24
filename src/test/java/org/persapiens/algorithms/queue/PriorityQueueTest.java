package org.persapiens.algorithms.queue;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
@Test
public class PriorityQueueTest {
	public void arrayWith12Elements () {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(false);
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
		
		assertThat(priorityQueue.extract())
			.isEqualTo(15);
		
		assertThat(priorityQueue.maximum())
			.isEqualTo(13);
		
		assertThat(priorityQueue.extract())
			.isEqualTo(13);
		
		assertThat(priorityQueue.extract())
			.isEqualTo(12);
		
		assertThat(priorityQueue.extract())
			.isEqualTo(9);
		
		assertThat(priorityQueue.extract())
			.isEqualTo(8);
		
		assertThat(priorityQueue.extract())
			.isEqualTo(7);
		
		assertThat(priorityQueue.extract())
			.isEqualTo(6);
	}
}
