package com.nuitdelinfo.app.model;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    private @Getter long id;

    @Setter
    private @Getter String name;

    @Setter
    private @Getter Map<String, User> subscribers;

    @ManyToOne(targetEntity = User.class)
    @Setter
    private @Getter User user;

    public Group(String name, Map<String, User> subscribers) {
        this.name = name;
        this.subscribers = subscribers;
    }
}
