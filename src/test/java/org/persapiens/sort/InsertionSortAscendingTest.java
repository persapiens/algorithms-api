package org.persapiens.sort;

/**
 *
 * @author marcelo
 */
public class InsertionSortAscendingTest extends AbstractSortTest  <Integer>{

    @Override
    protected Sort createSort() {
        return InsertionSort.builder().ascending(true).build();
    }

	@Override
	ArrayBuilder<Integer> createArrayBuilder() {
		return new ArrayBuilder<Integer>(new IdentidadeTransformar<Integer>());
	}
}
