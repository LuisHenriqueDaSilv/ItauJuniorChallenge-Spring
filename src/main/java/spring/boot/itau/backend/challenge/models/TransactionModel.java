package spring.boot.itau.backend.challenge.models;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TransactionModel {
    double valor;
    OffsetDateTime dataHora;
}
