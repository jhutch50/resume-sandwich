package com.jhutch50.resumesandwichapplication.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.jhutch50.resumesandwichapplication.repository")
@EnableTransactionManagement
public class DatabaseConfig {

}
