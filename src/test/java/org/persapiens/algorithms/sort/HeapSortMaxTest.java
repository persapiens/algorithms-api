package org.persapiens.algorithms.sort;

import org.persapiens.algorithms.sort.HeapSort;
import org.persapiens.algorithms.sort.Sort;

/**
 *
 * @author marcelo
 */
public class HeapSortMaxTest extends AbstractSortTest  <Integer, Integer>{
    @Override
    protected Sort createSort() {
        return HeapSort.builder().ascending(true).build();
    }

	@Override
	ArrayBuilder<Integer, Integer> createArrayBuilder() {
		return new ArrayBuilder<>(new IdentidadeTransformar<Integer>()
			, new IdentidadeArrayTransformar<Integer>());
	}
}
