package com.Fundamentos.pojo;


import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "user")
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserPojo {

    private String password;
    private String email;
    private String age;


}
