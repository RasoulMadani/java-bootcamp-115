package ir.maktabsharif.service.product.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;


@Getter
@RequiredArgsConstructor
public class ProductSqlException extends RuntimeException{
    final private LocalDate date = LocalDate.now();
    final private String message;
}
