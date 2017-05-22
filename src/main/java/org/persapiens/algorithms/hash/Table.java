package org.persapiens.algorithms.hash;

/**
 *
 * @author marcelo fernandes
 */
public interface Table <D extends Comparable> {
	D search(int key);
	
	void insert(D element);
	
	void delete(D element);
}
