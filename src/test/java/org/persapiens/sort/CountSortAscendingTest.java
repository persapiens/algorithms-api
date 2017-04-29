package org.persapiens.sort;

/**
 *
 * @author marcelo
 */
public class CountSortAscendingTest extends AbstractSortTest <CountSortRegistry<Integer>> {

    @Override
    protected Sort createSort() {
        return CountSort.builder()
			.ascending(true)
			.k(1000)
			.build();
    }
	
	@Override
	ArrayBuilder<CountSortRegistry<Integer>> createArrayBuilder() {
		return new ArrayBuilder<>(new CountSortRegistryTransformar());
	}
}
