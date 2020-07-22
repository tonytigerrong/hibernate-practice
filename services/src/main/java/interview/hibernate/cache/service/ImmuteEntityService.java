package interview.hibernate.cache.service;

import interview.hibernate.cache.dao.ImmuteEntityRepo;
import interview.hibernate.cache.model.ImmuteEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class ImmuteEntityService {
    @Autowired
    ImmuteEntityRepo immuteEntityRepo;

    @Autowired
    EntityManager entityManager;

    @Transactional
    public void addImmuteEntity(ImmuteEntity entity){
        Session session = entityManager.unwrap(Session.class);
        session.persist(entity);
    }
}
