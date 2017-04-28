package org.persapiens.sort;

/**
 *
 * @author marcelo
 */
public class QuickSortDescendingTest extends AbstractSortDescendingTest{

    @Override
    protected Sort createSort() {
        return QuickSort.builder().ascending(false).build();
    }
}
