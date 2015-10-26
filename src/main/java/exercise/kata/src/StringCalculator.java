package exercise.kata.src;

public class StringCalculator {
	private static StringCalculator instance = new StringCalculator();

	private String regex = "[,\n]";
	
	private String separateLine ="//";

	private StringCalculator() {
	}

	public static StringCalculator getInstance() {
		return instance;
	}

	private void buildRegex(String delimiter) {
		this.regex = new StringBuilder(regex).insert(regex.length() - 1, delimiter)
				.toString();
	}

	public int add(String numbers) {
		int result = 0;
		if (numbers.startsWith(separateLine)) {
			int delimiterIndex = numbers.indexOf(separateLine) + 2;
			this.buildRegex(numbers.substring(delimiterIndex,
					delimiterIndex + 1));
			numbers = new StringBuilder(numbers).replace(0, delimiterIndex, "").toString();
		}

		String[] numArr = numbers.split(regex);
		for (String number : numArr) {
			if (!number.isEmpty()) {
				int n = Integer.parseInt(number);
				result = result + n;
			}
		}
		return result;
	}
}
