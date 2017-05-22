package org.persapiens.algorithms.hash;

/**
 *
 * @author marcelo fernandes
 */
public interface HashMethod {

	int getM();
	
	int hash(int key);
    
}
