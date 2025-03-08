package spring.boot.itau.backend.challenge.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import spring.boot.itau.backend.challenge.dtos.PostTransactionRequestDTO;
import spring.boot.itau.backend.challenge.models.TransactionModel;
import spring.boot.itau.backend.challenge.services.TransactionService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/transacao")
public class transactionController {
    
    private final TransactionService transactionService;
    
    @PostMapping()
    public ResponseEntity<Void> postTransaction(@RequestBody PostTransactionRequestDTO body) {
        if( body.validate() ){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        transactionService.addTransaction(new TransactionModel(body.getValor(), body.getDataHora()));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping()
    public ResponseEntity<Void> clearTransactions(){
        transactionService.clearTransactions();
        return ResponseEntity.ok().build();
    }
}
