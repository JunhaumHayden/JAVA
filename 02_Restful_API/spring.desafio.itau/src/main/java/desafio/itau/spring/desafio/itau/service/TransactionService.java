package desafio.itau.spring.desafio.itau.service;

import desafio.itau.spring.desafio.itau.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class TransactionService {

    private static final Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();

    public static void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void clearTransactions() {
        transactions.clear();
    }

    public DoubleSummaryStatistics getStatistics() {
        OffsetDateTime now = OffsetDateTime.now();
        return transactions.stream()
                //.filter(t -> t.getDataHora().isAfter(now.minusMinutes(60)))
                .mapToDouble(Transaction::getValor)
                .summaryStatistics();
    }
}
