package io.ctl.globalhack.config;

import com.ctlts.wfaas.data.orchestrate.config.EnableOrchestrateRepositories;
import com.ctlts.wfaas.data.orchestrate.repository.OrchestrateTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableOrchestrateRepositories("io.ctl.globalhack.repository")
public class GlobalHackConfig {

    @Bean
    public OrchestrateTemplate orchestrateTemplate() {
        OrchestrateTemplate template = new OrchestrateTemplate();
        template.setApiKey("af4dbaeb-fe98-4835-a77a-04120f7b6dea");
        template.setEndpoint("https://api.aws-east-1.orchestrate.io/v0/");
        return template;
    }

}
