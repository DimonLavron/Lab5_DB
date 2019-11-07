package ua.lviv.iot.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ua.lviv.iot.model.BoxOfficeEntity;
import ua.lviv.iot.model.BoxOfficeEntityPK;

public class BoxOfficeDAO implements GeneralJunctionDAO<BoxOfficeEntity> {
    private static SessionFactory sessionFactory;

    public BoxOfficeDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void findAll() {
        Session session = sessionFactory.openSession();
        Query query =  session.createQuery("FROM BoxOfficeEntity");
        for (Object obj : query.list()) {
            print((BoxOfficeEntity) obj);
        }
        session.close();
    }

    @Override
    public void findById(Integer id1, Integer id2) {
        Session session = sessionFactory.openSession();
        print(session.get(BoxOfficeEntity.class, new BoxOfficeEntityPK(id1, id2)));
    }

    @Override
    public void create(BoxOfficeEntity newItem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(newItem);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Integer id1, Integer id2, BoxOfficeEntity newItem) {
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
        BoxOfficeEntity entity = session.get(BoxOfficeEntity.class, new BoxOfficeEntityPK(id1, id2));
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public void print(BoxOfficeEntity entity) {
        System.out.println("Film " + entity.getFilmId() +
                " earned " + entity.getBoxOffice() +
                "$ in country " + entity.getCountryId());
    }
}
