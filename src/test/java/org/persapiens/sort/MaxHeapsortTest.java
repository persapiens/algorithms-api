package org.persapiens.sort;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
public class MaxHeapsortTest {
	private Heapsort maxHeapsort() {
		return Heapsort.builder().ascending(true).build();
	}
	
	@Test
	public void emptyArray () {
		Integer[] items = new Integer[] {};
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new Integer[]{});
	}
	
	@Test
	public void singleArray () {
		Integer[] items = new Integer[] {5};
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new Integer[]{5});
	}	
	
	@Test
	public void twoElementsSorted () {
		Integer[] items = new Integer[] {1,2};
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new Integer[]{1,2});
	}	
	
	@Test
	public void twoElementsUnsorted () {
		Integer[] items = new Integer[] {2,1};
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new Integer[]{1,2});
	}	
	
	@Test
	public void threeElementsSorted () {
		Integer[] items = new Integer[] {1,2,3};
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new Integer[]{1,2,3});
	}	
	
	@Test
	public void threeElements132 () {
		Integer[] items = new Integer[] {1,3,2};
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new Integer[]{1,2,3});
	}	
	
	@Test
	public void threeElements213 () {
		Integer[] items = new Integer[] {2,1,3};
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new Integer[]{1,2,3});
	}	
	
	@Test
	public void threeElements231 () {
		Integer[] items = new Integer[] {2,3,1};
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new Integer[]{1,2,3});
	}	
	
	@Test
	public void threeElements312 () {
		Integer[] items = new Integer[] {3,1,2};
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new Integer[]{1,2,3});
	}	
	
	@Test
	public void threeElements321 () {
		Integer[] items = new Integer[] {3,2,1};
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new Integer[]{1,2,3});
	}	
}
