package com.codeit.ecsprcaticestarter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvController {
    @Value("${SPRING_PROFILES_ACTIVE:#{null}}")
    private String springProfileActive;
    @Value("${DB_HOST:#{null}}")
    private String dbHost;
    @Value("${DB_PASSWORD:#{null}}")
    private String dbPassword;

    @GetMapping("/env")
    public String showEnv() {
        return String.format("""
                SPRING_PROFILES_ACTIVE=%s
                DB_HOST=%s
                DB_PASSWORD=%s
                """, springProfileActive, dbHost, dbPassword
                );
    }
}
