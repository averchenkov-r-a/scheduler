package ru.devjava.averchenkov.springrest.scheduler.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Сущность задачи.
 *
 * @author Averchenkov R.A.
 */
@Entity
@Table(name = "task", schema = "scheduler")
public class Task {
    private int id;
    private String name;
    private String description;
    private int ageRestriction;
    private String directionality;
    private String urlImg;
    private String testImg;

    private transient Child child;

    @Id
    @Column(name = "ts_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(nullable = false)
    public int getAgeRestriction() {
        return ageRestriction;
    }
    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    @Basic
    @Column(nullable = false)
    public String getDirectionality() {
        return directionality;
    }
    public void setDirectionality(String directionality) {
        this.directionality = directionality;
    }

    @Basic
    @Column
    public String getUrlImg() {
        return urlImg;
    }
    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    @Basic
    @Column
    public String getTestImg() {
        return testImg;
    }
    public void setTestImg(String testImg) {
        this.testImg = testImg;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ch_id", referencedColumnName = "ch_id", nullable = false)
    public Child getChild() {
        return child;
    }
    public void setChild(Child child) {
        this.child = child;
    }

    public Task() {}
    public Task(String name,
                String description,
                int ageRestriction,
                String directionality,
                String urlImg,
                String testImg,
                Child child) {
        this.name = name;
        this.description = description;
        this.ageRestriction = ageRestriction;
        this.directionality = directionality;
        this.urlImg = urlImg;
        this.testImg = testImg;
        this.child = child;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;

        Task task = (Task) o;

        if (ageRestriction != task.ageRestriction) return false;
        if (id != task.id) return false;
        if (child != null ? !child.equals(task.child) : task.child != null) return false;
        if (description != null ? !description.equals(task.description) : task.description != null) return false;
        if (directionality != null ? !directionality.equals(task.directionality) : task.directionality != null)
            return false;
        if (name != null ? !name.equals(task.name) : task.name != null) return false;
        if (testImg != null ? !testImg.equals(task.testImg) : task.testImg != null) return false;
        if (urlImg != null ? !urlImg.equals(task.urlImg) : task.urlImg != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + ageRestriction;
        result = 31 * result + (directionality != null ? directionality.hashCode() : 0);
        result = 31 * result + (urlImg != null ? urlImg.hashCode() : 0);
        result = 31 * result + (testImg != null ? testImg.hashCode() : 0);
        result = 31 * result + (child != null ? child.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "testImg='" + testImg + '\'' +
                ", urlImg='" + urlImg + '\'' +
                ", directionality='" + directionality + '\'' +
                ", ageRestriction=" + ageRestriction +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
