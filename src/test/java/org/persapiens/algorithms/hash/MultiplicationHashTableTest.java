package org.persapiens.algorithms.hash;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
@Test
public class MultiplicationHashTableTest {
	public void insert3ElementsWithCollision () {
		HashTable table = new HashTable(new MultiplicationHashMethod(0.61, 5));
		table.insert(10);
		
		assertThat(table.search(10))
			.isEqualTo(10);
	}
}
