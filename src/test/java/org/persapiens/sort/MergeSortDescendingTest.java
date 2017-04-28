package org.persapiens.sort;

/**
 *
 * @author marcelo
 */
public class MergeSortDescendingTest extends AbstractSortDescendingTest{

    @Override
    protected Sort createSort() {
        return MergeSort.builder().ascending(false).build();
    }
}
