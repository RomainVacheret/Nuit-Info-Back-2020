package com.nuitdelinfo.app.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;

@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String lastName;

    private String pseudo;

    private String password;

    @OneToOne
    @JoinColumn(
        name="user", unique=true, nullable=false, updatable=false)
    private ConfirmationToken userToken;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Nullable
    private String description;

    @Nullable
    @ElementCollection
    @ManyToMany(targetEntity = UGroup.class, mappedBy = "subscribers", fetch = FetchType.EAGER)
    private Set<UGroup> userGroups;

    @Nullable
    @ElementCollection
    private Map<String, User> friends;

    @Nullable
    @ElementCollection
    @OneToMany(targetEntity = Comment.class, mappedBy = "user")
    private Set<Comment> comments;

    @Nullable
    @ElementCollection
    @OneToMany(targetEntity = Post.class, mappedBy = "user")
    private Set<Post> posts;

    public User(String name, String lastName, String pseudo, String email, String description, Set<UGroup> groups,
            Map<String, User> friends, String password, ConfirmationToken userToken) {
        this.name = name;
        this.lastName = lastName;
        this.pseudo = pseudo;
        this.email = email;
        this.description = description;
        this.userGroups = groups;
        this.friends = friends;
        this.password = password;
        this.userToken = userToken;
    }

    @Builder.Default
	private UserRole userRole = UserRole.USER;

	@Builder.Default
	private Boolean locked = false;

	@Builder.Default
	private Boolean enabled = false;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<UGroup> getGroups() {
        return userGroups;
    }

    public void setGroups(Set<UGroup> groups) {
        this.userGroups = groups;
    }

    public Map<String, User> getFriends() {
        return friends;
    }

    public void setFriends(Map<String, User> friends) {
        this.friends = friends;
    }

    public User() {
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [description=");
        builder.append(description);
        builder.append(", email=");
        builder.append(email);
        builder.append(", friends=");
        builder.append(friends);
        builder.append(", groups=");
        builder.append(userGroups);
        builder.append(", lastName=");
        builder.append(lastName);
        builder.append(", name=");
        builder.append(name);
        builder.append(", pseudo=");
        builder.append(pseudo);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id != other.id)
            return false;
        return true;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(Set<UGroup> userGroups) {
        this.userGroups = userGroups;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public ConfirmationToken getUserToken() {
        return userToken;
    }

    public void setUserToken(ConfirmationToken userToken) {
        this.userToken = userToken;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userRole.name());
		return Collections.singletonList(simpleGrantedAuthority);
    }

    @Override
    public String getUsername() {
        return pseudo;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
       return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
       return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
