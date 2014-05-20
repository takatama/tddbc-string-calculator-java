package tddbc.calculator;

/**
 * Created by takatama on 2014/05/19.
 */
public class NegativesNotAllowedException extends RuntimeException {
    public NegativesNotAllowedException(String message) {
        super(message);
    }
}
