package com.example.accountservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class LoginsToAccount {
    public static final Map<String, String> accounts = Map.of(
            "1", "1111111",
            "2", "2222222",
            "3", "3333333",
            "4", "4444444"
    );

    @PostMapping("/accounts")
    public Map<String, String> getAccounts(@RequestBody List<String> logins){
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(3));
            return logins.stream().filter(login -> accounts.get(login) != null)
                    .collect(Collectors.toMap(Function.identity(), accounts::get));
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
