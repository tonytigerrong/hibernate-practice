package interview.hibernate.cache.service;

import interview.hibernate.cache.dao.UserRepo;
import interview.hibernate.cache.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Environment;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
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
     * TODO： this cache not work!!
     * setCacheable(true) / setCacheRegion : same result with @cacheable
     * @param id
     * @return
     */
    //@Cacheable(value="usersCache2", key="#id")
    public User getUser2(Long id){
        logger.info("getUser2: extract user={} from db",id); // only show 1 time if, for same id query
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("From User where id=:id").setParameter("id",id);
        List<User> users = query
                                .setCacheable(true)
                                .setCacheRegion("usersCache2")
                                .list();
        /*
        List<User> users = entityManager.createQuery("From User where id=:id")
                                .setHint("org.hibernate.cacheable",true)

                                .setParameter("id", id)
                                .getResultList();

         */
        if( users.size() == 1 ) return users.get(0);
        else return null;
    }
    public User getUser3(Long id){
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(User.class)
                ;
        Criterion idCriterion = Restrictions.eq("id",id);
        Criterion nameCriterion = Restrictions.eq("username","Smith");

        LogicalExpression le = Restrictions.and(idCriterion,nameCriterion);
        criteria.add(le);

        List<User> users = criteria.list();
        return  users.size() > 0 ? users.get(0) : null;

    }
    public List<User> getAllUser(Integer pagenum){
        int pageSize = 2;
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("From User");
        query.setFirstResult(pageSize*(pagenum-1));
        query.setMaxResults(pageSize);
        return query.getResultList();
    }
    @Transactional
    public void addUser(User user){
        Session session = entityManager.unwrap(Session.class);
        //Transaction tx = session.getTransaction();
        session.merge(user);
        //tx.commit();
    }
}
