package org.persapiens.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author marcelo
 */
public class ArrayBuilder {
	public List<Integer> emptyArray () {
		return new ArrayList<> ();
	}
	
	public List<Integer> singleArray () {
		return Arrays.asList(5);
	}	
	
	public List<Integer> twoElementsAscendingSorted () {
		return Arrays.asList(1,2);
	}	
	
	public List<Integer> twoElementsDescendingSorted () {
		return Arrays.asList(2,1);
	}	
	
	public List<Integer> threeElementsAscendingSorted () {
		return Arrays.asList(1,2,3);
	}	
	
	public List<Integer> threeElements132 () {
		return Arrays.asList(1,3,2);
	}	
	
	public List<Integer> threeElements213 () {
		return Arrays.asList(2,1,3);
	}	
	
	public List<Integer> threeElements231 () {
		return Arrays.asList(2,3,1);
	}	
	
	public List<Integer> threeElements312 () {
		return Arrays.asList(3,1,2);
	}	
	
	public List<Integer> threeElementsDescendingSorted () {
		return Arrays.asList(3,2,1);
	}	
	
	public List<Integer> fourElementsAscendingSorted () {
		return Arrays.asList(1,2,3,4);
	}	
	
	public List<Integer> fourElements1243 () {
		return Arrays.asList(1,2,4,3);
	}	
	
	public List<Integer> fourElements1342 () {
		return Arrays.asList(1,3,4,2);
	}	
	
	public List<Integer> fourElementsDescendingSorted () {
		return Arrays.asList(4,3,2,1);
	}	
	
	public List<Integer> tenElementsDescendingSorted () {
		return Arrays.asList(9,8,7,6,5,4,3,2,1,0);
	}	
	
	public List<Integer> tenElementsAscendingSorted () {
		return Arrays.asList(0,1,2,3,4,5,6,7,8,9);
	}	
}
