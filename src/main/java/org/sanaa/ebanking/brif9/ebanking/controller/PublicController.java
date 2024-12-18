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
        return ResponseEntity.ok("Notices");
    }
}
