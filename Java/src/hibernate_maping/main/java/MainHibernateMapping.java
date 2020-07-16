import entity.Comment;
import entity.Post;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class MainHibernateMapping {
    public static void main(String[] args) {
        Post post = new Post();

        post.setTitle("Post");

        Comment comment1 = new Comment("Sasha", post);

        Comment comment2 = new Comment("Ivan", post);

        Set<Comment> comments = new HashSet<>();
        comments.add(comment1);
        comments.add(comment2);

        post.setComments(comments);

        Session session = null;

        Transaction tx = null;

        session = HibernateUtil.getSession();


        tx = session.beginTransaction();


        session.save(post);

        session.save(comment1);

        session.save(comment2);

        tx.commit();
    }
}
