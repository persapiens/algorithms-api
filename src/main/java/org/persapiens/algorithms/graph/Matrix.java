package org.persapiens.algorithms.graph;

/**
 *
 * @author marcelo
 */
public class Matrix {

	private Integer[][] element;

	public static final Integer NIL = new Integer(Integer.MIN_VALUE);
	public static final Integer INFINITY = new Integer(Integer.MAX_VALUE / 2);
	
	public Integer getRows() {
		return element.length;
	}

	public Integer get(int r, int c) {
		return element[r][c];
	}
	
	public void set(int r, int c, Integer w) {
		element[r][c] = w;
	}
	
	public Matrix(int numberOfVertexes) {
		element = new Integer[numberOfVertexes][numberOfVertexes];
		for (int i = 0; i < numberOfVertexes; i++) {
			element[i] = new Integer[numberOfVertexes];
		}
	}
}
