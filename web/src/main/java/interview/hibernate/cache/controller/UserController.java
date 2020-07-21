package interview.hibernate.cache.controller;

import interview.hibernate.cache.model.User;
import interview.hibernate.cache.service.UserService;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cache")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return userService.getUser(id);
    }
    @GetMapping("/user2/{id}")
    public User getUserById2(@PathVariable("id") Long id){
        return userService.getUser2(id);
    }

    /**
     * get Cache content by cache key
     * @return
     */
    @GetMapping("/user/getCache")
    public Integer getUserCache(){
        int size = CacheManager.ALL_CACHE_MANAGERS.get(0)
                .getCache("usersCache").getSize();

        return size;
    }
}
