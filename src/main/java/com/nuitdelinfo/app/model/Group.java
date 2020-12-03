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

@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ElementCollection
    @ManyToMany(targetEntity=User.class, mappedBy="group", fetch = FetchType.EAGER)
    private Map<String, User> subscribers;


    @ElementCollection
    @OneToMany(targetEntity = Post.class, mappedBy ="group", fetch = FetchType.EAGER)
    private Set<Post> posts;

    public Group(String name, Map<String, User> subscribers) {
        this.name = name;
        this.subscribers = subscribers;
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

    public Map<String, User> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Map<String, User> subscribers) {
        this.subscribers = subscribers;
    }

    public Group() {
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Group [name=");
        builder.append(name);
        builder.append(", subscribers=");
        builder.append(subscribers);
        builder.append(", user=");
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
        Group other = (Group) obj;
        if (id != other.id)
            return false;
        return true;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
