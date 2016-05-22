package ru.devjava.averchenkov.springrest.scheduler.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

/**
 * Сущность ребенка.
 *
 * @author Averchenkov R.A.
 */
@Entity
@Table(name = "child", schema = "scheduler")
public class Child {
    private int Id;
    private String firstName;
    private String lastName;
    private double productivity;
    private double workloyalty;

    private transient Parent parent;
    private transient Collection<Task> tasks;

    @Id
    @Column(name = "ch_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
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

    @Basic
    @Column(nullable = false)
    public double getProductivity() {
        return productivity;
    }
    public void setProductivity(double productivity) {
        this.productivity = productivity;
    }

    @Basic
    @Column(nullable = false)
    public double getWorkloyalty() {
        return workloyalty;
    }
    public void setWorkloyalty(double workloyalty) {
        this.workloyalty = workloyalty;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pr_id", referencedColumnName = "pr_id", unique = false, nullable = false)
    public Parent getParent() {
        return parent;
    }
    public void setParent(Parent parent) {
        this.parent = parent;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "child", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    public Collection<Task> getTasks() {
        return tasks;
    }
    public void setTasks(Collection<Task> tasks) {
        this.tasks = tasks;
    }

    public Child() {}
    public Child(String firstName,
                 String lastName,
                 double productivity,
                 double workloyalty,
                 Parent parent) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.productivity = productivity;
        this.workloyalty = workloyalty;
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Child)) return false;

        Child child = (Child) o;

        if (Id != child.Id) return false;
        if (Double.compare(child.productivity, productivity) != 0) return false;
        if (Double.compare(child.workloyalty, workloyalty) != 0) return false;
        if (firstName != null ? !firstName.equals(child.firstName) : child.firstName != null) return false;
        if (lastName != null ? !lastName.equals(child.lastName) : child.lastName != null) return false;
        if (parent != null ? !parent.equals(child.parent) : child.parent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = Id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        temp = Double.doubleToLongBits(productivity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(workloyalty);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Child{" +
                "workloyalty=" + workloyalty +
                ", productivity=" + productivity +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", Id=" + Id +
                '}';
    }
}
