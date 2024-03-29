package ru.practicum.ewm.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.ewm.dto.enums.State;
import ru.practicum.ewm.model.Category;
import ru.practicum.ewm.model.Location;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventFullDto {
    Long id;
    String annotation;
    Category category;
    Long confirmedRequests;
    String createdOn;
    String description;
    String eventDate;
    UserShortDto initiator;
    Location location;
    Boolean paid;
    Long participantLimit;
    String publishedOn;
    Boolean requestModeration;
    State state;
    String title;
    Long views;
}