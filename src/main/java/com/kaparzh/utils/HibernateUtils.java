package com.kaparzh.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtils {

    private HibernateUtils() {
    }

    private static final SessionFactory sessionFactory = new Configuration()
            .configure()
            .buildSessionFactory();

    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
