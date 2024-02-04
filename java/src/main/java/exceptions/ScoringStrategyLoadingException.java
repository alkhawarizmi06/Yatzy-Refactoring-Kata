package exceptions;

public class ScoringStrategyLoadingException extends RuntimeException {
    public ScoringStrategyLoadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
