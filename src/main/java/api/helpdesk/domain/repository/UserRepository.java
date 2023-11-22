package api.helpdesk.domain.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import api.helpdesk.domain.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    
} 
