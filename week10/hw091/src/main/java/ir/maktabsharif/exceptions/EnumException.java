package ir.maktabsharif.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;


@Getter
@RequiredArgsConstructor
public class EnumException extends RuntimeException {
    final private LocalDate date = LocalDate.now();
    final private String message;
}

