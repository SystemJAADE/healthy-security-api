package com.systemjaade.healthy.repository;


import com.systemjaade.healthy.entity.HealthyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<HealthyUser, Integer> {
    HealthyUser findByUsername(String username);
}
