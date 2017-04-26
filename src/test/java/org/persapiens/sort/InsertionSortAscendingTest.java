package org.persapiens.sort;

/**
 *
 * @author marcelo
 */
public class InsertionSortAscendingTest extends AbstractSortAscendingTest{

    @Override
    protected Sort createSort() {
        return InsertionSort.builder().ascending(true).build();
    }
}
