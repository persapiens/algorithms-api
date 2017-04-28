package org.persapiens.sort;

/**
 *
 * @author marcelo
 */
public class CountSortDescendingTest extends AbstractSortDescendingTest{

    @Override
    protected Sort createSort() {
        return CountSort.builder()
			.ascending(false)
			.k(10)
			.build();
    }
}
