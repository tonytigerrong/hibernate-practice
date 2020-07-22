package interview.hibernate.cache.controller;

import interview.hibernate.cache.model.concrete.Contract_Employee;
import interview.hibernate.cache.model.concrete.Employee_;
import interview.hibernate.cache.model.concrete.Regular_Employee;
import interview.hibernate.cache.model.joined.Contract__Employee;
import interview.hibernate.cache.model.joined.Employee__;
import interview.hibernate.cache.model.joined.Regular__Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
@RequestMapping("/v1/inheritancestrategy")
public class EmployeeController {

    @Autowired
    EntityManager entityManager;

    @GetMapping("/singletable")
    public String singleTable() {
        interview.hibernate.cache.model.singletable.Employee e1 = new interview.hibernate.cache.model.singletable.Employee("David");
        interview.hibernate.cache.model.singletable.RegularEmployee e2 = new interview.hibernate.cache.model.singletable.RegularEmployee("Smith", 70000, 10000);
        interview.hibernate.cache.model.singletable.ContractEmployee e3 = new interview.hibernate.cache.model.singletable.ContractEmployee("Philip", 50, 1);

        Session session = entityManager.unwrap(Session.class);
        Transaction tx = session.beginTransaction();
        session.persist(e1);
        session.persist(e2);
        session.persist(e3);
        tx.commit();

        return "single.table_create_persistent_OK";
    }

    @GetMapping("/concrete")
    public String concreteTable() {
        Employee_ e1 = new Employee_("David");
        Regular_Employee e2 = new Regular_Employee("Smith",80000,10000);
        Contract_Employee e3 = new Contract_Employee("Philip", 50,1);
        Session session = entityManager.unwrap(Session.class);
        Transaction tx = session.beginTransaction();
        session.persist(e1);
        session.persist(e2);
        session.persist(e3);
        tx.commit();

        return "concrete.table_create_persistent_OK";
    }

    @GetMapping("/joined")
    public String joinedTable(){
        Employee__ e1 = new Employee__("David");
        Regular__Employee e2 = new Regular__Employee("Smith",90000,8000);
        Contract__Employee e3 = new Contract__Employee("Philip",40,1);
        Session session = entityManager.unwrap(Session.class);
        Transaction tx = session.beginTransaction();
        session.persist(e1);
        session.persist(e2);
        session.persist(e3);
        tx.commit();

        return "joined.table_create_persistent_OK";
    }

}
