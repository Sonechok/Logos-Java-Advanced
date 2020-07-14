package repository;

import entity.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CartRepository {
    private final SessionFactory sessionFactory;

    public CartRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Cart save(Cart cart) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(cart);
            session.evict(cart);
            transaction.commit();
            return cart;
        }
    }
}
