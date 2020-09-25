package ru.javabegin.tasklist.backendspringboot.entity;

import javax.persistence.*;
import java.sql.Timestamp;

public class Task {
    private Long id;
    private String title;
    private Integer completed;
    private Timestamp date;
    private Priority priorityByPriorityId;
    private Category categoryByCategoryId;

    @Id
    @Column(name = "id", table = "task", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", table = "task", nullable = false, length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "completed", table = "task", nullable = true)
    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    @Basic
    @Column(name = "date", table = "task", nullable = true)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != null ? !id.equals(task.id) : task.id != null) return false;
        if (title != null ? !title.equals(task.title) : task.title != null) return false;
        if (completed != null ? !completed.equals(task.completed) : task.completed != null) return false;
        if (date != null ? !date.equals(task.date) : task.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (completed != null ? completed.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "priority_id", referencedColumnName = "id", table = "task")
    public Priority getPriorityByPriorityId() {
        return priorityByPriorityId;
    }

    public void setPriorityByPriorityId(Priority priorityByPriorityId) {
        this.priorityByPriorityId = priorityByPriorityId;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", table = "task")
    public Category getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }
}
