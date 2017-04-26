package org.persapiens.sort;

/**
 *
 * @author marcelo
 */
public class MergeSortAscendingTest extends AbstractSortAscendingTest{

    @Override
    protected Sort createSort() {
        return MergeSort.builder().ascending(true).build();
    }
}
