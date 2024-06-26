package api.helpdesk.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.helpdesk.domain.models.User;
import api.helpdesk.services.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@CrossOrigin
@RequestMapping("/auth")
@RestController
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> validateLogin(@RequestParam String username, @RequestParam String password) {
    User userLogin = userService.findByUsername(username);
    if (userLogin == null) {
        return ResponseEntity.notFound().build();
    } else if (password.equals(userLogin.getPassword())) {
        userService.login(userLogin);
        return ResponseEntity.accepted().build();
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}

    

}
