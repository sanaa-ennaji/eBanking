package org.sanaa.ebanking.brif9.ebanking.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PublicController {
    @GetMapping("/notices")
    public ResponseEntity<String> getNotices() {
        return ResponseEntity.ok("Notices list");
    }
    @GetMapping("/cantact")
    public ResponseEntity<String> getContacts() {
        return ResponseEntity.ok("contacts list");
    }

    @GetMapping("/cards")
    public ResponseEntity<String> getCards() {
        return ResponseEntity.ok("list of myCards");
    }

    @GetMapping("/account")
    public ResponseEntity<String> getAccounts() {
        return ResponseEntity.ok("lis of MyAccounts");
    }

    @GetMapping("/balance")
    public ResponseEntity<String> getBalances() {
        return ResponseEntity.ok("Balances list");
    }
    @GetMapping("/loans")
    public ResponseEntity<String> getLoans() {
        return ResponseEntity.ok("Loans list");
    }

}
