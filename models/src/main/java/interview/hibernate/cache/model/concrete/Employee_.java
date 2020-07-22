package interview.hibernate.cache.model.concrete;

import javax.persistence.*;

@Entity
@Table(name="employee_concrete")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employee_ {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name")
    private String name;

    public Employee_(String name) {
        this.name = name;
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
