package com.example.semspringboot.web;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.semspringboot.domain.UserAccount;
import com.example.semspringboot.repository.UserAccountRepository;

@RestController
@RequestMapping("/api/users")
@Transactional(readOnly = true)
public class UserAccountController {

    private final UserAccountRepository userAccountRepository;

    public UserAccountController(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @GetMapping
    public List<UserAccount> listUsers() {
        return userAccountRepository.findAll();
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserAccount> getByUsername(@PathVariable String username) {
        return userAccountRepository.findByUsername(username)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UserAccount> createUser(@RequestBody UserAccount payload) {
        if (payload.getId() != null) {
            payload.setId(null);
        }
        UserAccount saved = userAccountRepository.save(payload);
        return ResponseEntity.created(URI.create("/api/users/" + saved.getUsername())).body(saved);
    }
}
