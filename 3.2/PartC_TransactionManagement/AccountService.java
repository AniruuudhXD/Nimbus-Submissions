package com.example.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class AccountService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void transfer(int fromId, int toId, double amount) {
        Account from = em.find(Account.class, fromId);
        Account to = em.find(Account.class, toId);

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        em.merge(from);
        em.merge(to);

        System.out.println("Transfer successful!");
    }
}