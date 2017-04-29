package org.persapiens.sort;

/**
 *
 * @author marcelo
 */
public class MergeSortDescendingTest extends AbstractSortTest <Integer>{

    @Override
    protected Sort createSort() {
        return MergeSort.builder().ascending(false).build();
    }

	@Override
	ArrayBuilder<Integer> createArrayBuilder() {
		return new ArrayBuilder<Integer>(new IdentidadeTransformar<Integer>());
	}
}
