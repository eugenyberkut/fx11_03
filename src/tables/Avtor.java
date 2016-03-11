package tables;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Yevhen on 11.03.2016.
 */
@Entity
public class Avtor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "comment")
    private String comment;

    public Avtor() {
    }

    public Avtor(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avtor avtor = (Avtor) o;
        return id == avtor.id &&
                Objects.equals(name, avtor.name) &&
                Objects.equals(comment, avtor.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, comment);
    }

    @Override
    public String toString() {
        return "Avtor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
