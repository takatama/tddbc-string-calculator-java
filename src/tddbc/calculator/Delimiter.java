package tddbc.calculator;

/**
 * Created by takatama on 2014/05/19.
 */
public class Delimiter {
    private final String comma = ",";
    private final String newLine = "\n";
    private final String delimiter;
    private final String regexp;

    public Delimiter(String delimiter) {
        this.delimiter = delimiter;
        regexp = comma + "|" + newLine + "|" + delimiter;
    }

    public String[] split(String numbers) {
        return numbers.split(regexp);
    }

    public boolean isMultipleNumbers(String numbers) {
        return numbers.contains(comma) || numbers.contains(newLine) || numbers.contains(delimiter);
    }
}
