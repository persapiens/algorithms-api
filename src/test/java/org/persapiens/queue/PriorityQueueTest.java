package org.persapiens.queue;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
public class PriorityQueueTest {
	@Test
	public void emptyArray () {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		priorityQueue.setItems(Arrays.asList(15, 13, 9, 5, 12, 8, 7, 4, 0, 6, 2, 1));
		
		Integer k = priorityQueue.extractMax();
		
		assertThat(k)
			.isEqualTo(15);
	}
}
