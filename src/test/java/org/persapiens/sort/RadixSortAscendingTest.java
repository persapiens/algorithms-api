package org.persapiens.sort;

/**
 *
 * @author marcelo
 */
public class RadixSortAscendingTest extends AbstractSortTest <Integer>{

    @Override
    protected Sort createSort() {
        return RadixSort.builder()
			.ascending(true)
			.d(3)
			.build();
    }

	@Override
	ArrayBuilder<Integer> createArrayBuilder() {
		return new ArrayBuilder<Integer>(new IdentidadeTransformar<Integer>());
	}
}
