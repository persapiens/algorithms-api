package org.persapiens.sort;

/**
 *
 * @author marcelo
 */
public class InsertionSortDescendingTest extends AbstractSortTest <Integer> {
    @Override
    protected Sort createSort() {
        return InsertionSort.builder().ascending(false).build();
    }

	@Override
	ArrayBuilder<Integer> createArrayBuilder() {
		return new ArrayBuilder<Integer>(new IdentidadeTransformar<Integer>());
	}
}