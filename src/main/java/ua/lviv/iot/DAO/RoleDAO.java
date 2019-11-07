package ua.lviv.iot.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ua.lviv.iot.model.RoleEntity;
import ua.lviv.iot.model.RoleEntityPK;

public class RoleDAO implements GeneralJunctionDAO<RoleEntity> {
    private static SessionFactory sessionFactory;

    public RoleDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void findAll() {
        Session session = sessionFactory.openSession();
        Query query =  session.createQuery("FROM RoleEntity");
        for (Object obj : query.list()) {
            print((RoleEntity) obj);
        }
        session.close();
    }

    @Override
    public void findById(Integer id1, Integer id2) {
        Session session = sessionFactory.openSession();
        print(session.get(RoleEntity.class, new RoleEntityPK(id1, id2)));
    }

    @Override
    public void create(RoleEntity newItem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(newItem);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Integer id1, Integer id2, RoleEntity newItem) {
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
        RoleEntity entity = session.get(RoleEntity.class, new RoleEntityPK(id1, id2));
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    public void print(RoleEntity entity) {
        System.out.println("Film " + entity.getFilmId() +
                " has star " + entity.getStarId() +
                " with role " + entity.getRole());
    }
}
