package org.persapiens.sort;

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
		int[] items = new int[] {};
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new int[]{});
	}
	
	@Test
	public void singleArray () {
		int[] items = new int[] {5};
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new int[]{5});
	}	
	
	@Test
	public void twoElementsSorted () {
		int[] items = new int[] {1,2};
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new int[]{1,2});
	}	
	
	@Test
	public void twoElementsUnsorted () {
		int[] items = new int[] {2,1};
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new int[]{1,2});
	}	
	
	@Test
	public void threeElementsSorted () {
		int[] items = new int[] {1,2,3};
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new int[]{1,2,3});
	}	
	
	@Test
	public void threeElements132 () {
		int[] items = new int[] {1,3,2};
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new int[]{1,2,3});
	}	
	
	@Test
	public void threeElements213 () {
		int[] items = new int[] {2,1,3};
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new int[]{1,2,3});
	}	
	
	@Test
	public void threeElements231 () {
		int[] items = new int[] {2,3,1};
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new int[]{1,2,3});
	}	
	
	@Test
	public void threeElements312 () {
		int[] items = new int[] {3,1,2};
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new int[]{1,2,3});
	}	
	
	@Test
	public void threeElements321 () {
		int[] items = new int[] {3,2,1};
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new int[]{1,2,3});
	}	
}
