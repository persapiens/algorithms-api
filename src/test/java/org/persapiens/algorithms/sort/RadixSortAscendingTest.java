package org.persapiens.algorithms.sort;

import org.persapiens.algorithms.sort.Sort;
import org.persapiens.algorithms.sort.RadixSort;

/**
 *
 * @author marcelo
 */
public class RadixSortAscendingTest extends AbstractSortTest <Integer, Integer> {

    @Override
    protected Sort createSort() {
        return RadixSort.builder()
			.ascending(true)
			.d(3)
			.build();
    }

	@Override
	ArrayBuilder<Integer, Integer> createArrayBuilder() {
		return new ArrayBuilder<>(new IdentidadeTransformar<Integer>()
			, new IdentidadeArrayTransformar<Integer>());
	}
}
