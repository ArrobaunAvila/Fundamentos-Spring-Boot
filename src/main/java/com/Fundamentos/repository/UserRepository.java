package com.Fundamentos.repository;

import com.Fundamentos.dto.UserDto;
import com.Fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

@Query("SELECT u FROM User u WHERE u.email=?1")
Optional<User> findByUserEmail(String email);

@Query("SELECT u FROM User u WHERE u.name like ?1%")
List<User> findAndSort(String name, Sort sort);

List<User> findByName(String name);

Optional<User> findByEmailAndName(String name, String email);

List<User> findByNameLike(String name);

List<User> findByNameOrEmail(String name, String email);

List<User> findByBirthdayBetween(LocalDate begin , LocalDate end);

List<User> findByNameLikeOrderByIdDesc(String name);

List<User> findByNameContainingOrderByIdAsc(String name);

/*
@Query("SELECT new com.Fundamentos.dto.UserDto(u.id, u.name , u.email, u.birthday)"+
            "FROM User u WHERE u.birthday = :p_fecha " +
            " AND u.email = :p_email")
Optional<UserDto> getAllByBirthdayAndEmail(@Param("p_fecha") LocalDate date, @Param("p_email") String email);

*/
}
