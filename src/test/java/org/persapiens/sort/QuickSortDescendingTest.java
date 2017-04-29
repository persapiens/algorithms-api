package org.persapiens.sort;

/**
 *
 * @author marcelo
 */
public class QuickSortDescendingTest extends AbstractSortTest<Integer>{

    @Override
    protected Sort createSort() {
        return QuickSort.builder().ascending(false).build();
    }

	@Override
	ArrayBuilder<Integer> createArrayBuilder() {
		return new ArrayBuilder<Integer>(new IdentidadeTransformar<Integer>());
	}
}
