package ua.lviv.iot.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ua.lviv.iot.model.DirectorEntity;


public class DirectorDAO implements GeneralDAO<DirectorEntity> {
    private static SessionFactory sessionFactory;

    public DirectorDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void findAll() {
        Session session = sessionFactory.openSession();
        Query query =  session.createQuery("FROM DirectorEntity");
        for (Object obj : query.list()) {
            print((DirectorEntity) obj);
        }
        session.close();
    }

    @Override
    public void findById(Integer id) {
        Session session = sessionFactory.openSession();
        print(session.get(DirectorEntity.class, id));
    }

    @Override
    public void create(DirectorEntity newItem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(newItem);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Integer id, DirectorEntity newItem) {
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
        DirectorEntity entity = session.get(DirectorEntity.class, id);
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public void print(DirectorEntity entity) {
        System.out.println("Director " + entity.getId() +
                ":\nFirst name: " + entity.getFirstName() +
                "\nLast name: " + entity.getLastName());
    }
}
