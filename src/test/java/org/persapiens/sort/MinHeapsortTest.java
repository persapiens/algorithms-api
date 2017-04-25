package org.persapiens.sort;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
public class MinHeapsortTest {
	private Heapsort minHeapsort() {
		return Heapsort.builder().ascending(false).build();
	}
	
	@Test
	public void emptyArray () {
		Integer[] items = new Integer[] {};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new Integer[]{});
	}
	
	@Test
	public void singleArray () {
		Integer[] items = new Integer[] {5};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new Integer[]{5});
	}	
	
	@Test
	public void twoElementsSorted () {
		Integer[] items = new Integer[] {1,2};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new Integer[]{2,1});
	}	
	
	@Test
	public void twoElementsUnsorted () {
		Integer[] items = new Integer[] {2,1};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new Integer[]{2,1});
	}	
	
	@Test
	public void threeElementsSorted () {
		Integer[] items = new Integer[] {1,2,3};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new Integer[]{3,2,1});
	}	
	
	@Test
	public void threeElements132 () {
		Integer[] items = new Integer[] {1,3,2};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new Integer[]{3,2,1});
	}	
	
	@Test
	public void threeElements213 () {
		Integer[] items = new Integer[] {2,1,3};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new Integer[]{3,2,1});
	}	
	
	@Test
	public void threeElements231 () {
		Integer[] items = new Integer[] {2,3,1};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new Integer[]{3,2,1});
	}	
	
	@Test
	public void threeElements312 () {
		Integer[] items = new Integer[] {3,1,2};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new Integer[]{3,2,1});
	}	
	
	@Test
	public void threeElements321 () {
		Integer[] items = new Integer[] {3,2,1};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new Integer[]{3,2,1});
	}	
	
	@Test
	public void fourElements1234 () {
		Integer[] items = new Integer[] {1,2,3,4};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new Integer[]{4,3,2,1});
	}	
	
	@Test
	public void fourElements1243 () {
		Integer[] items = new Integer[] {1,2,4,3};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new Integer[]{4,3,2,1});
	}	
	
	@Test
	public void fourElements1342 () {
		Integer[] items = new Integer[] {1,3,4,2};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new Integer[]{4,3,2,1});
	}	
	
	@Test
	public void fourElements4321 () {
		Integer[] items = new Integer[] {4,3,2,1};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new Integer[]{4,3,2,1});
	}	
}
