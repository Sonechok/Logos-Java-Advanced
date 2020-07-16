import entity.Cart;
import entity.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.HashSet;
import java.util.Set;

public class MainHibernate {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
        registry.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = registry.buildServiceRegistry();

        // builds a session factory from the service registry
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(serviceRegistry);

        // obtains the session
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Cart cart1 = new Cart(1, "Cart1");
        Cart cart2 = new Cart(2, "Cart2");

        Item item1 = new Item(3);
        Item item2 = new Item(4);

        Set<Item> items1 = new HashSet<>();
        items1.add(item1);
        items1.add(item2);

        Set<Item> items = new HashSet<>();
        items.add(item1);

        cart1.setItemSet(items1);
        cart2.setItemSet(items);

        session.save(cart1);
        session.save(cart2);

        session.getTransaction().commit();
        session.close();
        /*Cart cart = new Cart(1, "entity.Cart");
        Item item1 = new Item(3);
        Item item2 = new Item(4);
        Set<Item> items = new HashSet<>();
        items.add(item1);
        items.add(item2);
        Set<Cart> carts = new HashSet<>();
        carts.add(cart);

        cart.setItemSet(items);
        item1.setCartSet(carts);

        Session session = null;

        Transaction tx = null;

        session = HibernateUtil.getSession();

        tx = session.beginTransaction();


        session.save(carts);

        session.save(item1);

        session.save(item2);

        tx.commit();*/
    }
}
