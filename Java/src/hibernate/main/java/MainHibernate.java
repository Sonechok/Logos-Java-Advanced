import entity.Cart;
import entity.Item;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import repository.CartRepository;

public class MainHibernate {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        CartRepository cartRepository = new CartRepository(sessionFactory);
        Cart cart = new Cart(2, "CART");
        cart.addItem(new Item(3));
        cart.addItem(new Item(6));
        cart.addItem(new Item(1));
        cart.addItem(new Item(5));
        cartRepository.save(cart);
    }
}
