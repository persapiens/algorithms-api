package org.persapiens.algorithms.sort;

/**
 *
 * @author marcelo
 */
public class RadixSortDescendingTest extends AbstractSortTest <Integer, Integer> {

    @Override
    protected Sort createSort() {
        return RadixSort.builder()
			.ascending(false)
			.d(3)
			.build();
    }

	@Override
	ArrayBuilder<Integer, Integer> createArrayBuilder() {
		return new ArrayBuilder<>(new IdentidadeTransformar<Integer>()
			, new IdentidadeArrayTransformar<Integer>());
	}
}
