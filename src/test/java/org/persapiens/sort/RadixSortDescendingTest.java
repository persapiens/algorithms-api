package org.persapiens.sort;

/**
 *
 * @author marcelo
 */
public class RadixSortDescendingTest extends AbstractSortTest <Integer> {

    @Override
    protected Sort createSort() {
        return RadixSort.builder()
			.ascending(false)
			.d(3)
			.build();
    }

	@Override
	ArrayBuilder<Integer> createArrayBuilder() {
		return new ArrayBuilder<Integer>(new IdentidadeTransformar<Integer>());
	}
}
