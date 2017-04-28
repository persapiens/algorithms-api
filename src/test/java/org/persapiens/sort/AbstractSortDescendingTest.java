package org.persapiens.sort;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
public abstract class AbstractSortDescendingTest extends AbstractSortTest {    
	@Test
	public void emptyArray () {
		assertThat(sort.sort(arrayBuilder.emptyArray()))
			.isEqualTo(arrayBuilder.emptyArray());
	}
	
	@Test
	public void singleArray () {
		assertThat(sort.sort(arrayBuilder.singleArray()))
			.isEqualTo(arrayBuilder.singleArray());
	}	
	
	@Test
	public void twoElementsAscendingSorted () {
		assertThat(sort.sort(arrayBuilder.twoElementsAscendingSorted()))
			.isEqualTo(arrayBuilder.twoElementsDescendingSorted());
	}	
	
	@Test
	public void twoElementsDescendingSorted () {
		assertThat(sort.sort(arrayBuilder.twoElementsDescendingSorted()))
			.isEqualTo(arrayBuilder.twoElementsDescendingSorted());
	}	
	
	@Test
	public void threeElementsAscendingSorted () {
		assertThat(sort.sort(arrayBuilder.threeElementsAscendingSorted()))
			.isEqualTo(arrayBuilder.threeElementsDescendingSorted());
	}	
	
	@Test
	public void threeElements132 () {
		assertThat(sort.sort(arrayBuilder.threeElements132()))
			.isEqualTo(arrayBuilder.threeElementsDescendingSorted());
	}	
	
	@Test
	public void threeElements213 () {
		assertThat(sort.sort(arrayBuilder.threeElements213()))
			.isEqualTo(arrayBuilder.threeElementsDescendingSorted());
	}	
	
	@Test
	public void threeElements231 () {
		assertThat(sort.sort(arrayBuilder.threeElements231()))
			.isEqualTo(arrayBuilder.threeElementsDescendingSorted());
	}	
	
	@Test
	public void threeElements312 () {
		assertThat(sort.sort(arrayBuilder.threeElements312()))
			.isEqualTo(arrayBuilder.threeElementsDescendingSorted());
	}	
	
	@Test
	public void threeElementsDescendingSorted () {
		assertThat(sort.sort(arrayBuilder.threeElementsDescendingSorted()))
			.isEqualTo(arrayBuilder.threeElementsDescendingSorted());
    }
	
	@Test
	public void fourElementsAscendingSorted () {
		assertThat(sort.sort(arrayBuilder.fourElementsAscendingSorted()))
			.isEqualTo(arrayBuilder.fourElementsDescendingSorted());
	}	
	
	@Test
	public void fourElements1243 () {
		assertThat(sort.sort(arrayBuilder.fourElements1243()))
			.isEqualTo(arrayBuilder.fourElementsDescendingSorted());
	}	
	
	@Test
	public void fourElements1342 () {
		assertThat(sort.sort(arrayBuilder.fourElements1342()))
			.isEqualTo(arrayBuilder.fourElementsDescendingSorted());
	}	
	
	@Test
	public void fourElementsDescendingSorted () {
		assertThat(sort.sort(arrayBuilder.fourElementsDescendingSorted()))
			.isEqualTo(arrayBuilder.fourElementsDescendingSorted());
	}	
	
	@Test
	public void tenElementsAscendingSorted () {
		assertThat(sort.sort(arrayBuilder.tenElementsAscendingSorted()))
			.isEqualTo(arrayBuilder.tenElementsDescendingSorted());
	}	
	
	@Test
	public void tenElementsDescendingSorted () {
		assertThat(sort.sort(arrayBuilder.tenElementsDescendingSorted()))
			.isEqualTo(arrayBuilder.tenElementsDescendingSorted());
	}	
    
}
