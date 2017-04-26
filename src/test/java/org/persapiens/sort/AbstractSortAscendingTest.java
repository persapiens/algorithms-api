package org.persapiens.sort;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
public abstract class AbstractSortAscendingTest extends AbstractSortTest {    
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
			.isEqualTo(arrayBuilder.twoElementsAscendingSorted());
	}	
	
	@Test
	public void twoElementsDescendingSorted () {
		assertThat(sort.sort(arrayBuilder.twoElementsDescendingSorted()))
			.isEqualTo(arrayBuilder.twoElementsAscendingSorted());
	}	
	
	@Test
	public void threeElementsAscendingSorted () {
		assertThat(sort.sort(arrayBuilder.threeElementsAscendingSorted()))
			.isEqualTo(arrayBuilder.threeElementsAscendingSorted());
	}	
	
	@Test
	public void threeElements132 () {
		assertThat(sort.sort(arrayBuilder.threeElements132()))
			.isEqualTo(arrayBuilder.threeElementsAscendingSorted());
	}	
	
	@Test
	public void threeElements213 () {
		assertThat(sort.sort(arrayBuilder.threeElements213()))
			.isEqualTo(arrayBuilder.threeElementsAscendingSorted());
	}	
	
	@Test
	public void threeElements231 () {
		assertThat(sort.sort(arrayBuilder.threeElements231()))
			.isEqualTo(arrayBuilder.threeElementsAscendingSorted());
	}	
	
	@Test
	public void threeElements312 () {
		assertThat(sort.sort(arrayBuilder.threeElements312()))
			.isEqualTo(arrayBuilder.threeElementsAscendingSorted());
	}	
	
	@Test
	public void threeElementsDescendingSorted () {
		assertThat(sort.sort(arrayBuilder.threeElementsDescendingSorted()))
			.isEqualTo(arrayBuilder.threeElementsAscendingSorted());
    }
	
	@Test
	public void fourElementsAscendingSorted () {
		assertThat(sort.sort(arrayBuilder.fourElementsAscendingSorted()))
			.isEqualTo(arrayBuilder.fourElementsAscendingSorted());
	}	
	
	@Test
	public void fourElements1243 () {
		assertThat(sort.sort(arrayBuilder.fourElements1243()))
			.isEqualTo(arrayBuilder.fourElementsAscendingSorted());
	}	
	
	@Test
	public void fourElements1342 () {
		assertThat(sort.sort(arrayBuilder.fourElements1342()))
			.isEqualTo(arrayBuilder.fourElementsAscendingSorted());
	}	
	
	@Test
	public void fourElements4321 () {
		assertThat(sort.sort(arrayBuilder.fourElementsDescendingSorted()))
			.isEqualTo(arrayBuilder.fourElementsAscendingSorted());
	}	
    
}
