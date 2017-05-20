package org.persapiens.algorithms.sort;

import org.persapiens.algorithms.sort.CountSort;
import org.persapiens.algorithms.sort.Sort;
import org.persapiens.algorithms.sort.CountSortRegistry;

/**
 *
 * @author marcelo
 */
public class CountSortDescendingTest extends AbstractSortTest <CountSortRegistry<Integer>, CountSortRegistry<Integer>>{

    @Override
    protected Sort createSort() {
        return CountSort.builder()
			.ascending(false)
			.k(1000)
			.build();
    }

	@Override
	ArrayBuilder<CountSortRegistry<Integer>, CountSortRegistry<Integer>> createArrayBuilder() {
		return new ArrayBuilder<>(new CountSortRegistryTransformar()
			, new IdentidadeArrayTransformar<CountSortRegistry<Integer>>());
	}
}
