package org.persapiens.sort;

import org.testng.annotations.BeforeClass;

/**
 *
 * @author marcelo
 */
public abstract class AbstractSortTest {
    ArrayBuilder arrayBuilder = new ArrayBuilder();
    
	Sort sort;

    abstract Sort createSort();

    @BeforeClass
    protected void init() {
        sort = createSort();
    }    
}
