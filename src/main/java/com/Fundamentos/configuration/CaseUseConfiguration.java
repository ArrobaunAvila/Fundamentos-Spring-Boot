package com.Fundamentos.configuration;

import com.Fundamentos.caseuse.GetUser;
import com.Fundamentos.caseuse.GetUserImplement;
import com.Fundamentos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

     @Bean
     GetUser getUser(UserService userService){
         return new GetUserImplement(userService);
     }



}
