package org.persapiens.algorithms.hash;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

/**
 *
 * @author marcelo
 */
@Test
public class DivisionHashTableTest {
	public void insert3ElementsWithCollision () {
		HashTable table = new HashTable(new DivisionHashMethod(10));
		table.insert(0);
		table.insert(1);
		table.insert(10);
		
		assertThat(table.search(0))
			.isEqualTo(0);
		assertThat(table.search(1))
			.isEqualTo(1);
		assertThat(table.search(10))
			.isEqualTo(10);
	}
	
	public void deleteSemIncluir0 () {
		HashTable table = new HashTable(new DivisionHashMethod(10));
		
		assertThat(table.search(0))
			.isNull();
		
		table.delete(0);
		
		assertThat(table.search(0))
			.isNull();
	}
	
	public void deleteIncluindo0 () {
		HashTable table = new HashTable(new DivisionHashMethod(10));
		table.insert(0);
		
		assertThat(table.search(0))
			.isEqualTo(0);
		
		table.delete(0);
		
		assertThat(table.search(0))
			.isNull();
	}
	
	public void deleteIncluindo0e10 () {
		HashTable table = new HashTable(new DivisionHashMethod(10));
		table.insert(0);
		table.insert(10);
		
		assertThat(table.search(0))
			.isEqualTo(0);
		assertThat(table.search(10))
			.isEqualTo(10);
		
		table.delete(0);		
		assertThat(table.search(0))
			.isNull();
		
		table.delete(10);		
		assertThat(table.search(10))
			.isNull();
	}
}
