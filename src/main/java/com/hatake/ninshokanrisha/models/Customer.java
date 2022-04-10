package com.hatake.ninshokanrisha.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
public class Customer extends DateAudit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String LastName;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
    private Set<Address> addressSet;

}
