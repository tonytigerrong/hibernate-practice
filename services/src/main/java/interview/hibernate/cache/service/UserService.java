package interview.hibernate.cache.service;

import interview.hibernate.cache.dao.UserRepo;
import interview.hibernate.cache.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

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
        logger.info("extract user={} from db",id); // only show 1 time if, for same id query
        return userRepo.getUserById(id);
    }
    @Transactional
    public void addUser(User user){
        Session session = entityManager.unwrap(Session.class);
        //Transaction tx = session.getTransaction();
        session.merge(user);
        //tx.commit();
    }
}
