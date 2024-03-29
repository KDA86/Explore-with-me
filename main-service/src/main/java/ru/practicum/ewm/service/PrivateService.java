package ru.practicum.ewm.service;

import org.springframework.data.domain.PageRequest;
import ru.practicum.ewm.dto.*;
import ru.practicum.ewm.exception.ConflictException;
import ru.practicum.ewm.exception.ValidationException;
import ru.practicum.ewm.model.Comment;
import ru.practicum.ewm.model.ParticipationRequest;

import java.util.List;

public interface PrivateService {

    EventFullDto createEvent(Long userId, NewEventDto newEventDto) throws ConflictException, ValidationException;

    List<EventShortDto> getEventsByUser(Long userId, PageRequest pageRequest) throws ValidationException;

    EventFullDto getEventByUser(Long userId, Long eventId) throws ValidationException;

    EventFullDto updateEvent(Long userId, Long eventId, UpdateEventUserRequest updateEventUserRequest) throws ConflictException, ValidationException;

    ParticipationRequest createRequest(Long userId, Long eventId) throws ConflictException;

    List<ParticipationRequest> getRequestsByUser(Long userId);

    ParticipationRequest updateRequest(Long userId, Long requestId);

    List<ParticipationRequest> getRequestsOnEventByUser(Long userId, Long eventId);

    EventRequestStatusUpdateResult updateStatusRequest(Long userId, Long eventId, EventRequestStatusUpdateRequest eventRequestStatusUpdateRequest) throws ConflictException;

    Comment createComment(Long userId, Long eventId, NewCommentDto newCommentDto);

    List<Comment> getCommentsByUser(Long userId);

    Comment updateCommentByUser(Long userId, Long commentId, NewCommentDto newCommentDto);

    List<Comment> getCommentsByEvent(Long eventId) throws ConflictException;

    void deleteComment(Long commentId);
}