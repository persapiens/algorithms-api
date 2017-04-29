package org.persapiens.sort;

/**
 *
 * @author marcelo
 */
public class MergeSortDescendingTest extends AbstractSortTest <Integer, Integer>{

    @Override
    protected Sort createSort() {
        return MergeSort.builder().ascending(false).build();
    }

	@Override
	ArrayBuilder<Integer, Integer> createArrayBuilder() {
		return new ArrayBuilder<>(new IdentidadeTransformar<Integer>()
			, new IdentidadeArrayTransformar<Integer>());
	}
}
