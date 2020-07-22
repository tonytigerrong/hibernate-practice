package interview.hibernate.cache.dao;

import interview.hibernate.cache.model.ImmuteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImmuteEntityRepo extends JpaRepository<ImmuteEntity,Long> {
    ImmuteEntity findImmuteEntityById(Long id);
}
