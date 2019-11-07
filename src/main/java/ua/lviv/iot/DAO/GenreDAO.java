package ua.lviv.iot.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ua.lviv.iot.model.FilmEntity;
import ua.lviv.iot.model.GenreEntity;

import java.util.List;

public class GenreDAO implements GeneralDAO<GenreEntity> {
    private static SessionFactory sessionFactory;

    public GenreDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void findAll() {
        Session session = sessionFactory.openSession();
        Query query =  session.createQuery("FROM GenreEntity");
        for (Object obj : query.list()) {
            print((GenreEntity) obj);
        }
        session.close();
    }

    @Override
    public void findById(Integer id) {
        Session session = sessionFactory.openSession();
        print(session.get(GenreEntity.class, id));
    }

    @Override
    public void create(GenreEntity newItem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(newItem);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Integer id, GenreEntity newItem) {
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
        GenreEntity entity = session.get(GenreEntity.class, id);
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public void print(GenreEntity entity) {
        System.out.println("Genre " + entity.getId() + ": " + entity.getName());
        System.out.println("Films with this genre:");
        List<FilmEntity> filmEntityList = entity.getFilms();
        for (FilmEntity obj : filmEntityList) {
            System.out.println(obj.getTitle());
        }
    }
}
