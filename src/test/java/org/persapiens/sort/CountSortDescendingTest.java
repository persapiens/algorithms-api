package org.persapiens.sort;

/**
 *
 * @author marcelo
 */
public class CountSortDescendingTest extends AbstractSortTest <CountSortRegistry<Integer>>{

    @Override
    protected Sort createSort() {
        return CountSort.builder()
			.ascending(false)
			.k(1000)
			.build();
    }

	@Override
	ArrayBuilder<CountSortRegistry<Integer>> createArrayBuilder() {
		return new ArrayBuilder<>(new CountSortRegistryTransformar());
	}
}
