package org.persapiens.sort;

import java.util.Arrays;
import java.util.List;
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
		List<Integer> items = Arrays.asList();
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(Arrays.asList());
	}
	
	@Test
	public void singleArray () {
		List<Integer> items = Arrays.asList(5);
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(Arrays.asList(5));
	}	
	
	@Test
	public void twoElementsSorted () {
		List<Integer> items = Arrays.asList(1,2);
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(Arrays.asList(2,1));
	}	
	
	@Test
	public void twoElementsUnsorted () {
		List<Integer> items = Arrays.asList(2,1);
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(Arrays.asList(2,1));
	}	
	
	@Test
	public void threeElementsSorted () {
		List<Integer> items = Arrays.asList(1,2,3);
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(Arrays.asList(3,2,1));
	}	
	
	@Test
	public void threeElements132 () {
		List<Integer> items = Arrays.asList(1,3,2);
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(Arrays.asList(3,2,1));
	}	
	
	@Test
	public void threeElements213 () {
		List<Integer> items = Arrays.asList(2,1,3);
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(Arrays.asList(3,2,1));
	}	
	
	@Test
	public void threeElements231 () {
		List<Integer> items = Arrays.asList(2,3,1);
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(Arrays.asList(3,2,1));
	}	
	
	@Test
	public void threeElements312 () {
		List<Integer> items = Arrays.asList(3,1,2);
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(Arrays.asList(3,2,1));
	}	
	
	@Test
	public void threeElements321 () {
		List<Integer> items = Arrays.asList(3,2,1);
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(Arrays.asList(3,2,1));
	}	
	
	@Test
	public void fourElements1234 () {
		List<Integer> items = Arrays.asList(1,2,3,4);
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(Arrays.asList(4,3,2,1));
	}	
	
	@Test
	public void fourElements1243 () {
		List<Integer> items = Arrays.asList(1,2,4,3);
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(Arrays.asList(4,3,2,1));
	}	
	
	@Test
	public void fourElements1342 () {
		List<Integer> items = Arrays.asList(1,3,4,2);
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(Arrays.asList(4,3,2,1));
	}	
	
	@Test
	public void fourElements4321 () {
		List<Integer> items = Arrays.asList(4,3,2,1);
		
		items = minHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(Arrays.asList(4,3,2,1));
	}	
}
