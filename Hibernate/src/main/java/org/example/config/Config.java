package org.example.config;

import org.example.entities.Person;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.HashMap;
import java.util.Map;


public class Config {
//    public static Session getSession() {
//        SessionFactory factory = null;
//        try{
//            factory = new Configuration().configure().buildSessionFactory();
//        } catch (HibernateException exception) {
//            exception.printStackTrace();
//        }
//        return factory.openSession();
//    }

    public static Session getSession() {
        Map<String, String> settings = new HashMap<>();
        settings.put("connection.driver_class", "org.postgresql.Driver");
        settings.put("dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
        settings.put("hibernate.connection.url",
                "jdbc:postgresql://localhost:5432/bootcamp");
        settings.put("hibernate.connection.username", "postgres");
        settings.put("hibernate.connection.password", "postgresroot");
        settings.put("hibernate.show_sql", "true");
        settings.put("hibernate.format_sql", "true");
        settings.put("hibernate.connection.autocommit", "true");
//                <property name="hibernate.connection.autocommit" value="false"/>
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(settings).build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        metadataSources.addAnnotatedClass(Person.class);
        Metadata metadata = metadataSources.buildMetadata();

        // here we build the SessionFactory (Hibernate 5.4)
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        return session;
    }


}
