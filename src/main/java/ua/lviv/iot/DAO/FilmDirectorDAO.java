package ua.lviv.iot.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ua.lviv.iot.model.FilmDirectorEntity;
import ua.lviv.iot.model.FilmDirectorEntityPK;

public class FilmDirectorDAO implements GeneralJunctionDAO<FilmDirectorEntity> {
    private static SessionFactory sessionFactory;

    public FilmDirectorDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void findAll() {
        Session session = sessionFactory.openSession();
        Query query =  session.createQuery("FROM FilmDirectorEntity");
        for (Object obj : query.list()) {
            print((FilmDirectorEntity) obj);
        }
        session.close();
    }

    @Override
    public void findById(Integer id1, Integer id2) {
        Session session = sessionFactory.openSession();
        print(session.get(FilmDirectorEntity.class, new FilmDirectorEntityPK(id1, id2)));
    }

    @Override
    public void create(FilmDirectorEntity newItem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(newItem);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Integer id1, Integer id2, FilmDirectorEntity newItem) {
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
        FilmDirectorEntity entity = session.get(FilmDirectorEntity.class, new FilmDirectorEntityPK(id1, id2));
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public void print(FilmDirectorEntity entity) {
        System.out.println("Film " + entity.getFilmId() +
                " has director " + entity.getDirectorId());
    }
}
