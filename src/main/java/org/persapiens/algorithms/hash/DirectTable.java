package org.persapiens.algorithms.hash;

/**
 *
 * @author marcelo fernandes
 */
public class DirectTable implements Table <Integer> {
	
	private Integer[] T;

	public DirectTable(int m) {
		this.T = new Integer[m];
	}

	@Override
	public Integer search(int key) {
		return T[key];
	}

	@Override
	public void insert(Integer element) {
		T[element] = element;
	}

	@Override
	public void delete(Integer element) {
		T[element] = null;
	}
	
}
