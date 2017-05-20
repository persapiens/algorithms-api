package org.persapiens.algorithms.sort;

import org.persapiens.algorithms.sort.SortUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcelo
 */
public class DistribuicaoUniformeArrayTransformar implements ArrayTransformar<Integer, Double> {

	@Override
	public List<Double> transfomar(List<Integer> entrada) {
		List<Double> result = new ArrayList<>(entrada.size());
		if (!entrada.isEmpty()) {
			int max = findMax(entrada);
			if (max != 0) {
				int numberOfDigits = numberOfDigits(max);
				int divisor = SortUtil.power(10, numberOfDigits);
				for (int i = 0; i < entrada.size(); i++) {
					int item = entrada.get(i);
					result.add(new Double(item) / divisor);
				}
			}
		}
		return result;
	}

	private int findMax(List<Integer> entrada) {
		int result = -1;
		for (int i = 0; i < entrada.size(); i++) {
			int item = entrada.get(i);
			if (item > result) {
				result = item;
			}
		}
		return result;
	}

	private int numberOfDigits(int number) {
		int result = 1;
		while (number > 10) {
			number = number / 10;
			result ++;
		}
		return result;		
	}
}
