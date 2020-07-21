package interview.hibernate.cache.config;

import interview.hibernate.cache.model.User;
import interview.hibernate.cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class Init {
    @Autowired
    private UserService userService;
    @Bean
    public void initUserData(){
        User user1 = new User("David","password2");
        User user2 = new User("Smith","password2");

        User user3 = new User("Philip","password2");
        User user4 = new User("Robin","password2");

        User user5 = new User("Iron","password2");
        User user6 = new User("Apple","password2");


        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4);
        userService.addUser(user5);
        userService.addUser(user6);
    }
}
