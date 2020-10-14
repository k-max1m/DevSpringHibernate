package packages.models;

import org.springframework.context.annotation.Bean;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    private String sureName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts;

    public User() {
    }

    public User(String name, String sureName) {
        this.name = name;
        this.sureName = sureName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || o.getClass() != getClass() ) {
            return false;
        }
        User user = (User) o;
        return userId == user.userId &&
                name.equals(user.name) &&
                sureName.equals(user.sureName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, sureName);
    }

    @Override
    public String toString() {
        return name + sureName;
    }
}
