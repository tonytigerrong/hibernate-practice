package interview.hibernate.cache.model.concrete;

import javax.persistence.*;

@Entity
@Table(name="regular_employee")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id")),
        @AttributeOverride(name = "name", column = @Column(name = "name"))
}
)
public class Regular_Employee extends Employee_ {
    @Column(name="salary")
    private float salary;
    @Column(name="bonus")
    private float bonus;

    public Regular_Employee(String name, float salary, float bonus) {
        super(name);
        this.salary = salary;
        this.bonus = bonus;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }
}
