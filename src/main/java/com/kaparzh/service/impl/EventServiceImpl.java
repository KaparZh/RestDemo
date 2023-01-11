package com.kaparzh.service.impl;

import com.kaparzh.model.Event;
import com.kaparzh.model.File;
import com.kaparzh.model.User;
import com.kaparzh.repository.impl.EventRepositoryImpl;
import com.kaparzh.repository.impl.FileRepositoryImpl;
import com.kaparzh.repository.impl.UserRepositoryImpl;
import com.kaparzh.service.EventService;

import java.util.List;

public final class EventServiceImpl implements EventService {

    private static final EventServiceImpl INSTANCE = new EventServiceImpl();

    private final EventRepositoryImpl eventRepository = EventRepositoryImpl.getInstance();
    private final FileRepositoryImpl fileRepository = FileRepositoryImpl.getInstance();
    private final UserRepositoryImpl userRepository = UserRepositoryImpl.getInstance();

    private EventServiceImpl() {
    }

    public static EventServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public Event getById(Integer id) {
        return eventRepository.getById(id);
    }

    @Override
    public void delete(Integer id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<Event> getAll() {
        return eventRepository.getAll();
    }

    @Override
    public Event create(Integer userId, Integer fileId) {
        User user = userRepository.getById(userId);
        File file = fileRepository.getById(fileId);
        return eventRepository.save(new Event(user, file));
    }

    @Override
    public Event update(Integer id, Integer userId, Integer fileId) {
        User user = userRepository.getById(userId);
        File file = fileRepository.getById(fileId);
        return eventRepository.update(new Event(id, user, file));
    }
}
