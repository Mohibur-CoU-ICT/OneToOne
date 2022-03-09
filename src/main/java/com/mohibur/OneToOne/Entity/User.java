package com.mohibur.OneToOne.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @JsonIgnoreProperties("user")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "up_id", referencedColumnName = "id")
    private UserProfile userProfile;
}
