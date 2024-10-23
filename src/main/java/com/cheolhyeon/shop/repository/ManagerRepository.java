package com.cheolhyeon.shop.repository;

import com.cheolhyeon.shop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
