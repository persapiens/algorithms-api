package org.persapiens.algorithms.graph.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author marcelo fernandes
 */
public class DisjointSet <T> {

	private List<Set<T>> listOfSetOfT = new ArrayList<>();

	public void makeSet(T element) {
		listOfSetOfT.add(new HashSet<>(Arrays.asList(element)));
	}
	
	private int indexOf(T element) {
		int result = -1;
		for (int index = 0; index < listOfSetOfT.size(); index++) {
			Set<T> set = listOfSetOfT.get(index);
			if (set.contains(element)) {
				result = index;				
				break;
			}
		}
		return result;
	}
	
	public Set<T> findSet(T element) {
		Set<T> result = null;
		int index = indexOf(element);
		if (index != -1) {
			result = listOfSetOfT.get(index);
		}
		return result;
	}

	public void unionAll(T u, T v) {
		Set<T> uSet = findSet(u);
		Set<T> vSet = findSet(v);
		listOfSetOfT.remove(uSet);
		vSet.addAll(uSet);		
	}
}
