package com.ftn.sbnz.fraud.service;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
    "com.ftn.sbnz.fraud.service.controllers",
    "com.ftn.sbnz.fraud.service.services"
})
@SpringBootApplication(scanBasePackages = {
    "com.ftn.sbnz.fraud.model",
    "com.ftn.sbnz.fraud.kjar"
})
public class FraudDetectionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FraudDetectionServiceApplication.class, args);
    }

    @Bean
    public KieContainer kieContainer() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieContainer(
            ks.newReleaseId("com.ftn.sbnz", "fraud-detection-kjar", "0.0.1-SNAPSHOT")
        );
        KieScanner kScanner = ks.newKieScanner(kContainer);
        kScanner.start(1000);
        return kContainer;
    }
}
