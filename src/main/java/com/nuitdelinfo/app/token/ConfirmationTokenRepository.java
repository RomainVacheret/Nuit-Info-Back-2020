package com.nuitdelinfo.app.token;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.nuitdelinfo.app.model.ConfirmationToken;

@Repository
interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, Long> {
    Optional<ConfirmationToken> findByconfirmationToken(String token);
}