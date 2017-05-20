package org.persapiens.algorithms.sort;

/**
 *
 * @author marcelo
 */
public class BucketSortDescendingTest extends AbstractSortTest <Integer, Double> {

    @Override
    protected Sort createSort() {
        return BucketSort.builder()
			.ascending(false)
			.build();
    }
	
	@Override
	ArrayBuilder<Integer, Double> createArrayBuilder() {
		return new ArrayBuilder<>(new IdentidadeTransformar<Integer>()
			, new DistribuicaoUniformeArrayTransformar());
	}
}
