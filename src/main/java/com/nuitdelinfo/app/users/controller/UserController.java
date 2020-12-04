package com.nuitdelinfo.app.users.controller;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.nuitdelinfo.app.model.Comment;
import com.nuitdelinfo.app.model.Post;
import com.nuitdelinfo.app.model.UGroup;
import com.nuitdelinfo.app.model.ConfirmationToken;
import com.nuitdelinfo.app.model.User;
import com.nuitdelinfo.app.token.ConfirmationTokenService;
import com.nuitdelinfo.app.users.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.core.Ordered;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    
    
    @Autowired
    private UserService userService;

    @Autowired
    private ConfirmationTokenService confirmationTokenService;
    //private GroupService groupService;

    // @GetMapping("/sign-in")
	// String signIn() {

	// 	return "sign-in";
    // }
    
    // @GetMapping("/sign-up")
	// String signUp() {

	// 	return "sign-up";
    // }
    
    @PostMapping("/sign-up")
	public String signUp(Optional<User> user) {
        if(user.isPresent()){
            userService.signUpUser(user.get());
        }

		return "redirect:/sign-in";
    }
    
    @GetMapping("/confirm")
	public String confirmMail(@RequestParam("token") String token) {

		Optional<ConfirmationToken> optionalConfirmationToken = confirmationTokenService.findConfirmationTokenByToken(token);

		optionalConfirmationToken.ifPresent(userService::confirmUser);

		return "/sign-in";
	}

    @PutMapping(path = "/user/{id}/name")
    public String modifyName(@RequestParam Long id, String name){
        Optional<User> user = userService.getByID(id);
        userService.modifyName(user, name);
        if(user.isPresent())
            return user.get().getName();
        return "";
    }

    @PutMapping(path = "/user/{id}/lastname")
    public String modifyLastName(@RequestParam Long id , String lastName){
        Optional<User> user = userService.getByID(id);
        userService.modifyLastName(user, lastName);
        if(user.isPresent())
            return user.get().getLastName();
        return "";
    }

    @PutMapping(path = "/user/{id}/pseudo")
    public String modifyPseudo(@RequestParam Long id, String pseudo){
        Optional<User> user = userService.getByID(id);
        userService.modifyPseudo(user, pseudo);
        if(user.isPresent())
            return user.get().getUsername();
        return "";
    }
    @PutMapping(path = "/user/{id}/email")
    public String modifyEmail(@RequestParam Long id, String email){
        Optional<User> user = userService.getByID(id);
        userService.modifyEmail(user, email);
        if(user.isPresent())
            return user.get().getEmail();
        return "";
    }

    @PostMapping(path = "/user/{id}/friend/{idf}")
    public void addFriend(@RequestParam Long id, @RequestParam Long idf){
        Optional<User> user = userService.getByID(id);
        Optional<User> friend = userService.getByID(idf);
        if( user.isPresent() && friend.isPresent() )
            userService.addFriend(user, friend);
    }

    @DeleteMapping(path = "/user/{id}/friend/{idf}")
    public void deleteFriend(@RequestParam Long id, @RequestParam Long idf){
        Optional<User> user = userService.getByID(id);
        Optional<User> friend = userService.getByID(idf);

        if( user.isPresent() && friend.isPresent() )
            userService.deleteFriend(user, friend.get().getName());
    }

    /* @PostMapping(path ="/user/{id}/group/{id}")
    public void addGroup(@RequestParam Long id,@RequestParam Long idg) {
        Optional<User> user = userService.getByID(id);
        Optional<UGroup> group = groupService.getByID(idg);
        userService.subscribe(user, group);
    } */

    @DeleteMapping(path ="/user/{id}/group/{idg}")
    public void deleteGroup(@RequestParam Long id,@RequestParam Long idg) {
        Optional<User> user = userService.getByID(id);
        userService.unsubscribe(user, idg);
    }

    @GetMapping("/user/{id}/name")
    public String displayName(@RequestParam Long id){
        Optional<User> user = userService.getByID(id);
        return userService.displayName(user);
    }

    @GetMapping("/user/{id}/lastname")
    public String displayLastName(@RequestParam Long id){
        Optional<User> user = userService.getByID(id);
        return userService.displayLastName(user);
    }

    @GetMapping("/user/{id}/pseudo")
    public String displayPseudo(@RequestParam Long id){
        Optional<User> user = userService.getByID(id);
        return userService.displayPseudo(user);
    }

    @GetMapping("/user/{id}/email")
    public String displayEmail(@RequestParam Long id){
        Optional<User> user = userService.getByID(id);
        return userService.displayEmail(user);
    }
    @GetMapping("/user/{id}/friends")
    public Map<String, User> displayFriends(@RequestParam Long id){
        Optional<User> user = userService.getByID(id);
        return userService.displayFriends(user);
    }
    @GetMapping("/user/{id}/groups")
    public Set<UGroup> displayGroups(@RequestParam Long id){
        Optional<User> user = userService.getByID(id);
        return userService.displayGroups(user);
    }

    @GetMapping("/user/{id}/comments")
    public Set<Comment> displayComments(@RequestParam Long id){
        Optional<User> user = userService.getByID(id);
        return userService.displayComments(user);
    }

    @GetMapping("/user/{id}/posts")
    public Set<Post> displayPost(@RequestParam Long id){
        Optional<User> user = userService.getByID(id);
        return userService.displayPosts(user);
    }

    @GetMapping("/user/registration")
    public String showregistrationForm(WebRequest request, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }
}
