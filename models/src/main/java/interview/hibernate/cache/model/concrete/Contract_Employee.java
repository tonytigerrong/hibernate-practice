package interview.hibernate.cache.model.concrete;

import javax.persistence.*;

@Entity
@Table(name="contract_employee")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AttributeOverrides({
        @AttributeOverride(name="id", column=@Column(name="id")),
        @AttributeOverride(name="name",column=@Column(name="name"))
})
public class Contract_Employee extends Employee_ {
    @Column(name="pay_per_hour")
    private float pay_per_hour;
    @Column(name="contract_duration")
    private float contract_duration;

    public Contract_Employee(String name, float pay_per_hour, float contract_duration) {
        super(name);
        this.pay_per_hour = pay_per_hour;
        this.contract_duration = contract_duration;
    }

    public float getPay_per_hour() {
        return pay_per_hour;
    }

    public void setPay_per_hour(float pay_per_hour) {
        this.pay_per_hour = pay_per_hour;
    }

    public float getContract_duration() {
        return contract_duration;
    }

    public void setContract_duration(float contract_duration) {
        this.contract_duration = contract_duration;
    }
}

