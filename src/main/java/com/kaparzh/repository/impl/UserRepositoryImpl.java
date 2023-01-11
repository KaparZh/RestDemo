package com.kaparzh.repository.impl;

import com.kaparzh.model.User;
import com.kaparzh.repository.UserRepository;
import com.kaparzh.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public final class UserRepositoryImpl implements UserRepository {

    private static final UserRepositoryImpl INSTANCE = new UserRepositoryImpl();

    private UserRepositoryImpl() {
    }

    public static UserRepositoryImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public User save(User user) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
            return user;
        }
    }

    @Override
    public User update(User user) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(user);
            transaction.commit();
            return user;
        }
    }

    @Override
    public void deleteById(Integer id) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            session.remove(user);
            transaction.commit();
        }
    }

    @Override
    public User getById(Integer id) {
        try (Session session = HibernateUtils.getSession()) {
            return session.get(User.class, id);
        }
    }

    @Override
    public List<User> getAll() {
        try (Session session = HibernateUtils.getSession()) {
            return session.createQuery("FROM User", User.class).getResultList();
        }
    }
}
