package com.nuitdelinfo.app.token;

import java.util.Optional;

import com.nuitdelinfo.app.model.ConfirmationToken;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationTokenService {

	private final ConfirmationTokenRepository confirmationTokenRepository;

	public void saveConfirmationToken(ConfirmationToken confirmationToken) {

		confirmationTokenRepository.save(confirmationToken);
    }
    
    public void deleteConfirmationToken(Long id){

        confirmationTokenRepository.deleteById(id);
    }

    public ConfirmationTokenService(ConfirmationTokenRepository confirmationTokenRepository) {
        this.confirmationTokenRepository = confirmationTokenRepository;
    }

	public Optional<ConfirmationToken> findConfirmationTokenByToken(String token) {
		return confirmationTokenRepository.findByconfirmationToken(token);
	}
}