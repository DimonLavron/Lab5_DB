package ua.lviv.iot.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ua.lviv.iot.model.FilmGenreEntity;
import ua.lviv.iot.model.FilmGenreEntityPK;

public class FilmGenreDAO implements GeneralJunctionDAO<FilmGenreEntity> {
    private static SessionFactory sessionFactory;

    public FilmGenreDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void findAll() {
        Session session = sessionFactory.openSession();
        Query query =  session.createQuery("FROM FilmGenreEntity");
        for (Object obj : query.list()) {
            print((FilmGenreEntity) obj);
        }
        session.close();
    }

    @Override
    public void findById(Integer id1, Integer id2) {
        Session session = sessionFactory.openSession();
        print(session.get(FilmGenreEntity.class, new FilmGenreEntityPK(id1, id2)));
    }

    @Override
    public void create(FilmGenreEntity newItem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(newItem);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Integer id1, Integer id2, FilmGenreEntity newItem) {
        delete(id1, id2);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(newItem);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Integer id1, Integer id2) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        FilmGenreEntity entity = session.get(FilmGenreEntity.class, new FilmGenreEntityPK(id1, id2));
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public void print(FilmGenreEntity entity) {
        System.out.println("Film " + entity.getFilmId() +
                " has genre " + entity.getGenreId());
    }
}
