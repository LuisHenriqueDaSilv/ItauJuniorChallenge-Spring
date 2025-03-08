package spring.boot.itau.backend.challenge.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/transacao")
public class transactionController {
    
    @PostMapping()
    public ResponseEntity<String> postTransaction() {
        return ResponseEntity.ok().body("Hello");
    }
    
}
