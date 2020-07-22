package interview.hibernate.cache.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="immute_entity")
@Immutable
public class ImmuteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public ImmuteEntity() {
    }

    public ImmuteEntity(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ImmuteEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
