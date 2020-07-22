package interview.hibernate.cache.model.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("contract_employee")
public class ContractEmployee extends Employee {

    @Column(name="pay_per_hour")
    private float pay_per_hour;
    @Column(name="contract_duration")
    private float contract_duration;

    public ContractEmployee(String name,float pay_per_hour, float contract_duration) {
        super(name);
        this.contract_duration = contract_duration;
        this.pay_per_hour = pay_per_hour;
    }

    public ContractEmployee(float pay_per_hour, float contract_duration) {
        super("");
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
