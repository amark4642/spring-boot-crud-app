package com.firstspringproject.spring.boot.crud.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.firstspringproject.spring.boot.crud.app.entitiy.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query(value = "select * from user where status=:status", nativeQuery = true)
    public List<User> getAllActiveUsers(@Param("status") String status);

    public Optional<User> findByIdAndStatus(int id, String status);
}
