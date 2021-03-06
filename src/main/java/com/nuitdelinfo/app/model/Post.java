package com.nuitdelinfo.app.model;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String name;
    private String description;
    private String content;

    @ManyToOne(targetEntity=UGroup.class)
    @JoinColumn(name="POST_ID", nullable=false, updatable=false)
    private UGroup group;

    @ManyToOne(targetEntity=User.class)
    @JoinColumn(name="USER_ID", nullable=false, updatable=false)
    private User user;

    @ElementCollection
    @OneToMany(targetEntity = Comment.class, mappedBy ="post", fetch = FetchType.EAGER)
    private Set<Comment> comments;

    public Post(String name, String description, String content, UGroup group, Set<Comment> comments) {
        this.name = name;
        this.description = description;
        this.content = content;
        this.group = group;
        this.comments = comments;
    }

    public Post() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }

    public UGroup getGroup() {
        return group;
    }

    public void setGroup(UGroup group) {
        this.group = group;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Post [comments=");
        builder.append(comments);
        builder.append(", content=");
        builder.append(content);
        builder.append(", description=");
        builder.append(description);
        builder.append(", group=");
        builder.append(group);
        builder.append(", name=");
        builder.append(name);
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
        Post other = (Post) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
