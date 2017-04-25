package org.persapiens.sort;

/**
 *
 * @author marcelo
 */
public interface Sort {
	<T extends Comparable> T[] sort(T[] items);
}
