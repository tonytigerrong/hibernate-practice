package interview.hibernate.cache.model.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="regular__employee")
@PrimaryKeyJoinColumn(name="ID")
public class Regular__Employee extends Employee__{
    @Column(name="salary")
    private float salary;
    @Column(name="bonus")
    private float bonus;

    public Regular__Employee(float salary, float bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }

    public Regular__Employee(String name, float salary, float bonus) {
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
