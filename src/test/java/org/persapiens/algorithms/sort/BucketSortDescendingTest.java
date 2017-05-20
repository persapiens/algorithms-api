package org.persapiens.algorithms.sort;

import org.persapiens.algorithms.sort.Sort;
import org.persapiens.algorithms.sort.BucketSort;

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
