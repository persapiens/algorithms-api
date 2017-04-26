package org.persapiens.sort;

/**
 *
 * @author marcelo
 */
public class HeapSortMinTest extends AbstractSortDescendingTest {
    @Override
    protected Sort createSort() {
        return HeapSort.builder().ascending(false).build();
    }
}
