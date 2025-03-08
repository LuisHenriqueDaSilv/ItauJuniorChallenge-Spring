package spring.boot.itau.backend.challenge.dtos;

import java.time.OffsetDateTime;

import io.micrometer.common.lang.Nullable;
import jakarta.validation.constraints.Null;
import lombok.Getter;

@Getter
public class PostTransactionRequestDTO {
    @Nullable
    private Double valor;
    @Null
    private OffsetDateTime dataHora;
}
