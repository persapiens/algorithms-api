package org.persapiens.algorithms.sort;

/**
 *
 * @author marcelo
 */
public class DaryHeapSortMinTest extends AbstractSortTest  <Integer, Integer>{
    @Override
    protected Sort createSort() {
        return DaryHeapSort.builder()
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
