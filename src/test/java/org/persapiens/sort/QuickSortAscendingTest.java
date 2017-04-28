package org.persapiens.sort;

/**
 *
 * @author marcelo
 */
public class QuickSortAscendingTest extends AbstractSortAscendingTest{

    @Override
    protected Sort createSort() {
        return QuickSort.builder().ascending(true).build();
    }
}
