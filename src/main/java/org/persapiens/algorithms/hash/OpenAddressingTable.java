package org.persapiens.algorithms.hash;

/**
 *
 * @author marcelo fernandes
 */
public class OpenAddressingTable implements Table <Integer> {

	private static Integer DELETED = Integer.MIN_VALUE;
	
	private ProbingMethod probing;
	
	private Integer[] T;

	public OpenAddressingTable(ProbingMethod probing) {
		this.probing = probing;
		this.T = new Integer[this.probing.getM()];
	}

	private int hash(Integer key, int i) {
		return this.probing.hash(key, i);
	}

	@Override
	public Integer search(int key) {
		Integer result = null;
		int i = 0;
		do {
			int j = hash(key, i);
			if (T[j].equals(key) ) {
				result = key;
			}
			i++;
		}
		while (result == null && i < probing.getM());
		return result;
	}

	@Override
	public void insert(Integer key) {
		int i = 0;
		boolean inserted = false;
		do {
			int j = hash(key, i);
			if (T[j] == null || DELETED.equals(T[j])) {
				T[j] = key;
				inserted = true;
			}
			else {
				i++;
			}
		}
		while (!inserted && i < probing.getM());
		if (!inserted) {
			throw new RuntimeException("Hash table overflow");
		}
	}

	@Override
	public void delete(Integer key) {
		boolean deleted = false;
		int i = 0;
		do {
			int j = hash(key, i);
			if (T[j].equals(key) ) {
				T[key] = DELETED;
				deleted = true;
			}
			i++;
		}
		while (!deleted && i < probing.getM());
	}
	
}
