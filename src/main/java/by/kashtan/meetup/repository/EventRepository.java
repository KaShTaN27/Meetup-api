package by.kashtan.meetup.repository;

import by.kashtan.meetup.model.Event;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EventRepository {

    private final SessionFactory sessionFactory;

    public Event save(Event event) {
        Event savedEvent;
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.save(event);
            savedEvent = (Event) session.createQuery("from event WHERE description = :description")
                    .setParameter("description", event.getDescription())
                    .uniqueResult();
            session.getTransaction().commit();
        }
        return savedEvent;
    }

    public Optional<Event> findById(Long id) {
        Event event;
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            event = session.get(Event.class, id);
            session.getTransaction().commit();
        }
        return Optional.ofNullable(event);
    }

    public Optional<Event> findByDescription(String description) {
        Event event;
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            event = (Event) session.createQuery("from event WHERE description = :description")
                    .setParameter("description", description)
                    .uniqueResult();
            session.getTransaction().commit();
        }
        return Optional.ofNullable(event);
    }

    public List<Event> findAll() {
        List<Event> events = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            events.addAll(session.createQuery("From event").list());
            session.getTransaction().commit();
        }
        return events;
    }

    public Event update(Event event) {
        Event updatedEvent;
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.update(event);
            updatedEvent = session.get(Event.class, event.getId());
            session.getTransaction().commit();
        }
        return updatedEvent;
    }

    public Event deleteById(Event event) {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.delete(event);
            session.getTransaction().commit();
        }
        return event;
    }

    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }

    public boolean existsByDescription(String description) {
        return findByDescription(description).isPresent();
    }
}
