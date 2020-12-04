package com.nuitdelinfo.app.users.service;

import java.text.MessageFormat;
import java.util.Optional;

import com.nuitdelinfo.app.model.ConfirmationToken;
import com.nuitdelinfo.app.model.UGroup;
import com.nuitdelinfo.app.model.User;
import com.nuitdelinfo.app.users.repository.UserRepository;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.nuitdelinfo.app.token.ConfirmationTokenService;



@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;
	private ConfirmationTokenService confirmationTokenService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private EmailService emailService;

	public boolean isAccountLocked(Optional<User> user) {
		return repository.findById(user.get().getId()).get().getLocked();
	}

	public boolean isEnabled(Optional<User> user) {
		return repository.findById(user.get().getId()).get().getEnabled();
    }
    
    @Override
    public void signUpUser(User user) {

        final String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
    
        user.setPassword(encryptedPassword);
    
        repository.save(user);
    
        final ConfirmationToken confirmationToken = new ConfirmationToken(user);
    
        confirmationTokenService.saveConfirmationToken(confirmationToken);
    
    }

    @Override
    public void confirmUser(ConfirmationToken confirmationToken) {

        final User user = confirmationToken.getUser();
      
        user.setEnabled(true);
      
        repository.save(user);
      
        confirmationTokenService.deleteConfirmationToken(confirmationToken.getId());
      
    }

    public void sendConfirmationMail(String userMail, String token) {

        final SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userMail);
        mailMessage.setSubject("Mail Confirmation Link!");
        mailMessage.setFrom("<MAIL>");
        mailMessage.setText(
                "Thank you for registering. Please click on the below link to activate your account." + "http://localhost:8080/sign-up/confirm?token="
                        + token);
    
        emailService.sendEmail(mailMessage);
    }

    @Override
		public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

			final Optional<User> optionalUser = repository.findByEmail(email);

			if (optionalUser.isPresent()) {
				return optionalUser.get();
			}
			else {
				throw new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found.", email));
			}
		}

    
    @Override
    public void connection(User user) {
        return;
    }

    @Override
    public void deconnection(User user) {
        return;
    }

    @Override
    public void addFriend(Optional<User> user, Optional<User> friend) {
        if(user.isPresent() && friend.isPresent())
            user.get().getFriends().put(friend.get().getName(), friend.get());
    }

    @Override
    public void deleteFriend(Optional<User> user,String friendName) {
        if(user.isPresent())
            user.get().getFriends().remove(friendName);

    }

    @Override
    public void modifyName(Optional<User> user,String name) {
        if( user.isPresent())
            user.get().setName(name);
        
    }

    @Override
    public void modifyLastName(Optional<User> user,String lastName) {
        if( user.isPresent() ){
            user.get().setLastName(lastName);
        }
    }

    @Override
    public void modifyPseudo(Optional<User> user,String pseudo) {
        if( user.isPresent() ){
            user.get().setPseudo(pseudo);
        }
    }

    @Override
    public void modifyEmail(Optional<User> user,String email) {
        if( user.isPresent() ){
            user.get().setEmail(email);
        }
    }

    @Override
    public void subscribe(Optional<User> user,Optional<UGroup> group) {
        user.map(u -> u.getGroups().add(group.get()));

    }
    
    @Override
    public void unsubscribe(Optional<User> user,Long idg) {
        if(user.isPresent()){
            user.get().getGroups().forEach(g -> {
                if(g.getId() == idg)
                    user.get().getGroups().remove(g);
            });
        }
    }

	@Override
	public Optional<User> getByID(Long id) {
		return repository.findById(id);
	}
}