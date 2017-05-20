package org.persapiens.algorithms.sort;

/**
 *
 * @author marcelo
 */
public class IdentidadeTransformar<E extends Comparable> implements Transformar<E, E> {

	@Override
	public E transfomar(E entrada) {
		return entrada;
	}
}
