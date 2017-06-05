package org.persapiens.algorithms.sort;

/**
 *
 * @author marcelo
 */
public class DaryHeapSortMaxTest extends AbstractSortTest  <Integer, Integer>{
    @Override
    protected Sort createSort() {
        return DaryHeapSort.builder()
			.ascending(true)
			.d(3)
			.build();
    }

	@Override
	ArrayBuilder<Integer, Integer> createArrayBuilder() {
		return new ArrayBuilder<>(new IdentidadeTransformar<Integer>()
			, new IdentidadeArrayTransformar<Integer>());
	}
}
