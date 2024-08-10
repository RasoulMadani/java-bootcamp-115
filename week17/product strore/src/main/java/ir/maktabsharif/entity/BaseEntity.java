package ir.maktabsharif.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseEntity<ID> {
    private ID id;
}
