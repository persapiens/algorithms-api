package org.persapiens.sort;

import java.util.List;

/**
 *
 * @author marcelo
 */
public interface Sort {
	<T extends Comparable> List<T> sort(List<T> items);
}
