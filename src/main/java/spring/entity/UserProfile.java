package spring.entity;

import java.util.Collection;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class UserProfile extends APersistence {

    private String name;
    private String email;
    private String password;

    @Embedded
    private Endereco endereco;

    public UserProfile() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordHash() {
        // TODO Implement Password hash
        return null;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Implement authorities
        return null;
    }
    
    

}
