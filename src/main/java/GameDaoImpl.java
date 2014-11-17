
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class GameDaoImpl implements GameDao {
    private Session session;

    public GameDaoImpl() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public void save(Game game) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.save(game);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<Game> getAll() {
        List<Game> objects = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            objects = (ArrayList) session.createCriteria(Game.class).list();
            session.getTransaction().commit();
            return objects;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return objects;
    }

    public void update(Game game) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.saveOrUpdate(game);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void delete(Game game) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.delete(game);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Game getById(int id) {
        Game res = null;
        try {
            session.beginTransaction();
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            res = (Game) session.get(Game.class, id);
            session.save(res);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return res;
    }

    public int getLastId() {
        List<Game> games = getAll();
        return games.get(games.size() - 1).getGame_id();
    }

}

