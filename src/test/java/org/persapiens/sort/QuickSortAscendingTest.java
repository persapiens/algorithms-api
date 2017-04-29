package org.persapiens.sort;

/**
 *
 * @author marcelo
 */
public class QuickSortAscendingTest extends AbstractSortTest <Integer>{

    @Override
    protected Sort createSort() {
        return QuickSort.builder().ascending(true).build();
    }

	@Override
	ArrayBuilder<Integer> createArrayBuilder() {
		return new ArrayBuilder<Integer>(new IdentidadeTransformar<Integer>());
	}
}
