package interview.hibernate.cache.dao;

import interview.hibernate.cache.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User getUserById(Long id);
}
