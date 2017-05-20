package org.persapiens.algorithms.sort;

import org.persapiens.algorithms.sort.QuickSort;
import org.persapiens.algorithms.sort.Sort;

/**
 *
 * @author marcelo
 */
public class QuickSortAscendingTest extends AbstractSortTest <Integer, Integer>{

    @Override
    protected Sort createSort() {
        return QuickSort.builder().ascending(true).build();
    }

	@Override
	ArrayBuilder<Integer, Integer> createArrayBuilder() {
		return new ArrayBuilder<>(new IdentidadeTransformar<Integer>()
			, new IdentidadeArrayTransformar<Integer>());
	}
}
