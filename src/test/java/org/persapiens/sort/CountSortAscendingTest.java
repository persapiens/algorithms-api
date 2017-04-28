package org.persapiens.sort;

/**
 *
 * @author marcelo
 */
public class CountSortAscendingTest extends AbstractSortAscendingTest{

    @Override
    protected Sort createSort() {
        return CountSort.builder()
			.ascending(true)
			.k(10)
			.build();
    }
}
