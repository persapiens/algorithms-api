package org.persapiens.sort;

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
public class MergeSort <T extends Comparable> extends AbstractSort<T> {	

    @Builder
    public MergeSort(boolean ascending) {
        super(ascending);
    }
    
	@Override
	public List<T> sort(List<T> items) {
        return mergeSort(items, 0, items.size() -1);
	}
    
    private List<T> mergeSort(List<T> items, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            items = mergeSort(items, left, middle);
            items = mergeSort(items, middle +1, right);
            items = merge(items, left, middle, right);
        }
        return items;
    }
    
    private List<T> merge(List<T> items, int left, int middle, int right) {
        int n1 = middle - left + 1;
        List<T> L = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            L.add(i, items.get(left + i));
        }

        int n2 = right - middle;
        List<T> R = new ArrayList<>();
        for (int j = 0; j < n2; j++) {
            R.add(j, items.get(middle + j +1));
        }
        
        L.add(n1, null);
        R.add(n2, null);
        
        int i = 0;
        int j = 0;
        
        for(int k = left; k <= right; k++) {
            if (!compare(L.get(i), R.get(j))) {
                items.set(k, L.get(i));
                i++;
            }
			else {
				items.set(k, R.get(j));
                j++;
            }
        }
        
        return items;
    }
}
