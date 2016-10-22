package io.ctl.globalhack;

import io.ctl.globalhack.config.GlobalHackConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(GlobalHackConfig.class)
public class GlobalHack {

    public static void main(String[] args) {
        SpringApplication.run(GlobalHack.class, args);
    }

}
