package com.kaparzh.repository.impl;

import com.kaparzh.model.File;
import com.kaparzh.repository.FileRepository;
import com.kaparzh.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public final class FileRepositoryImpl implements FileRepository {

    private static final FileRepositoryImpl INSTANCE = new FileRepositoryImpl();

    private FileRepositoryImpl() {
    }

    public static FileRepositoryImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public File save(File file) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(file);
            transaction.commit();
        }
        return file;
    }

    @Override
    public File update(File file) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(file);
            transaction.commit();
            return file;
        }
    }

    @Override
    public void deleteById(Integer id) {
        try (Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            File file = session.get(File.class, id);
            session.remove(file);
            transaction.commit();
        }
    }

    @Override
    public File getById(Integer id) {
        try (Session session = HibernateUtils.getSession()) {
            return session.get(File.class, id);
        }
    }

    @Override
    public List<File> getAll() {
        try (Session session = HibernateUtils.getSession()) {
            return session.createQuery("FROM File", File.class).getResultList();
        }
    }
}
