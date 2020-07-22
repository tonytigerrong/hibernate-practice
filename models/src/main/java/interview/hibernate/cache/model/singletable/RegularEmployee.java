package interview.hibernate.cache.model.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("regular_employee")
public class RegularEmployee extends Employee {

    @Column(name="salary")
    private float salary;
    @Column(name="bonus")
    private int bonus;

    public RegularEmployee() {
        super("");
    }

    public RegularEmployee(String name, float salary, int bonus) {
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

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
