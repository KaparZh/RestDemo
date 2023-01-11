package com.kaparzh.service;

import com.kaparzh.model.Event;

public interface EventService extends GenericService<Event, Integer> {

    Event create(Integer userId, Integer fileId);

    Event update(Integer id, Integer userId, Integer fileId);
}
