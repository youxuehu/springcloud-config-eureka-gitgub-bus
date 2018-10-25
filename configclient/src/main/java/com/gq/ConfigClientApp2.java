package com.gq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@SpringBootApplication
@RestController
@EnableEurekaClient
@RefreshScope
public class ConfigClientApp2 {
    public static void main(String[] args) {
        int port = new Scanner(System.in).nextInt();
        new SpringApplicationBuilder(ConfigClientApp2.class).properties("server.port="+port).web(true).run(args);

    }

    @Value("${name.node}")
    String name;

    @RequestMapping(value = "/hi2")
    public String hi() {
        System.out.println(name);
        return name;
    }
}