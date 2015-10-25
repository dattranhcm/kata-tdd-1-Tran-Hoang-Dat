package exercise.kata.src;

public class StringCalculator {
	private static StringCalculator instance = new StringCalculator();

	private StringCalculator() {
	}

	public static StringCalculator getInstance() {
		return instance;
	}

	public int add(String numbers) {
		int result = 0;
		try {
			String[] numArr = numbers.split(",");
			if (numArr.length > 2) {
				throw new RuntimeException("More than 2 numbers...");
			} else {
				for (String number : numArr) {
					if (!number.isEmpty()) {
						int n = Integer.parseInt(number);
						result = result + n;
					}
				}
			}
			
		} catch (NumberFormatException ex) {
			throw new RuntimeException(ex);
		}
		return result;
	}
}
