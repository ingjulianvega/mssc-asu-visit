package ingjulianvega.ximic.msscasuvisit.exception;

import lombok.Getter;

@Getter
public class VisitException extends RuntimeException {

    private final String code;

    public VisitException(final String code, final String message) {
        super(message);
        this.code = code;
    }
}

