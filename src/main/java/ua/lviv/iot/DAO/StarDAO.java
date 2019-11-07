package ua.lviv.iot.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ua.lviv.iot.model.StarEntity;

public class StarDAO implements GeneralDAO<StarEntity> {
    private static SessionFactory sessionFactory;

    public StarDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void findAll() {
        Session session = sessionFactory.openSession();
        Query query =  session.createQuery("FROM StarEntity");
        for (Object obj : query.list()) {
            print((StarEntity) obj);
        }
        session.close();
    }

    @Override
    public void findById(Integer id) {
        Session session = sessionFactory.openSession();
        print(session.get(StarEntity.class, id));
    }

    @Override
    public void create(StarEntity newItem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(newItem);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Integer id, StarEntity newItem) {
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
        StarEntity entity = session.get(StarEntity.class, id);
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public void print(StarEntity entity) {
        System.out.println("Star " + entity.getId() +
                ":\nFirst name: " + entity.getFirstName() +
                "\nLast name: " + entity.getLastName() +
                "\nAge: " + entity.getAge());
    }
}
