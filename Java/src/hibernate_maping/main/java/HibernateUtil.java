import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static Session session;

    private static Session buildSession() {

        Configuration cfg = new Configuration();

        cfg.configure();

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();

        Session session = cfg.configure("hibernate.cfg.xml").buildSessionFactory(serviceRegistry).openSession();

        return session;

    }

    public static Session getSession() {

        if (session == null)

            session = buildSession();

        return session;
    }
}
