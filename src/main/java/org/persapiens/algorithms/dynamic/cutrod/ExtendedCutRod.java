package org.persapiens.algorithms.dynamic.cutrod;

/**
 *
 * @author marcelo fernandes
 */
public interface ExtendedCutRod {
	ExtendedCutRodResult measure(int[] prices, int n);
	void print(int[] prices, int n);
}
