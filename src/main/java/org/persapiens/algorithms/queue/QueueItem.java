package org.persapiens.algorithms.queue;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author marcelo fernandes
 */
@Getter
@Setter
@Builder
public class QueueItem <T> {
	private T value;
	private QueueItem<T> next;
	private QueueItem<T> prev;

	public static final QueueItem NIL = QueueItem.builder().build();
}
