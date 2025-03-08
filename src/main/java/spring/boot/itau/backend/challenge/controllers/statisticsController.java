package spring.boot.itau.backend.challenge.controllers;

import java.util.DoubleSummaryStatistics;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import spring.boot.itau.backend.challenge.dtos.StatisticsResponseDTO;
import spring.boot.itau.backend.challenge.services.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/estatistica")
@RequiredArgsConstructor
public class statisticsController {
    private final TransactionService transactionService;

    @GetMapping()
    public ResponseEntity<StatisticsResponseDTO> getTransactions() {
        DoubleSummaryStatistics stats = transactionService.getStatistics();
        return ResponseEntity.ok(new StatisticsResponseDTO(stats));
    }
    
}
