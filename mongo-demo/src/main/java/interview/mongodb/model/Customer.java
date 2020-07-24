package interview.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Mongo DB command:
 * 1. in command line
 * use admin;
 * db.createUser({
 *       user: "tonyrong",
 *       pwd: "tonyrong",
 *       roles: [
 *                 { role: "userAdmin", db: "test" },
 *                 { role: "readWrite", db: "test" },
 *                 { role: "dbAdmin",   db: "test" }
 *              ]
 *   });
 * 2.  in mongodb.conf
 * security:
 *     authorization: 'enabled'
 */
//@Document(collation = "Customer")
public class Customer {
    @Id
    public String id;
    public String firstName;
    public String lastName;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
