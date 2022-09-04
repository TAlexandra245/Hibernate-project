package org.example.hibernate;

import org.example.config.Config;
import org.example.entities.Person;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class PersonDAOHibernate {
    public void addPersons(Person person) {
        Session session = Config.getSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(person);
            tx.commit();
        } catch (HibernateException exception) {

            tx.rollback();

        } finally {
            session.close();
        }

    }
    /*public List<Person> getAllPersons() {
        Session session = Config.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Person.class);
            tx.commit();
            return criteria.list();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }*/
    /*public List<Person> getAllPersons() {
        Session session = Config.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
            Root<Person> root = criteriaQuery.from(Person.class);
            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("cnp"),"145"));
            Query query = session.createQuery(criteriaQuery);
            List<Person> result = query.getResultList();

            tx.commit();

            return query.getResultList();
        } catch (HibernateException exception) {

            tx.rollback();
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return  null;
        }*/

//    public Person getOne() {
//        Session session = Config.getSession();
//        Transaction transaction = null;
//        try {
//            transaction = session.beginTransaction();
//            Person person = session.find(Person.class, "123");
//            return person;
//        } catch (HibernateException e) {
//            transaction.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return null;
//    }
//        public void delete() {
//            Session session = Config.getSession();
//        Transaction transaction = null;
//        try {
//            transaction = session.beginTransaction();
//            Person person = session.find(Person.class, "123");
//            session.delete(person);
//
//            transaction.commit();
//        } catch (HibernateException e) {
//            transaction.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//
//        }
    }

