package org.persapiens.sort;

/**
 *
 * @author marcelo
 */
public class MergeSortAscendingTest extends AbstractSortTest <Integer>{

    @Override
    protected Sort createSort() {
        return MergeSort.builder().ascending(true).build();
    }

	@Override
	ArrayBuilder<Integer> createArrayBuilder() {
		return new ArrayBuilder<Integer>(new IdentidadeTransformar<Integer>());
	}
}
