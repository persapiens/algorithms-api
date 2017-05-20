package org.persapiens.algorithms.sort;

import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 *
 * @author marcelo
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InsertionSort <T extends Comparable> extends AbstractSort <T> {	

    @Builder
    public InsertionSort(boolean ascending) {
        super(ascending);
    }
    
	@Override
	public List<T> sort(List<T> items) {
		for(int counter = 1; counter < items.size(); counter ++) {
            T key = items.get(counter);
                    
			// Insert A[j]  into the sorted sequence A[1 .. j - 1].
			int i = counter - 1;
			
            while( (i >= 0) && compare(items.get(i), key)) {
                items.set(i+1, items.get(i));
                i --;
            }
            items.set(i+1, key);
		}
		return items;
	}	
}
