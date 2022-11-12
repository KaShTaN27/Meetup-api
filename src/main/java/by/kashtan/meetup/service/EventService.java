package by.kashtan.meetup.service;

import by.kashtan.meetup.exception.ResourceAlreadyExistsException;
import by.kashtan.meetup.exception.ResourceNotFoundException;
import by.kashtan.meetup.model.Event;
import by.kashtan.meetup.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(id));
    }

    public Event saveEvent(Event event) {
        if (eventRepository.existsByDescription(event.getDescription()))
            throw new ResourceAlreadyExistsException(event.getDescription());
        return eventRepository.save(event);
    }

    public Event updateEvent(Event event) {
        if (!eventRepository.existsById(event.getId()))
            throw new ResourceNotFoundException(event.getId());
        return eventRepository.update(event);
    }

    public Event deleteEvent(Long id) {
        Event deletingEvent = getEventById(id);
        return eventRepository.deleteById(deletingEvent);
    }
}
