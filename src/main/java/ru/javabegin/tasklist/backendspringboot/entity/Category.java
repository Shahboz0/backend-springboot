package ru.javabegin.tasklist.backendspringboot.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

public class Category {
    private Long id;
    private String title;
    private Long completedCount;
    private Long uncompletedCount;
    private Collection<Task> tasksById;

    @Id
    @Column(name = "id", table = "category", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", table = "category", nullable = false, length = 45)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "completed_count", table = "category", nullable = true)
    public Long getCompletedCount() {
        return completedCount;
    }

    public void setCompletedCount(Long completedCount) {
        this.completedCount = completedCount;
    }

    @Basic
    @Column(name = "uncompleted_count", table = "category", nullable = true)
    public Long getUncompletedCount() {
        return uncompletedCount;
    }

    public void setUncompletedCount(Long uncompletedCount) {
        this.uncompletedCount = uncompletedCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != null ? !id.equals(category.id) : category.id != null) return false;
        if (title != null ? !title.equals(category.title) : category.title != null) return false;
        if (completedCount != null ? !completedCount.equals(category.completedCount) : category.completedCount != null)
            return false;
        if (uncompletedCount != null ? !uncompletedCount.equals(category.uncompletedCount) : category.uncompletedCount != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (completedCount != null ? completedCount.hashCode() : 0);
        result = 31 * result + (uncompletedCount != null ? uncompletedCount.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "categoryByCategoryId")
    public Collection<Task> getTasksById() {
        return tasksById;
    }

    public void setTasksById(Collection<Task> tasksById) {
        this.tasksById = tasksById;
    }
}
