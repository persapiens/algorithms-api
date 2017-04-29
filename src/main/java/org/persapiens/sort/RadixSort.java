package org.persapiens.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author marcelo
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RadixSort extends AbstractSort <Integer> {	

	@Getter
	private int d;
	
    @Builder
    public RadixSort(boolean ascending, int d) {
        super(ascending);
		this.d = d;
    }
    
	@Override
	public List<Integer> sort(List<Integer> items) {
		CountSort countSort = CountSort.builder().ascending(isAscending()).k(d*10).build();
		
		for(int counter = 0; counter < d; counter ++) {
			List<CountSortRegistry<Integer>> countSortRegistries = extractDigitItemMap(items, counter);
			countSortRegistries = countSort.sort(countSortRegistries);
			items = countSortRegistries.stream().map(registry -> registry.getValue()).collect(Collectors.toList());
		}
		return items;
	}	
	
	private List<CountSortRegistry<Integer>> extractDigitItemMap(List<Integer> items, int digit) {
		List<CountSortRegistry<Integer>> result = new ArrayList<>(items.size());
		
		items.forEach((item) -> {
			result.add(new CountSortRegistry<Integer>(extractDigit(item, digit), item));
		});
		
		return result;
	}

	private Integer extractDigit(Integer item, int digit) {
		return (item % power(10, (digit+1)) ) / power (10, digit);
	}

	public int power(int a, int b)
    {
		int power = 1;
		for(int c=0;c<b;c++)
		{
			power*=a;
		}
		return power;
	}

	private List<Integer> addDigitItems(List<Integer> result, List<Integer> digitItems, int digit) {
		for(int i = 0; i < result.size(); i++) {
			result.set(i, result.get(i) + digitItems.get(i) * power(10, digit));
		}
		return result;
	}
}
