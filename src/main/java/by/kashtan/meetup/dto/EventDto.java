package by.kashtan.meetup.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    private Long eventId;
    private String topic;
    private String description;
    private String organizer;
    private Timestamp date;
    private String location;
}
