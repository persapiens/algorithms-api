package org.persapiens.algorithms.hash;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
@Test
public class DirectTableTest {
	public void insert2Elements () {
		DirectTable table = new DirectTable(2);
		table.insert(0);
		table.insert(1);
		
		assertThat(table.search(0))
			.isEqualTo(0);
		assertThat(table.search(1))
			.isEqualTo(1);
	}
	
	public void delete1Element () {
		DirectTable table = new DirectTable(1);
		table.insert(0);
		
		assertThat(table.search(0))
			.isEqualTo(0);
		
		table.delete(0);
		
		assertThat(table.search(0))
			.isEqualTo(null);
	}
}
