package org.persapiens.algorithms.hash;

/**
 *
 * @author marcelo fernandes
 */
public interface ProbingMethod {

	int getM();
	
	int hash(int key, int i);
    
}
