package com.l2t.cbook.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Table(name = "contact_details")
@Entity
@Getter
@Setter
public class ContactDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    private String mobile;
    private boolean deleted;

}
