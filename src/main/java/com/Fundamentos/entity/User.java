package com.Fundamentos.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_post", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "email", length = 50, unique = true)
    private String email;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name= "birthday", nullable = true)
    private LocalDate birthday;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch =  FetchType.EAGER)
    @JsonManagedReference
    private List<Post> post = new ArrayList<>();


    public User(Long id) {
        this.id = id;
    }


}
