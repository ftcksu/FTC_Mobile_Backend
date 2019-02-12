package sa.edu.ksu.ftc_backend.Service.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sa.edu.ksu.ftc_backend.Model.Event;
import sa.edu.ksu.ftc_backend.Model.EventStatus;
import sa.edu.ksu.ftc_backend.Model.EventType;
import sa.edu.ksu.ftc_backend.Repository.EventRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
public class EventServiceImp implements EventService {

    EventRepository eventRepository;

    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event save(@Valid Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Optional<Event> findById(@NotNull Integer id) {
        return eventRepository.findById(id);
    }

    @Override
    public Event update(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void delete(Integer id) {
        eventRepository.deleteById(id);
    }

    @Override
    public Iterable<Event> getEventsByStatus(EventStatus status) {
        return eventRepository.findByStatus(status);
    }

    @Override
    public Iterable<Event> getEventsByType(EventType type){
        return eventRepository.findByType(type);
    }

    public Iterable<Event> findByStatusAndType(EventStatus status, EventType type){
        return eventRepository.findByStatusAndType(status, type);
    }

}

