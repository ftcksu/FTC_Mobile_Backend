package sa.edu.ksu.ftc_backend.Repository;

import org.springframework.data.repository.CrudRepository;
import sa.edu.ksu.ftc_backend.Model.Event;

public interface EventRepository extends CrudRepository<Event,Integer> {
}
