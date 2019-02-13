package sa.edu.ksu.ftc_backend.Event.Service;
import sa.edu.ksu.ftc_backend.Event.Event;
import sa.edu.ksu.ftc_backend.Event.EventStatus;
import sa.edu.ksu.ftc_backend.Event.EventType;

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
