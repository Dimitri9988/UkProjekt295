package ch.csbe.backendlb.resources.user;

import jakarta.persistence.*;

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
    private String birthday;

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

}
