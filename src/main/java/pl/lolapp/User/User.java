package pl.lolapp.User;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NotBlank
    String username;
    String summonername;
    String summonerid;
    @NotBlank
    String password;
    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate birth;
    @NotBlank
    @Email
    String email;
    boolean authentificated;

    public User(){}

    public User(String username, String summonername, String password, String email) {
        username = username;
        this.summonername = summonername;
        this.password = password;
        this.email = email;
    }

    public boolean isAuthentificated() {
        return authentificated;
    }

    public void setAuthentificated(boolean authentificated) {
        this.authentificated = authentificated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        username = username;
    }

    public String getSummonername() {
        return summonername;
    }

    public void setSummonername(String summonername) {
        this.summonername = summonername;
    }

    public String getSummonerid() {
        return summonerid;
    }

    public void setSummonerid(String summonerid) {
        this.summonerid = summonerid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
