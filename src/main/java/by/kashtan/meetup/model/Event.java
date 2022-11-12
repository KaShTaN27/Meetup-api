package by.kashtan.meetup.model;

import by.kashtan.meetup.dto.EventDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity(name = "event")
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String topic;

    private String description;

    private String organizer;

    private Timestamp date;

    private String location;

    public Event(EventDto eventDto) {
        this.id = eventDto.getEventId();
        this.topic = eventDto.getTopic();
        this.description = eventDto.getDescription();
        this.organizer = eventDto.getOrganizer();
        this.date = eventDto.getDate();
        this.location = eventDto.getLocation();
    }
}
