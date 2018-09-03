package com.prototype.demo.services.impl;

import com.prototype.demo.exeptions.AccountNotExistsException;
import com.prototype.demo.exeptions.TransactionNotExistsException;
import com.prototype.demo.exeptions.TransactionStatusNotExistsException;
import com.prototype.demo.exeptions.UserNotExistsException;
import com.prototype.demo.model.dao.Account;
import com.prototype.demo.model.dao.Transaction;
import com.prototype.demo.model.dao.TransactionStatus;
import com.prototype.demo.model.dao.User;
import com.prototype.demo.model.requests.TransactionRequest;
import com.prototype.demo.model.responses.TransactionResponse;
import com.prototype.demo.model.responses.TransactionsResponse;
import com.prototype.demo.repositories.AccountsRepository;
import com.prototype.demo.repositories.TransactionStatusRepository;
import com.prototype.demo.repositories.TransactionsRepository;
import com.prototype.demo.repositories.UsersRepository;
import com.prototype.demo.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service implementation for working with transaction data model.
 */
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    /**
     * Inject: UsersRepository, AccountsRepository, TransactionsRepository through constructor.
     */
    private final UsersRepository usersRepository;
    private final AccountsRepository accountsRepository;
    private final TransactionsRepository transactionsRepository;
    private final TransactionStatusRepository transactionStatusRepository;
    //private final SimpMessagingTemplate simpMessagingTemplate;

    /**
     * Method return transaction response by QR code.
     * @param qrCode
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public TransactionResponse findTransactionByQr(final String qrCode) {
        final TransactionResponse transaction = new TransactionResponse();
        transaction.setTransaction(transactionsRepository.findByTransactionQrStringEquals(qrCode).orElseThrow(TransactionNotExistsException::new));
        return transaction;
    }

    /**
     * Method return transaction response after create transaction.
     * @param transactionRequest
     * @return
     */
    @Override
    @Transactional
    public TransactionResponse createTransaction(TransactionRequest transactionRequest) {
        final Transaction transaction = new Transaction();
        final Account account = accountsRepository.findById(transactionRequest.getAccountId())
                .orElseThrow(AccountNotExistsException::new);
        final TransactionStatus transactionStatus = transactionStatusRepository.findById(transactionRequest.getTransactionStatusId())
                .orElseThrow(TransactionStatusNotExistsException::new);

        transaction.setAccount(account);
        transaction.setTransactionStatus(transactionStatus);
        transaction.setCounterPartyAccountId(transactionRequest.getCounterPartyAccountId());
        transaction.setTransactionAmount(transactionRequest.getCounterPartyAccountId());
        transaction.setTransactionCurrency(transactionRequest.getTransactionCurrency());
        transaction.setTransactionSubject(transactionRequest.getTransactionSubject());
        transaction.setTransactionDate(transactionRequest.getTransactionDate());
        transaction.setTransactionQrString(transactionRequest.getTransactionQrString());

        final TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setTransaction(transaction);
        return transactionResponse;
    }

    /**
     * Method return Transactions response by user id.
     * @param userId
     * @return
     */
    @Override
    public TransactionsResponse getUserTransactions(Long userId) {
        final TransactionsResponse transactionsResponse = new TransactionsResponse();
        final User user = usersRepository.findById(userId).orElseThrow(UserNotExistsException::new);
        final Account account = accountsRepository.findByUserEquals(user).orElseThrow(AccountNotExistsException::new);
        transactionsResponse.setTransactions(transactionsRepository.findByAccountEquals(account));
        //getTransactions(transactionsResponse, user);
        return transactionsResponse;
    }


//    @Override
//    public void getTransactions(final TransactionsResponse transactionsResponse, final User user) {
//        simpMessagingTemplate.convertAndSendToUser(
//                user.getUsername(), "/push/transactions", transactionsResponse);
//        return;
//    }
//
//    @Override
//    public void getTransactions(final TransactionResponse transactionsResponse, final User user) {
//        simpMessagingTemplate.convertAndSendToUser(
//                user.getUsername(), "/push/transaction", transactionsResponse);
//        return;
//    }
}