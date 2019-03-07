
package com.leysoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;

import com.leysoft.service.inter.CustomMessageSink;

@EnableDiscoveryClient
@SpringBootApplication
@EnableBinding(
        value = {
            Processor.class, CustomMessageSink.class
        })
public class ScMicroserviceTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScMicroserviceTwoApplication.class, args);
    }
}
