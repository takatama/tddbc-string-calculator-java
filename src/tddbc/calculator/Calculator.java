package tddbc.calculator;

/**
 * Created by takatama on 2014/05/19.
 */
public class Calculator {
    private boolean isDelimiterDefined(String numbers) {
        return numbers.startsWith("//");
    }

    Delimiter definedDelimiter(String numbers) {
        return new Delimiter(numbers.split("\n")[0].substring(2));
    }

    private String extractNumbers(String numbers) {
        if (isDelimiterDefined(numbers)) {
            return numbers.split("\n")[1];
        }
        return numbers;
    }

    private int handleMultipleNumbers(String numbers, Delimiter delimiter) {
        String[] integers = delimiter.split(numbers);

        int total = 0;
        for (String i: integers) {
            total += handleSingleNumber(i);
        }
        return total;
    }

    private int handleSingleNumber(String numbers) {
        int result = Integer.parseInt(numbers);
        if (result < 0) throw new NegativesNotAllowedException(String.valueOf(result));
        return Integer.parseInt(numbers);
    }

    private boolean isBlank(String numbers) {
        return numbers == "";
    }

    private int handleBlank() {
        return 0;
    }

    private Delimiter extractDelimiter(String numbers) {
        if (isDelimiterDefined(numbers)) {
            return definedDelimiter(numbers);
        }
        return new Delimiter(",|\n");
    }

    public int add(String numbers) throws NegativesNotAllowedException {
        Delimiter delimiter = extractDelimiter(numbers);
        numbers = extractNumbers(numbers);
        if (delimiter.isMultipleNumbers(numbers)) {
            return handleMultipleNumbers(numbers, delimiter);
        }
        if (isBlank(numbers)) {
            return handleBlank();
        }
        return handleSingleNumber(numbers);
    }

}
