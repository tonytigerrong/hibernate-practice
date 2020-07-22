package interview.hibernate.cache.model.joined;

import javax.persistence.*;

@Entity
@Table(name="employee__")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee__ {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name")
    private String name;

    public Employee__(String name) {
        this.name = name;
    }

    public Employee__() {
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
