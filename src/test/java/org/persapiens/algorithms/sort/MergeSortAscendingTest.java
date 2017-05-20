package org.persapiens.algorithms.sort;

import org.persapiens.algorithms.sort.MergeSort;
import org.persapiens.algorithms.sort.Sort;

/**
 *
 * @author marcelo
 */
public class MergeSortAscendingTest extends AbstractSortTest <Integer, Integer>{

    @Override
    protected Sort createSort() {
        return MergeSort.builder().ascending(true).build();
    }

	@Override
	ArrayBuilder<Integer, Integer> createArrayBuilder() {
		return new ArrayBuilder<>(new IdentidadeTransformar<Integer>()
			, new IdentidadeArrayTransformar<Integer>());
	}
}
