package org.persapiens.algorithms.graph;

/**
 *
 * @author marcelo
 */
public class Matrix {

	private int[][] element;

	public int getRows() {
		return element.length;
	}

	public int get(int r, int c) {
		return element[r][c];
	}
	
	public void set(int r, int c, int w) {
		element[r][c] = w;
	}
	
	public Matrix(int numberOfVertexes) {
		element = new int[numberOfVertexes][numberOfVertexes];
		for (int i = 0; i < numberOfVertexes; i++) {
			element[i] = new int[numberOfVertexes];
		}
	}
}
