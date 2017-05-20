package org.persapiens.algorithms.sort;

import org.persapiens.algorithms.sort.CountSortRegistry;

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
