package org.persapiens.sort;

/**
 *
 * @author marcelo
 */
public class BucketSortAscendingTest extends AbstractSortTest <Integer, Double> {

    @Override
    protected Sort createSort() {
        return BucketSort.builder()
			.ascending(true)
			.build();
    }
	
	@Override
	ArrayBuilder<Integer, Double> createArrayBuilder() {
		return new ArrayBuilder<>(new IdentidadeTransformar<Integer>()
			, new DistribuicaoUniformeArrayTransformar());
	}
}
