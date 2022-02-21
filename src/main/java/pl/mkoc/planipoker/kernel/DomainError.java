package pl.mkoc.planipoker.kernel;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DomainError extends RuntimeException {
    private final String code;
    private final String message;
}
