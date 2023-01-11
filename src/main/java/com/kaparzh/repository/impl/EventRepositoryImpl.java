package com.kaparzh.repository.impl;

import com.kaparzh.model.Event;
import com.kaparzh.repository.EventRepository;
import com.kaparzh.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public final class EventRepositoryImpl implements EventRepository {

    private static final EventRepositoryImpl INSTANCE = new EventRepositoryImpl();

    private EventRepositoryImpl() {
    }

    public static EventRepositoryImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public Event save(Event event) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(event);
            transaction.commit();
            return event;
        }
    }

    @Override
    public Event update(Event event) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(event);
            transaction.commit();
            return event;
        }
    }

    @Override
    public void deleteById(Integer id) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            Event event = session.get(Event.class, id);
            session.remove(event);
            transaction.commit();
        }
    }

    @Override
    public Event getById(Integer id) {
        try (Session session = HibernateUtils.getSession()) {
            return session.get(Event.class, id);
        }
    }

    @Override
    public List<Event> getAll() {
        try (Session session = HibernateUtils.getSession()) {
            return session.createQuery("FROM Event", Event.class).getResultList();
        }
    }
}
