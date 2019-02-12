package sa.edu.ksu.ftc_backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import sa.edu.ksu.ftc_backend.Model.Event;
import sa.edu.ksu.ftc_backend.Model.EventStatus;
import sa.edu.ksu.ftc_backend.Model.EventType;
import sa.edu.ksu.ftc_backend.Service.Event.EventService;

import javax.validation.Valid;

@RestController
@RequestMapping("event")
public class EventController {

    EventService eventService;

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity createEvent(@RequestBody @Valid Event event) {
        return new ResponseEntity(eventService.save(event), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity updateAccount(@RequestBody Event event) {
        return new ResponseEntity(eventService.update(event), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEvent(@PathVariable("id") Integer id) {
        //TODO handle authorization (admin)

        eventService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getEvent(@PathVariable("id") Integer id) {
        return new ResponseEntity(eventService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getEventsByStatus(@RequestParam(value = "status", required = false) EventStatus status,
                                            @RequestParam(value = "type", required = false) EventType type) {

        if (status != null && type != null) { // get both
            return new ResponseEntity(eventService.findByStatusAndType(status, type), HttpStatus.OK);
        } else if (status != null) {
            return new ResponseEntity(eventService.getEventsByStatus(status), HttpStatus.OK);
        } else if (type != null) {
            return new ResponseEntity(eventService.getEventsByType(type), HttpStatus.OK);
        }

        return new ResponseEntity("Please provide a parameter", HttpStatus.BAD_REQUEST);
    }


}
