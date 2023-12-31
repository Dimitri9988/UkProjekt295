package ch.csbe.backendlb.resource.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// UserEntitie repräsentirt ein Benutzer Entrag in der Datenbank
@Entity
public class UserEntitie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = ("int"),nullable = false)
    private Long id;


    @Column(columnDefinition = "varchar(255)",nullable = false)
    private String firstName;

    @Column(columnDefinition = "varchar(255)",nullable = false)
    private  String lastName;

    @Column(columnDefinition = "varchar(255)",nullable = false)
    private String username;

    @Column(columnDefinition = "varchar(255)",nullable = false)
    private String email;

    @Column(columnDefinition = "varchar(255)",nullable = false)
    private String password;

    @Column(columnDefinition = "date",nullable = false)
    private Date birthday;

    @Column(columnDefinition = "boolean",nullable = false)
    private Boolean authenticated;

    //Getter und setter für die Felder von UserEntitit
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }

    // wen der Nutzer die Rolle Admin hat (authenticated) wird ihm die rolle "ROLE_ADMIN" hinzugefügt
    public List<String> getRoles() {
        List<String> Roles = new ArrayList<>();
        if (this.authenticated.equals(true)){
            Roles.add("ROLE_ADMIN");
        }

        return Roles;
    }

}
