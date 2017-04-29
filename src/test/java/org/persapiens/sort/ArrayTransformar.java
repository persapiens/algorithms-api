package org.persapiens.sort;

import java.util.List;

/**
 *
 * @author marcelo
 */
public interface ArrayTransformar <E extends Comparable, S extends Comparable> {
	List<S> transfomar(List<E> entrada);
}
