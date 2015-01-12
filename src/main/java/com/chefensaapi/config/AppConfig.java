package com.chefensaapi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@ComponentScan("com.chefensaapi")
@EnableWebMvc
public class AppConfig {

}