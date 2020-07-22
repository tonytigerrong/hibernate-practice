package interview.hibernate.cache.model.joined;

import javax.persistence.*;

@Entity
@Table(name="contract__employee")
@PrimaryKeyJoinColumn(name="ID")
public class Contract__Employee extends Employee__ {

    @Column(name="pay_per_hour")
    private float pay_per_hour;
    @Column(name="contract_duration")
    private float contract_duration;

    public Contract__Employee(String name, float pay_per_hour, float contract_duration) {
        super(name);
        this.pay_per_hour = pay_per_hour;
        this.contract_duration = contract_duration;
    }

    public Contract__Employee(float pay_per_hour, float contract_duration) {
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
