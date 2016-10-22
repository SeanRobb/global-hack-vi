package io.ctl.globalhack;

import com.ctlts.wfaas.data.orchestrate.config.EnableOrchestrateRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableOrchestrateRepositories
public class GlobalHack {

    public static void main(String[] args) {
        SpringApplication.run(GlobalHack.class, args);
    }

}
