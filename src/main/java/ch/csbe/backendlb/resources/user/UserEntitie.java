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

}
