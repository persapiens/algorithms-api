package org.persapiens.algorithms.sort;

/**
 *
 * @author marcelo
 */
public interface Transformar <E extends Comparable, S> {
	S transfomar(E entrada);
}
