package interview.hibernate.cache.controller;

import interview.hibernate.cache.model.User;
import interview.hibernate.cache.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/cache")
public class UserController {
    @Autowired
    UserService userService;
    /**
     * Cache demo: annotation
     */
    @GetMapping("/user/{id}")
    @ApiOperation(value = "get user by user_id"
            ,notes = "provide an id to look uop user"
            ,response = User.class
    )
    public User getUserById(
            @ApiParam(value = "user input user-id to get user")
            @PathVariable("id") Long id){
        return userService.getUser(id);
    }

    /**
     * Cache demo: code
     * @param id
     * @return
     */
    @GetMapping("/user2/{id}")
    public User getUserById2(@PathVariable("id") Long id){
        return userService.getUser2(id);
    }
    /**
     * Criteria demo
     */
    @GetMapping("user3/{id}")
    public User getUserById3(@PathVariable("id") Long id){
        return userService.getUser3(id);
    }
    @GetMapping("users/{pagenum}")
    public List<User> getAllUser(@PathVariable("pagenum") Integer pagenum){
        return userService.getAllUser(pagenum);
    }
    @GetMapping("users/groupcount")
    public Long grougCount(){
        return userService.groupCount();
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
