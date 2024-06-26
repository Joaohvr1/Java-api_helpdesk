package api.helpdesk.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = true)
    private Long id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "login")
    private String username;

    @Column(name = "senha")
    private String password;

    @Column(name = "roles")
    private String roles;

    @Column(name = "contato")
    private String contato;


    public String getRoles() {
        return roles;
    }


    public void setRoles(String roles) {
        this.roles = roles;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departamento_id")
    private Departament departamento;

    


    

    public User() {
    }


    public User(String name, String username, String password,  Departament departament) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.departamento = departament;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Departament getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departament departamento) {
        this.departamento = departamento;
    }

    
}
