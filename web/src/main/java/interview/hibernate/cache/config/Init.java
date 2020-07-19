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
        User user1 = new User("David","password1");
        User user2 = new User("Smith","password2");
        userService.addUser(user1);
        userService.addUser(user2);
    }
}
