package interview.hibernate.cache.service;

import interview.hibernate.cache.dao.UserRepo;
import interview.hibernate.cache.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    private static Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserRepo userRepo;
    @Autowired
    EntityManager entityManager;

    /**
     * @cacheable: 1st time, hit the db, after that will not query user from db, using cache
     * @param id
     * @return
     */
    @Cacheable(value="usersCache", key="#id")
    public User getUser(Long id){
        logger.info("getUser: extract user={} from db",id); // only show 1 time if, for same id query
        return userRepo.getUserById(id);
    }

    /**
     * setCacheable(true) / setCacheRegion : same result with @cacheable
     * @param id
     * @return
     */
    @Cacheable(value="usersCache2", key="#id")
    public User getUser2(Long id){
        logger.info("getUser2: extract user={} from db",id); // only show 1 time if, for same id query
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("From User where id=:id").setParameter("id",id);
        List<User> users = query.setCacheable(true).setCacheRegion("user").list();
        if(users.size() == 1) return users.get(0);
        else return null;
    }
    @Transactional
    public void addUser(User user){
        Session session = entityManager.unwrap(Session.class);
        //Transaction tx = session.getTransaction();
        session.merge(user);
        //tx.commit();
    }
}
