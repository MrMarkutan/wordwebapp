package vision.integrity.wordwebgame.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vision.integrity.wordwebgame.domain.Words;

@Repository
public interface GameCheckerRepository extends CrudRepository<Words, Long> {
}
