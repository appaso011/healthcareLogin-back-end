package com.authenticatedBackend.token;




import org.hibernate.annotations.ManyToAny;

import com.authenticatedBackend.models.ApplicationUser;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Token {
    @Id
    @GeneratedValue
    private Integer id;

    private String token;

    @Enumerated(EnumType.STRING)
    private TokenType TokenType;

    private boolean expired;

    private boolean revoked;

    @ManyToAny
    @JoinColumn(name = "user_id")
    private ApplicationUser user;
}
