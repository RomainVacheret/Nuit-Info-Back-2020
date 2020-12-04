package com.nuitdelinfo.app.model;

import java.util.Map;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.lang.Nullable;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;

    private String name;

    private String lastName;

    private String pseudo;

    private String email;
    
    @Nullable
    private  String description;
    
    @Nullable
    @ElementCollection
    @ManyToMany(targetEntity = UGroup.class, mappedBy ="subscribers", fetch = FetchType.EAGER)
    private  Set<UGroup> userGroups;
    
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
            Map<String, User> friends) {
        this.name = name;
        this.lastName = lastName;
        this.pseudo = pseudo;
        this.email = email;
        this.description = description;
        this.userGroups = groups;
        this.friends = friends;
    }

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
    public void setComment(Comment comment){
        comments.add(comment);
    }
    public Set<Comment> getComments(){
        return this.comments;
    }
    public void setPost(Post post){
        posts.add(post);
    }
    public Set<Post> getPosts(){
        return this.posts;
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
}
