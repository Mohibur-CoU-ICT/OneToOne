package com.mohibur.OneToOne.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String phoneNumber;

    @Column
    private String address;

    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;

    @Column
    private LocalDate dateOfBirth;

    @JsonIgnoreProperties("userProfile")
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userProfile")
    private User user;
}
