package com.Fundamentos.entity;
import lombok.*;
import javax.persistence.*;


@Entity
@Table(name = "post")
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post", nullable = false, unique = true)
    private Long id;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @ManyToOne
    private User user;




}
