package ua.lviv.iot.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ua.lviv.iot.model.CountryEntity;

public class CountryDAO implements GeneralDAO<CountryEntity> {
    private static SessionFactory sessionFactory;

    public CountryDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void findAll() {
        Session session = sessionFactory.openSession();
        Query query =  session.createQuery("FROM CountryEntity");
        for (Object obj : query.list()) {
            print((CountryEntity) obj);
        }
        session.close();
    }

    @Override
    public void findById(Integer id) {
        Session session = sessionFactory.openSession();
        print(session.get(CountryEntity.class, id));
    }

    @Override
    public void create(CountryEntity newItem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(newItem);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Integer id, CountryEntity newItem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        newItem.setId(id);
        session.update(newItem);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CountryEntity entity = session.get(CountryEntity.class, id);
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public void print(CountryEntity entity) {
        System.out.println("Country " + entity.getId() + ": " + entity.getName());
    }
}
