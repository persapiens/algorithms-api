package org.persapiens.sort;

/**
 *
 * @author marcelo
 */
public class HeapSortMinTest extends AbstractSortTest <Integer> {
    @Override
    protected Sort createSort() {
        return HeapSort.builder().ascending(false).build();
    }

	@Override
	ArrayBuilder<Integer> createArrayBuilder() {
		return new ArrayBuilder<Integer>(new IdentidadeTransformar<Integer>());
	}
}
