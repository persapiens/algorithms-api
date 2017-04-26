package org.persapiens.sort;

/**
 *
 * @author marcelo
 */
public class HeapSortMaxTest extends AbstractSortAscendingTest {
    @Override
    protected Sort createSort() {
        return HeapSort.builder().ascending(true).build();
    }
}
