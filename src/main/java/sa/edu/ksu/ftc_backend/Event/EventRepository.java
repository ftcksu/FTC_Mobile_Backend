package sa.edu.ksu.ftc_backend.Event;

import org.springframework.data.repository.CrudRepository;
import sa.edu.ksu.ftc_backend.Event.Event;
import sa.edu.ksu.ftc_backend.Event.EventStatus;
import sa.edu.ksu.ftc_backend.Event.EventType;

import java.util.List;

public interface EventRepository extends CrudRepository<Event,Integer> {

    public List<Event> findByStatus(EventStatus status);
    public List<Event> findByType(EventType type);
    public List<Event> findByStatusAndType(EventStatus status, EventType type);

}
