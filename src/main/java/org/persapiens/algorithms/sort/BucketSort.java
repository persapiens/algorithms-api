package org.persapiens.algorithms.sort;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 *
 * @author marcelo
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BucketSort extends AbstractSort <Double> {	
	
    @Builder
    public BucketSort(boolean ascending) {
        super(ascending);
    }    
	
	@Override
	public List<Double> sort(List<Double> items) {
		List<List<Double>> B = new ArrayList<>();
		
		int n = items.size();
		
		for(int i= 0; i< n; i++) {
			B.add(new ArrayList<>());
		}

		for(int i = 0; i< n; i++) {
			double value = items.get(i);
			int index = new BigDecimal(n * value).intValue();
			B.get(index).add(value);			
		}
		
		InsertionSort insertionSort = InsertionSort.builder().ascending(isAscending()).build();
		for(int i=0; i< n; i++) {
			insertionSort.sort(B.get(i));
		}
		
		List<Double> result = new ArrayList<>();
		if (isAscending()) {
			for(int i =0; i < B.size(); i++) {
				result.addAll(B.get(i));
			}
		}
		else {
			for(int i =B.size()-1; i >=0; i--) {
				result.addAll(B.get(i));
			}			
		}
		return result;
	}
}
