package spring.boot.itau.backend.challenge.services;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Service;

import spring.boot.itau.backend.challenge.models.TransactionModel;

@Service
public class TransactionService {
    private final Queue<TransactionModel> transactions = new ConcurrentLinkedQueue<>();
    
    public void addTransaction(TransactionModel transaction){
        this.transactions.add(transaction);
    }

    public void clearTransactions(){
        transactions.clear();
    }

    public DoubleSummaryStatistics getStatistics(){
        OffsetDateTime now = OffsetDateTime.now(); 
        return transactions.stream()
            .filter(t -> t.getDataHora().isBefore(now.minusSeconds(60)))
            .mapToDouble(TransactionModel::getValor)
            .summaryStatistics();
    }
 
}
