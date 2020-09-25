package ru.javabegin.tasklist.backendspringboot.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

public class Priority {
    private Long id;
    private String title;
    private String color;
    private Collection<Task> tasksById;

    @Id
    @Column(name = "id", table = "priority", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", table = "priority", nullable = false, length = 45)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "color", table = "priority", nullable = false, length = 45)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Priority priority = (Priority) o;

        if (id != null ? !id.equals(priority.id) : priority.id != null) return false;
        if (title != null ? !title.equals(priority.title) : priority.title != null) return false;
        if (color != null ? !color.equals(priority.color) : priority.color != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "priorityByPriorityId")
    public Collection<Task> getTasksById() {
        return tasksById;
    }

    public void setTasksById(Collection<Task> tasksById) {
        this.tasksById = tasksById;
    }
}
