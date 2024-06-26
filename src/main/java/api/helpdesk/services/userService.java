package api.helpdesk.services;

import java.util.List;
import java.util.Optional;

import api.helpdesk.domain.models.User;

public interface UserService {

    Optional<User> findById (Long id);
    
    void saveUser(User user);

    List<User> findAll();
    
    User findByName(String name);

    List<User> findByNameContainingIgnoreCase(String name);

    void delete(Long id);

    User update ( User userDetails);

    User findByUsername(String username);

    User login(User user);
    
    String getUserRoles(User user);
}