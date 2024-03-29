package api.helpdesk.services;

import java.util.List;
import java.util.Optional;

import api.helpdesk.domain.models.Departament;
import api.helpdesk.domain.models.User;

public interface UserService {

    Optional<User> findById (Long id);
    
    void saveUser(String name, String username, String password, Departament departmentName);

    List<User> findAll();
    
    User findByName(String name);

    List<User> findByNameContainingIgnoreCase(String name);

    void delete(Long id);

    User update ( User userDetails);

    User findByUsername(String Login);

    User login(User user);
    

}