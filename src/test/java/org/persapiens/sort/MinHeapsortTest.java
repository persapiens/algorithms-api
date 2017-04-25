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
		int[] items = new int[] {};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new int[]{});
	}
	
	@Test
	public void singleArray () {
		int[] items = new int[] {5};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new int[]{5});
	}	
	
	@Test
	public void twoElementsSorted () {
		int[] items = new int[] {1,2};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new int[]{2,1});
	}	
	
	@Test
	public void twoElementsUnsorted () {
		int[] items = new int[] {2,1};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new int[]{2,1});
	}	
	
	@Test
	public void threeElementsSorted () {
		int[] items = new int[] {1,2,3};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new int[]{3,2,1});
	}	
	
	@Test
	public void threeElements132 () {
		int[] items = new int[] {1,3,2};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new int[]{3,2,1});
	}	
	
	@Test
	public void threeElements213 () {
		int[] items = new int[] {2,1,3};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new int[]{3,2,1});
	}	
	
	@Test
	public void threeElements231 () {
		int[] items = new int[] {2,3,1};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new int[]{3,2,1});
	}	
	
	@Test
	public void threeElements312 () {
		int[] items = new int[] {3,1,2};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new int[]{3,2,1});
	}	
	
	@Test
	public void threeElements321 () {
		int[] items = new int[] {3,2,1};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new int[]{3,2,1});
	}	
	
	@Test
	public void fourElements1234 () {
		int[] items = new int[] {1,2,3,4};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new int[]{4,3,2,1});
	}	
	
	@Test
	public void fourElements1243 () {
		int[] items = new int[] {1,2,4,3};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new int[]{4,3,2,1});
	}	
	
	@Test
	public void fourElements1342 () {
		int[] items = new int[] {1,3,4,2};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new int[]{4,3,2,1});
	}	
	
	@Test
	public void fourElements4321 () {
		int[] items = new int[] {4,3,2,1};
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new int[]{4,3,2,1});
	}	
}
