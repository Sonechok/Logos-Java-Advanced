package jpa.repository.impl;

import jpa.config.ManagerFactory;
import jpa.entity.User;
import jpa.repository.UserRepository;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private static final Logger log = Logger.getLogger(UserRepositoryImpl.class);

    private static UserRepositoryImpl instance;

    private EntityManager em;

    private UserRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    public static UserRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new UserRepositoryImpl(ManagerFactory.createEntityManager());
        }
        return instance;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        TypedQuery<User> query = em.createQuery("select * from users where email = ?", User.class);
        query.setParameter(1, email);
        User user = query.getSingleResult();
        return Optional.ofNullable(user);
    }

    @Override
    public void save(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }


    @Override
    public void update(User user) {
        em.getTransaction().begin();
        Query query = em.createQuery("insert into User(firstName, lastName, email, role, password, course) values (?, ?, ?, ?, ?, ?)");
        query.setParameter(1, user.getFirstName());
        query.setParameter(2, user.getLastName());
        query.setParameter(3, user.getEmail());
        query.setParameter(4, user.getRole());
        query.setParameter(5, user.getPassword());
        query.setParameter(6, user.getCourse());
        em.getTransaction().commit();
    }

    @Override
    public List<User> findAll() {
        Query query = em.createQuery("select u from User u");
        List<User> result = query.getResultList();
        return result;
    }

    @Override
    public Optional<User> findById(Integer id) {
        User user = em.find(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public void deleteById(Integer id) {
        em.getTransaction().begin();
        Query query = em.createQuery("delete from User u where u.id = ?");
        query.setParameter(1, id);
        em.getTransaction().commit();
    }
}