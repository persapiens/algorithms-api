package org.persapiens.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
		List<Integer> items = new ArrayList<> ();
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(new ArrayList<Integer>());
	}
	
	@Test
	public void singleArray () {
		List<Integer> items = Arrays.asList(5);
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(Arrays.asList(5));
	}	
	
	@Test
	public void twoElementsSorted () {
		List<Integer> items = Arrays.asList(1,2);
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(Arrays.asList(1,2));
	}	
	
	@Test
	public void twoElementsUnsorted () {
		List<Integer> items = Arrays.asList(2,1);
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(Arrays.asList(1,2));
	}	
	
	@Test
	public void threeElementsSorted () {
		List<Integer> items = Arrays.asList(1,2,3);
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(Arrays.asList(1,2,3));
	}	
	
	@Test
	public void threeElements132 () {
		List<Integer> items = Arrays.asList(1,3,2);
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(Arrays.asList(1,2,3));
	}	
	
	@Test
	public void threeElements213 () {
		List<Integer> items = Arrays.asList(2,1,3);
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(Arrays.asList(1,2,3));
	}	
	
	@Test
	public void threeElements231 () {
		List<Integer> items = Arrays.asList(2,3,1);
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(Arrays.asList(1,2,3));
	}	
	
	@Test
	public void threeElements312 () {
		List<Integer> items = Arrays.asList(3,1,2);
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(Arrays.asList(1,2,3));
	}	
	
	@Test
	public void threeElements321 () {
		List<Integer> items = Arrays.asList(3,2,1);
		
		items = maxHeapsort().sort(items);
		
		assertThat(items)
			.isEqualTo(Arrays.asList(1,2,3));
	}	
}
