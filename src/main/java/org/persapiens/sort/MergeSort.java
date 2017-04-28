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
public class MergeSort extends AbstractSort {	

    @Builder
    public MergeSort(boolean ascending) {
        super(ascending);
    }
    
	@Override
	public <T extends Comparable> List<T> sort(List<T> items) {
        return mergeSort(items, 0, items.size() -1);
	}
    
    private <T extends Comparable> List<T> mergeSort(List<T> items, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            items = mergeSort(items, p, q);
            items = mergeSort(items, q +1, r);
            items = merge(items, p, q, r);
        }
        return items;
    }
    
    private <T extends Comparable> List<T> merge(List<T> items, int p, int q, int r) {
        int n1 = q - p + 1;
        List<T> L = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            L.add(i, items.get(p + i));
        }
        
        int n2 = r - q;
        List<T> R = new ArrayList<>();
        for (int j = 0; j < n2; j++) {
            R.add(j, items.get(q + j));
        }
        
        L.add(n1, null);
        R.add(n2, null);
        
        int i = 0;
        int j = 0;
        
        for(int k = p; k < r; k++) {
            if (L.get(i).compareTo(R.get(j)) <= 0) {
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
