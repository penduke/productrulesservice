package com.ril.productrules.config;

import java.io.IOException;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@Configuration
public class DroolConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(DroolConfig.class);

    private static final String RULES_PATH = "rules/";

    //private KieServices kieServices = KieServices.Factory.get();

    @Bean
    @ConditionalOnMissingBean(KieFileSystem.class)
    private KieFileSystem kieFileSystem() throws IOException {
        KieFileSystem kieFileSystem = getKieServices().newKieFileSystem();
        for (Resource file : getRuleFiles()) {
            kieFileSystem.write(ResourceFactory.newClassPathResource(RULES_PATH + file.getFilename(), "UTF-8"));
        }
        return kieFileSystem;
    }

    private KieServices getKieServices() {
        return KieServices.Factory.get();
    }

    private Resource[] getRuleFiles() throws IOException {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        return resourcePatternResolver.getResources("classpath*:" + RULES_PATH + "**/*.*");
    }

    /*private KieFileSystem getKieFileSystem() throws IOException {
        LOGGER.info("Loading product.drl");
        KieFileSystem kieFileSystem = getKieServices().newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource("product.drl"));
        return kieFileSystem;

    }*/

    @Bean
    @ConditionalOnMissingBean(KieContainer.class)
    private KieContainer getKieContainer() throws IOException {
        LOGGER.info("Container created...");
        getKieRepository();
        //KieBuilder kb = getKieServices().newKieBuilder(getKieFileSystem());
        KieBuilder kb = getKieServices().newKieBuilder(kieFileSystem());
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();
        return getKieServices().newKieContainer(kieModule.getReleaseId());

    }

    private void getKieRepository() {
        LOGGER.info("Getting Kie Repository ...");
        final KieRepository kieRepository = getKieServices().getRepository();
        kieRepository.addKieModule(kieRepository::getDefaultReleaseId);
    }

    @Bean
    @ConditionalOnMissingBean(KieSession.class)
    public KieSession getKieSession() throws IOException {
        LOGGER.info("Crating Kie Session ...");
        return getKieContainer().newKieSession();

    }

}
