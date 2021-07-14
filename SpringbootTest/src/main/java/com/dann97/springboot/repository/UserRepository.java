package com.dann97.springboot.repository;

import com.dann97.springboot.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email=?1")
    Optional<User> findMyUserByEmail(String email);


    List<User> findByNameContaining(String name);

    List<User> findByNameLike(String name);

    List<User> findAll();
}
