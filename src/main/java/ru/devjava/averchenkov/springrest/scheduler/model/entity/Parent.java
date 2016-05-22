package ru.devjava.averchenkov.springrest.scheduler.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

/**
 * Сущность родителя.
 *
 * @author Averchenkov R.A.
 */
@Entity
@Table(name = "parent", schema = "scheduler")
public class Parent {
    private int id;
    private String login;
    private String password;

    private String firstName;
    private String lastName;

    private transient Collection<Child> childs;

    @Id
    @Column(name = "pr_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(nullable = false, unique = true, length = 50)
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(nullable = false, length = 50)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(nullable = false, length = 150)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(nullable = false, length = 150)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    public Collection<Child> getChilds() {
        return childs;
    }
    public void setChilds(Collection<Child> childs) {
        this.childs = childs;
    }

    public Parent() {}
    public Parent(String login, String password, String firstName, String lastName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parent)) return false;

        Parent parent = (Parent) o;

        if (id != parent.id) return false;
        if (childs != null ? !childs.equals(parent.childs) : parent.childs != null) return false;
        if (firstName != null ? !firstName.equals(parent.firstName) : parent.firstName != null) return false;
        if (lastName != null ? !lastName.equals(parent.lastName) : parent.lastName != null) return false;
        if (login != null ? !login.equals(parent.login) : parent.login != null) return false;
        if (password != null ? !password.equals(parent.password) : parent.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (childs != null ? childs.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                ", id=" + id +
                '}';
    }
}
