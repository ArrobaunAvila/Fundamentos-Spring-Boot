package com.Fundamentos.configuration;


import com.Fundamentos.bean.BeanPropertyConfiguration;
import com.Fundamentos.bean.BeanPropertyConfigurationImplement;
import com.Fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.sql.DataSource;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@PropertySources({
        @PropertySource("classpath:connection.properties")
})
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {

    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;


    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${driver}")
    private String driver;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;


    @Bean
    public BeanPropertyConfiguration propertyUsuario() {
     return new BeanPropertyConfigurationImplement(name , apellido);
    }

    @Bean
    public DataSource dataSource(){
      DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
      dataSourceBuilder.driverClassName(driver);
      dataSourceBuilder.url(jdbcUrl);
      dataSourceBuilder.username(username);
      dataSourceBuilder.password(password);
      return dataSourceBuilder.build();
   }
}
