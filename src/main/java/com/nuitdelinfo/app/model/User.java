package com.nuitdelinfo.app.model;

import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.lang.Nullable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    private @Getter long id;

    @Setter
    private @Getter String name;

    @Setter
    private @Getter String lastName;

    @Setter
    private @Getter String pseudo;

    @Setter
    private @Getter String email;
    
    @Setter
    @Nullable
    private @Getter String description;
    
    @OneToMany(targetEntity=Group.class, mappedBy="user", fetch = FetchType.EAGER)
    @Setter
    @Nullable
    private @Getter Set<Group> groups;
    
    @Setter
    private @Getter Map<String, User> friends;

    public User(String name, String lastName, String pseudo, String email, String description, Set<Group> groups,
            Map<String, User> friends) {
        this.name = name;
        this.lastName = lastName;
        this.pseudo = pseudo;
        this.email = email;
        this.description = description;
        this.groups = groups;
        this.friends = friends;
    }
}
