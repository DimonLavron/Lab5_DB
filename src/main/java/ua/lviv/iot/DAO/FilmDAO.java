package ua.lviv.iot.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ua.lviv.iot.model.FilmEntity;

import java.text.SimpleDateFormat;

public class FilmDAO implements GeneralDAO<FilmEntity> {
    private static SessionFactory sessionFactory;

    public FilmDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void findAll() {
        Session session = sessionFactory.openSession();
        Query query =  session.createQuery("FROM FilmEntity");
        for (Object obj : query.list()) {
            print((FilmEntity) obj);
        }
        session.close();
    }

    @Override
    public void findById(Integer id) {
        Session session = sessionFactory.openSession();
        print(session.get(FilmEntity.class, id));
    }

    @Override
    public void create(FilmEntity newItem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(newItem);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Integer id, FilmEntity newItem) {
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
        FilmEntity entity = session.get(FilmEntity.class, id);
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public void print(FilmEntity entity) {
        System.out.println("Film " + entity.getId() +
                ":\nTitle: " + entity.getTitle() +
                "\nRunning time: " + entity.getRunningTime() + " mins\nRelease date: " +
                new SimpleDateFormat("dd.MM.yyyy").format(entity.getReleaseDate()));
    }
}
