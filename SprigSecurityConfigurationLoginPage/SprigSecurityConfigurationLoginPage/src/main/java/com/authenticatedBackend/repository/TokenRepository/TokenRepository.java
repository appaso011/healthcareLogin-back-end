package com.authenticatedBackend.repository.TokenRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.authenticatedBackend.token.Token;

public interface TokenRepository extends JpaRepository<Token, Integer> {
    
    @Query("""
            Select t from Token t inner join Users u on t.user.id = u.id
            where u.id = :userId and (t.expired = false or t.revoked = false)
            """)
        List<Token> findAllValidTokensByUser(Integer userId);

        Optional<Token> findByToken(String token);
    

}
