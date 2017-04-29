package org.persapiens.sort;

/**
 *
 * @author marcelo
 */
public class CountSortRegistryTransformar implements Transformar<Integer, CountSortRegistry<Integer>> {

	@Override
	public CountSortRegistry<Integer> transfomar(Integer entrada) {
		return new CountSortRegistry(entrada, entrada);
	}
}
