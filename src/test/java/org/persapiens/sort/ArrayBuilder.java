package org.persapiens.sort;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;

/**
 *
 * @author marcelo
 */
@AllArgsConstructor
public class ArrayBuilder <T> {
	
	private Transformar<Integer, T> transformar;
	
	private List<T> transformar(Integer... integers) {
		List<T> result = new ArrayList<>();
		for (int i = 0; i < integers.length; i++) {
			result.add(transformar.transfomar(integers[i]));
		}
		return result;
	}
	
	public List<T> emptyArray () {
		return new ArrayList<> ();
	}
	
	public List<T> singleArray () {
		return transformar(5);
	}	
	
	public List<T> twoElementsAscendingSorted () {
		return transformar(1,2);
	}	
	
	public List<T> twoElementsDescendingSorted () {
		return transformar(2,1);
	}	
	
	public List<T> threeElementsAscendingSorted () {
		return transformar(1,2,3);
	}	
	
	public List<T> threeElements132 () {
		return transformar(1,3,2);
	}	
	
	public List<T> threeElements213 () {
		return transformar(2,1,3);
	}	
	
	public List<T> threeElements231 () {
		return transformar(2,3,1);
	}	
	
	public List<T> threeElements312 () {
		return transformar(3,1,2);
	}	
	
	public List<T> threeElementsDescendingSorted () {
		return transformar(3,2,1);
	}	
	
	public List<T> fourElementsAscendingSorted () {
		return transformar(1,2,3,4);
	}	
	
	public List<T> fourElements1243 () {
		return transformar(1,2,4,3);
	}	
	
	public List<T> fourElements1342 () {
		return transformar(1,3,4,2);
	}	
	
	public List<T> fourElementsDescendingSorted () {
		return transformar(4,3,2,1);
	}	
	
	public List<T> tenElementsDescendingSorted () {
		return transformar(9,8,7,6,5,4,3,2,1,0);
	}	
	
	public List<T> tenElementsAscendingSorted () {
		return transformar(0,1,2,3,4,5,6,7,8,9);
	}	
	
	public List<T> sixElementsWith3Digits () {
		return transformar(329,457,657,839,436,720,355);
	}	
	
	public List<T> sixElementsWith3DigitsSortedAscending () {
		return transformar(329,355,436,457,657,720,839);
	}	
	
	public List<T> sixElementsWith3DigitsSortedDescending () {
		return transformar(839,720,657,457,436,355,329);
	}	
}
