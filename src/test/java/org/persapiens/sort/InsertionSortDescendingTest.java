package org.persapiens.sort;

/**
 *
 * @author marcelo
 */
public class InsertionSortDescendingTest extends AbstractSortDescendingTest {
    @Override
    protected Sort createSort() {
        return InsertionSort.builder().ascending(false).build();
    }
}
