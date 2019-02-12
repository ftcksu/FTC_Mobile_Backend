package sa.edu.ksu.ftc_backend.Repository;

import org.springframework.data.repository.CrudRepository;
import sa.edu.ksu.ftc_backend.Model.Event;
import sa.edu.ksu.ftc_backend.Model.EventStatus;
import sa.edu.ksu.ftc_backend.Model.EventType;

import java.util.List;

public interface EventRepository extends CrudRepository<Event,Integer> {

    public List<Event> findByStatus(EventStatus status);
    public List<Event> findByType(EventType type);
    public List<Event> findByStatusAndType(EventStatus status, EventType type);

}
