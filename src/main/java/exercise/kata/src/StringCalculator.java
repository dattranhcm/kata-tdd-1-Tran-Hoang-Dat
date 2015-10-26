package exercise.kata.src;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
	private static StringCalculator instance = new StringCalculator();

	private String regex = "[,\n]";

	private String separateLine = "//";

	private int limit = 1000;

	private StringCalculator() {
	}

	public static StringCalculator getInstance() {
		return instance;
	}

	private void buildRegex(String delimiter) {
		if(!regex.contains(delimiter)){
			this.regex = new StringBuilder(regex).insert(regex.length() - 1,
					delimiter).toString();
		}
		
	}

	public int add(String numbers) {
		int result = 0;
		if (numbers.startsWith(separateLine)) {
			int delimiterIndex = numbers.indexOf(separateLine) + 2;
			this.buildRegex(numbers.substring(delimiterIndex,
					delimiterIndex + 1));
			numbers = new StringBuilder(numbers).replace(0, delimiterIndex, "")
					.toString();
		}
		List<Integer> negative = new ArrayList<Integer>();
		String[] numArr = numbers.split(regex);
		for (String number : numArr) {
			if (!number.isEmpty()) {
				int n = Integer.parseInt(number);
				if (n < 0) {
					negative.add(n);
				}
				if (n < limit) {
					result = result + n;
				}

			}
		}
		if (negative.size() > 0) {
			throw new RuntimeException("Negatives not allowed: "
					+ negative.toString());
		}
		return result;
	}
}
