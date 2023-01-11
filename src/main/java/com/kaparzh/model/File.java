package com.kaparzh.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "file")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "filepath")
    private String filepath;

    @OneToOne(mappedBy = "file")
    private Event event;

    public File(Integer id, String name, String filepath) {
        this.id = id;
        this.name = name;
        this.filepath = filepath;
    }

    public File(String name, String filePath) {
        this.name = name;
        this.filepath = filePath;
    }

    public File() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        File file = (File) o;

        if (!Objects.equals(id, file.id)) return false;
        if (!Objects.equals(name, file.name)) return false;
        return Objects.equals(filepath, file.filepath);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (filepath != null ? filepath.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "File{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", filePath='" + filepath + '\'' +
               '}';
    }
}
