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

    public boolean validate(){
        return (
            this.valor == null || 
            this.dataHora == null || 
            this.valor < 0 || 
            this.dataHora.isAfter(OffsetDateTime.now()) 
        );
    }
}
