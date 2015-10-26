package exercise.kata.src;

public class StringCalculator {
	private static StringCalculator instance = new StringCalculator();
	
	private String regex = "[,\n]";

	private StringCalculator() {
	}

	public static StringCalculator getInstance() {
		return instance;
	}

	public int add(String numbers) {
		int result = 0;
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
