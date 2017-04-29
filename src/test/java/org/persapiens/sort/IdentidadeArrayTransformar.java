package org.persapiens.sort;

import java.util.List;

/**
 *
 * @author marcelo
 */
public class IdentidadeArrayTransformar<E extends Comparable> implements ArrayTransformar<E, E> {

	@Override
	public List<E> transfomar(List<E> entrada) {
		return entrada;
	}
}
