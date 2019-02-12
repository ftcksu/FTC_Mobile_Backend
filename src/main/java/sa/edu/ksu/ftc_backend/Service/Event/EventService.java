package sa.edu.ksu.ftc_backend.Service.Event;
import sa.edu.ksu.ftc_backend.Model.Event;
import sa.edu.ksu.ftc_backend.Model.EventStatus;
import sa.edu.ksu.ftc_backend.Model.EventType;

import java.util.Optional;

public interface EventService {
    public Event save(Event event);
    public Optional<Event> findById(Integer id);
    public Event update(Event event);
    public void delete(Integer id);
    public Iterable<Event> getEventsByStatus(EventStatus status);
    public Iterable<Event> getEventsByType(EventType type);
    public Iterable<Event> findByStatusAndType(EventStatus status, EventType type);

}
